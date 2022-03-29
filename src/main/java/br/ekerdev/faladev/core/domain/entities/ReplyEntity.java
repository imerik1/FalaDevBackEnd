package br.ekerdev.faladev.core.domain.entities;

import br.ekerdev.faladev.core.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "REPLY")
@Table(name = "REPLIES")
public class ReplyEntity extends BaseEntity {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;
}
