package br.com.compass.avaliacao.repositories;

import br.com.compass.avaliacao.entities.AffiliatedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliatedRespository extends JpaRepository<AffiliatedEntity, Long> {
}
