package it.cakalli.ProgettoPalestra.Service;

import it.cakalli.ProgettoPalestra.entity.Lezione;
import it.cakalli.ProgettoPalestra.repository.LezioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LezioneService {

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
}
