package br.ekerdev.faladev.controller;

import br.ekerdev.faladev.service.PostService;
import br.ekerdev.faladev.shared.dtos.CreatePostDto;
import br.ekerdev.faladev.shared.dtos.CreateReplyDto;
import br.ekerdev.faladev.shared.dtos.PublicPostDto;
import br.ekerdev.faladev.shared.enums.POST_STATS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/v1/api/posts")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PublicPostDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublicPostDto getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublicPostDto createPost(@Valid @RequestBody CreatePostDto post) {
        return service.createPost(post);
    }

    @PutMapping("/{id}/reply")
    @ResponseStatus(HttpStatus.OK)
    public PublicPostDto createReply(@PathVariable("id") String id, @Valid @RequestBody CreateReplyDto reply) {
        return service.createReply(id, reply);
    }

    @PutMapping("/{id}/like")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addLikePost(@PathVariable("id") String id) {
        service.addLikeOrDislike(id, POST_STATS.LIKE);
    }

    @PutMapping("/{id}/dislike")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addDislikePost(@PathVariable("id") String id) {
        service.addLikeOrDislike(id, POST_STATS.DISLIKE);
    }

    @DeleteMapping("/{id}/like")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeLikePost(@PathVariable("id") String id) {
        service.deleteLikeOrDislike(id, POST_STATS.LIKE);
    }

    @DeleteMapping("/{id}/dislike")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDislikePost(@PathVariable("id") String id) {
        service.deleteLikeOrDislike(id, POST_STATS.DISLIKE);
    }
}
