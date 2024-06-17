package it.cakalli.ProgettoPalestra.repository;


import it.cakalli.ProgettoPalestra.entity.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Integer> {
}
