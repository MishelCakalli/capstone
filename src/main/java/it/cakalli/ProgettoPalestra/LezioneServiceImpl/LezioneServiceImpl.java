package it.cakalli.ProgettoPalestra.LezioneServiceImpl;

import it.cakalli.ProgettoPalestra.Service.LezioneService;
import it.cakalli.ProgettoPalestra.entity.Lezione;
import it.cakalli.ProgettoPalestra.repository.LezioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LezioneServiceImpl extends LezioneService {

    private final LezioneRepository lezioneRepository;

    @Autowired
    public LezioneServiceImpl(LezioneRepository lezioneRepository) {
        super();
        this.lezioneRepository = lezioneRepository;
    }

    @Override
    public List<Lezione> getAllLezioni() {
        return lezioneRepository.findAll();
    }

    @Override
    public Lezione getLezioneById(int id) {
        Optional<Lezione> optionalLezione = lezioneRepository.findById(id);
        return optionalLezione.orElse(null);
    }

    @Override
    public Lezione createLezione(Lezione lezione) {
        return lezioneRepository.save(lezione);
    }

    @Override
    public Lezione updateLezione(int id, Lezione lezione) {
        if (!lezioneRepository.existsById(id)) {
            return null;
        }
//        lezione.setId(id); // Assicura che l'ID sia impostato correttamente
        return lezioneRepository.save(lezione);
    }

    @Override
    public void deleteLezione(int id) {
        lezioneRepository.deleteById(id);
    }






    @Override
    public List<Lezione> getLezioniByUtenteId(int utenteId) {
        return lezioneRepository.findByUtenteId(utenteId);
    }
}
