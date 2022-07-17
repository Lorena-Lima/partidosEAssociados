package br.com.compass.avaliacao.repositories;

import br.com.compass.avaliacao.entities.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRespository extends JpaRepository<PartyEntity, Long> {
}
