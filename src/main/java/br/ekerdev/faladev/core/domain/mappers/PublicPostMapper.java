package br.ekerdev.faladev.core.domain.mappers;

import br.ekerdev.faladev.core.base.Mapper;
import br.ekerdev.faladev.core.domain.entities.PostEntity;
import br.ekerdev.faladev.shared.dtos.PublicPostDto;

public class PublicPostMapper extends Mapper<PublicPostDto, PostEntity> {
    @Override
    public PublicPostDto mapTo(PostEntity entity) {
        PublicPostDto pub = new PublicPostDto();

        pub.setId(entity.getId());
        pub.setBody(entity.getBody());
        pub.setLikes(entity.getLikes());
        pub.setDislikes(entity.getDislikes());
        pub.setCreatedAt(entity.getCreatedAt());
        pub.setReplies(entity.getReplies());
        pub.setTags(entity.getTags());
        pub.setUsername(entity.getUsername());

        return pub;
    }

    @Override
    public PostEntity mapFrom(PublicPostDto dto) {
        return null;
    }
}
