package it.cakalli.ProgettoPalestra.repository;

import it.cakalli.ProgettoPalestra.entity.Istruttore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstruttoreRepository extends JpaRepository<Istruttore, Integer> {
}