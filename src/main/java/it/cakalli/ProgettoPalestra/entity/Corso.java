package it.cakalli.ProgettoPalestra.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeCorso;
    private String descrizione;
    private int durata;

    @OneToMany(mappedBy = "corso")
    private List<Lezione> lezioni;

    @ManyToMany(mappedBy = "corsi")
    private List<Istruttore> istruttori;
}
