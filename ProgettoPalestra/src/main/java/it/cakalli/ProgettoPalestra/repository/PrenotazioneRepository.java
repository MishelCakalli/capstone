package it.cakalli.ProgettoPalestra.repository;

import it.cakalli.ProgettoPalestra.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}
