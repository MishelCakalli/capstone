package it.cakalli.ProgettoPalestra.Service;

import it.cakalli.ProgettoPalestra.entity.Lezione;
import it.cakalli.ProgettoPalestra.repository.LezioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class LezioneService {

    @Autowired
    private LezioneRepository lezioneRepository;

    public List<Lezione> findAll() {
        return lezioneRepository.findAll();
    }

    public Optional<Lezione> findById(Integer id) {
        return lezioneRepository.findById(id);
    }

    public Lezione save(Lezione lezione) {
        return lezioneRepository.save(lezione);
    }

    public Lezione update(Lezione lezione) {
        return lezioneRepository.save(lezione);
    }

    public void deleteById(Integer id) {
        lezioneRepository.deleteById(id);
    }

    public abstract List<Lezione> getAllLezioni();

    public abstract Lezione getLezioneById(int id);

    public abstract Lezione createLezione(Lezione lezione);

    public abstract Lezione updateLezione(int id, Lezione lezione);

    public abstract void deleteLezione(int id);









    @Autowired
    public LezioneService() {
        this.lezioneRepository = lezioneRepository;
    }


    public List<Lezione> getLezioniByUtenteId(int utenteId) {
        return lezioneRepository.findByUtenteId(utenteId);
    }
}
