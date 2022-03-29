package br.ekerdev.faladev.core.repositories;

import br.ekerdev.faladev.core.domain.entities.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, String> {
}
