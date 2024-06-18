package it.cakalli.ProgettoPalestra.Service;

import it.cakalli.ProgettoPalestra.DTO.UtenteDto;
import it.cakalli.ProgettoPalestra.Enum.Role;
import it.cakalli.ProgettoPalestra.Exception.BadRequestException;
import it.cakalli.ProgettoPalestra.Exception.UtenteNonTrovatoException;
import it.cakalli.ProgettoPalestra.entity.Utente;
import it.cakalli.ProgettoPalestra.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private Cloudinary cloudinary;

    public String saveUtente(UtenteDto utenteDto) {
        if(getUtenteByEmail(utenteDto.getEmail()).isEmpty()){
            Utente utente = new Utente();
            utente.setNome(utenteDto.getNome());
            utente.setCognome(utenteDto.getCognome());
            utente.setEmail(utenteDto.getEmail());
            utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));
            utente.setRole(Role.USER);

            utenteRepository.save(utente);
            return "Utente con username " + utente.getUsername() + " salvato correttamente";
        }
        else{
            throw new BadRequestException("L'email del Utente " + utenteDto.getEmail() + " già presente");
        }

    }

    public List<Utente> getUtente(){
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUtenteById(int username){
        return utenteRepository.findById(username);
    }

    public  Utente updateUtente(int id, UtenteDto utenteDto){
        Optional<Utente> utenteOptional = getUtenteById(id);

        if (utenteOptional.isPresent()) {
            Utente dipendente = utenteOptional.get();
            dipendente.setNome(utenteDto.getNome());
            dipendente.setCognome(utenteDto.getCognome());
            dipendente.setEmail(utenteDto.getEmail());
            dipendente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));
            return utenteRepository.save(dipendente);
        }
        else {
            throw new UtenteNonTrovatoException("Utente con id=" + id + " non trovato");
        }
    }

    public String deleteUtente(int id) {
        Optional<Utente> utenteOptional = getUtenteById(id);

        if (utenteOptional.isPresent()) {
            utenteRepository.delete(utenteOptional.get());
            return "Studente con username=" + id + " cancellato con successo";
        } else {
            throw new UtenteNonTrovatoException("Utente con username=" + id + " non trovato");
        }
    }


//    public String patchFotoDipendente(int username, MultipartFile foto) throws IOException {
//        Optional<Dipendente> dipendenteOptional = getUtenteById(username);
//
//        if(dipendenteOptional.isPresent()){           //upload invio della foto    prendiamo la mappa   get da il valore di map
//            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");  //restituisce una mappa. Da questa estraiamo il valore della chiave url
//            Dipendente dipendente = dipendenteOptional.get(); //estrazione del dipendente e associazione
//            dipendente.setFoto(url);
//            dipendenteRepository.save(dipendente);
//            return "Dipendente con username=" + username + " aggiornato correttamente con la foto inviata";
//        }
//        else{
//            throw new DipendenteNonTrovatoException("Dipendente con username=" + username + " non trovato");
//        }
//    }

    public Optional<Utente> getUtenteByEmail(String email){
        return utenteRepository.findByEmail(email);

    }

}
