package br.ekerdev.faladev.core.domain.mappers;

import br.ekerdev.faladev.core.base.Mapper;
import br.ekerdev.faladev.core.domain.entities.PostEntity;
import br.ekerdev.faladev.core.domain.entities.ReplyEntity;
import br.ekerdev.faladev.shared.dtos.CreateReplyDto;

public class CreateReplyMapper extends Mapper<CreateReplyDto, ReplyEntity> {
    @Override
    public CreateReplyDto mapTo(ReplyEntity entity) {
        return null;
    }

    @Override
    public ReplyEntity mapFrom(CreateReplyDto dto) {
        ReplyEntity entity = new ReplyEntity();

        entity.setBody(dto.getBody());

        return entity;
    }
}
