package it.cakalli.ProgettoPalestra.Service;

import it.cakalli.ProgettoPalestra.entity.Istruttore;
import it.cakalli.ProgettoPalestra.repository.IstruttoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IstruttoreService {

    @Autowired
    private IstruttoreRepository istruttoreRepository;

    public List<Istruttore> findAll() {
        return istruttoreRepository.findAll();
    }

    public Optional<Istruttore> findById(Integer id) {
        return istruttoreRepository.findById(id);
    }

    public Istruttore save(Istruttore istruttore) {
        return istruttoreRepository.save(istruttore);
    }

    public Istruttore update(Istruttore istruttore) {
        return istruttoreRepository.save(istruttore);
    }

    public void deleteById(Integer id) {
        istruttoreRepository.deleteById(id);
    }
}