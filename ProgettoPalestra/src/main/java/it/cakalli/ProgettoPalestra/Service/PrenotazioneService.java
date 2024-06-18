package it.cakalli.ProgettoPalestra.Service;

import it.cakalli.ProgettoPalestra.entity.Prenotazione;
import it.cakalli.ProgettoPalestra.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> findById(Integer id) {
        return prenotazioneRepository.findById(id);
    }

    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione update(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public void deleteById(Integer id) {
        prenotazioneRepository.deleteById(id);
    }
}