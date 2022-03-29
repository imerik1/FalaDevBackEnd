package br.ekerdev.faladev.service;

import br.ekerdev.faladev.core.domain.entities.PostEntity;
import br.ekerdev.faladev.core.domain.entities.ReplyEntity;
import br.ekerdev.faladev.core.domain.mappers.CreatePostMapper;
import br.ekerdev.faladev.core.domain.mappers.CreateReplyMapper;
import br.ekerdev.faladev.core.domain.mappers.PublicPostMapper;
import br.ekerdev.faladev.core.repositories.PostRepository;
import br.ekerdev.faladev.core.repositories.ReplyRepository;
import br.ekerdev.faladev.shared.dtos.CreatePostDto;
import br.ekerdev.faladev.shared.dtos.CreateReplyDto;
import br.ekerdev.faladev.shared.dtos.PublicPostDto;
import br.ekerdev.faladev.shared.enums.POST_STATS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    @Autowired
    private ReplyRepository replyRepository;

    public PublicPostDto createPost(CreatePostDto post) {
        PostEntity entity = new CreatePostMapper().mapFrom(post);
        PostEntity created = repository.save(entity);
        return new PublicPostMapper().mapTo(created);
    }

    public PublicPostDto createReply(String id, CreateReplyDto reply) {
        Optional<PostEntity> optionalPost = repository.findById(id);
        if (optionalPost.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found.");
        PostEntity entity = optionalPost.get();
        List<ReplyEntity> replies = entity.getReplies();
        ReplyEntity replyEntityPure = new CreateReplyMapper().mapFrom(reply);
        replyEntityPure.setPost(entity);
        replyEntityPure = replyRepository.save(replyEntityPure);
        replies.add(replyEntityPure);
        entity.setReplies(replies);
        return new PublicPostMapper().mapTo(repository.save(entity));
    }

    public List<PublicPostDto> getAll() {
        return repository.findAll().stream().map(p -> new PublicPostMapper().mapTo(p)).toList();
    }

    public PublicPostDto getById(String id) {
        Optional<PostEntity> optionalPost = repository.findById(id);
        if (optionalPost.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found.");
        PostEntity entity = optionalPost.get();
        return new PublicPostMapper().mapTo(entity);
    }

    public void addLikeOrDislike(String id, POST_STATS option) {
        Optional<PostEntity> optionalPost = repository.findById(id);
        if (optionalPost.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found.");
        PostEntity entity = optionalPost.get();
        if (option.equals(POST_STATS.LIKE)) entity.setLikes(entity.getLikes() + 1);
        if (option.equals(POST_STATS.DISLIKE)) entity.setDislikes(entity.getDislikes() + 1);
        repository.save(entity);
    }

    public void deleteLikeOrDislike(String id, POST_STATS option) {
        Optional<PostEntity> optionalPost = repository.findById(id);
        if (optionalPost.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found.");
        PostEntity entity = optionalPost.get();
        if (option.equals(POST_STATS.LIKE)) entity.setLikes(entity.getLikes() - 1);
        if (option.equals(POST_STATS.DISLIKE)) entity.setDislikes(entity.getDislikes() - 1);
        repository.save(entity);
    }
}
