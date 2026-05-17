package it.leoalicino.studio_magazzino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.leoalicino.studio_magazzino.domain.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

}
