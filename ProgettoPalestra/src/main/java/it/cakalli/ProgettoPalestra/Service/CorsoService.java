package it.cakalli.ProgettoPalestra.Service;

import it.cakalli.ProgettoPalestra.entity.Corso;
import it.cakalli.ProgettoPalestra.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoService {
    @Autowired
    private CorsoRepository corsoRepository;

    public List<Corso> findAll() {
        return corsoRepository.findAll();
    }

    public Optional<Corso> findById(Integer id) {
        return corsoRepository.findById(id);
    }

    public Corso save(Corso corso) {
        return corsoRepository.save(corso);
    }

    public Corso update(Corso corso) {
        return corsoRepository.save(corso);
    }

    public void deleteById(Integer id) {
        corsoRepository.deleteById(id);
    }

}
