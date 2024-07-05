package it.cakalli.ProgettoPalestra.Controller;


import it.cakalli.ProgettoPalestra.Service.PrenotazioneService;
import it.cakalli.ProgettoPalestra.entity.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appuntamenti")
public class PrenotazioneController {


    @Autowired
    private PrenotazioneService prenotazioneService;





    @GetMapping
    public List<Prenotazione> getAllPrenotazione() {
        return prenotazioneService.getAllPrenotazioni();
    }

    @GetMapping("/{id}")
    public Optional<Prenotazione> getPrenotazioneById(@PathVariable int id) {
        return prenotazioneService.getPrenotazioniById(id);
    }

    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.savePrenotazioni(prenotazione);
    }

//    @PutMapping("/{id}")
//    public Prenotazione updatePrenotazione(@PathVariable int id, @RequestBody Prenotazione prenotazione) {
//        prenotazione.setId(id);
//        return prenotazioneService.savePrenotazioni(prenotazione);
//    }

    @DeleteMapping("/{id}")
    public void deletePrenotazione(@PathVariable int id) {
        prenotazioneService.deletePrenotazioni(id);
    }
}
