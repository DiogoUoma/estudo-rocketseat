package br.com.diogouoma.gestao_vagas.modules.repository;

import br.com.diogouoma.gestao_vagas.modules.entity.ApplyJobEntity;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
