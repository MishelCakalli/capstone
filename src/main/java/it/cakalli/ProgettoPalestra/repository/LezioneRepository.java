package it.cakalli.ProgettoPalestra.repository;

import it.cakalli.ProgettoPalestra.entity.Lezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LezioneRepository extends JpaRepository<Lezione, Integer> {
}