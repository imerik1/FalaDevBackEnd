package br.ekerdev.faladev.core.domain.entities;

import br.ekerdev.faladev.core.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "POST")
@Table(name = "POSTS")
public class PostEntity extends BaseEntity {
    @OneToMany(mappedBy = "post", targetEntity = ReplyEntity.class, fetch = FetchType.EAGER)
    private List<ReplyEntity> replies = new ArrayList<ReplyEntity>();
    @Column(name = "TAGS", nullable = false)
    @ElementCollection(targetClass = String.class)
    private List<String> tags = new ArrayList<String>();
    @Column(name = "USERNAME", nullable = false, length = 15)
    private String username = "Unknown";
    @Column(name = "LIKES", nullable = false)
    private Integer likes = 0;
    @Column(name = "DISLIKES", nullable = false)
    private Integer dislikes = 0;
}
