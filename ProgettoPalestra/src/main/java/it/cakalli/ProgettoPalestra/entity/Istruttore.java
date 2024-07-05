package it.cakalli.ProgettoPalestra.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Istruttore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    private String telefono;
    private String specializzazione;
    private int esperienza;

    @ManyToMany
    @JoinTable(
            name = "istruttore_corso",
            joinColumns = @JoinColumn(name = "istruttore_id"),
            inverseJoinColumns = @JoinColumn(name = "corso_id")
    )
    private List<Corso> corsi;

    @OneToMany(mappedBy = "istruttore")
    private List<Lezione> lezioni;
}
