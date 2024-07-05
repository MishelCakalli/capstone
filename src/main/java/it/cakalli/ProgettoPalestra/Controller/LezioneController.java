package it.cakalli.ProgettoPalestra.Controller;

import it.cakalli.ProgettoPalestra.entity.Lezione;
import it.cakalli.ProgettoPalestra.Service.LezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lezioni")
public class LezioneController {

    private final LezioneService lezioneService;

    @Autowired
    public LezioneController(LezioneService lezioneService) {
        this.lezioneService = lezioneService;
    }

    // Endpoint per ottenere tutte le lezioni
    @GetMapping
    public ResponseEntity<List<Lezione>> getAllLezioni() {
        List<Lezione> lezioni = lezioneService.getAllLezioni();
        return ResponseEntity.ok(lezioni);
    }

    // Endpoint per ottenere una lezione per ID
    @GetMapping("/{id}")
    public ResponseEntity<Lezione> getLezioneById(@PathVariable("id") int id) {
        Lezione lezione = lezioneService.getLezioneById(id);
        return ResponseEntity.ok(lezione);
    }

    // Endpoint per creare una nuova lezione
    @PostMapping
    public ResponseEntity<Lezione> createLezione(@RequestBody Lezione lezione) {
        Lezione newLezione = lezioneService.createLezione(lezione);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLezione);
    }

    // Endpoint per aggiornare una lezione esistente
    @PutMapping("/{id}")
    public ResponseEntity<Lezione> updateLezione(@PathVariable("id") int id, @RequestBody Lezione lezione) {
        Lezione updatedLezione = lezioneService.updateLezione(id, lezione);
        return ResponseEntity.ok(updatedLezione);
    }

    // Endpoint per eliminare una lezione
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLezione(@PathVariable("id") int id) {
        lezioneService.deleteLezione(id);
        return ResponseEntity.noContent().build();
    }

























    @GetMapping("/utente/{utenteId}")
    public ResponseEntity<List<Lezione>> getLezioniByUtenteId(@PathVariable("utenteId") int utenteId) {
        List<Lezione> lezioni = lezioneService.getLezioniByUtenteId(utenteId);
        return new ResponseEntity<>(lezioni, HttpStatus.OK);
    }
}
