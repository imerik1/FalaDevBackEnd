package br.ekerdev.faladev.core.domain.mappers;

import br.ekerdev.faladev.core.base.Mapper;
import br.ekerdev.faladev.core.domain.entities.PostEntity;
import br.ekerdev.faladev.shared.dtos.CreatePostDto;

public class CreatePostMapper extends Mapper<CreatePostDto, PostEntity> {
    @Override
    public CreatePostDto mapTo(PostEntity entity) {
        return null;
    }

    @Override
    public PostEntity mapFrom(CreatePostDto dto) {
        PostEntity entity = new PostEntity();

        entity.setUsername(dto.getUsername());
        entity.setBody(dto.getBody());
        entity.setTags(dto.getTags());

        return entity;
    }
}
