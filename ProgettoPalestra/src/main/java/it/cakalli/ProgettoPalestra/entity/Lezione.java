package it.cakalli.ProgettoPalestra.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Lezione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date data;
    private String oraInizio;
    private String oraFine;
    private String sala;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    @ManyToOne
    @JoinColumn(name = "istruttore_id")
    private Istruttore istruttore;

    @OneToMany(mappedBy = "lezione")
    private List<Prenotazione> prenotazioni;
}