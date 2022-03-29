package br.ekerdev.faladev.shared.dtos;

import br.ekerdev.faladev.core.domain.entities.ReplyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicPostDto {
    private String id;
    private String body;
    private Integer likes;
    private Integer dislikes;
    private Date createdAt;
    private List<ReplyEntity> replies = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private String username;
}
