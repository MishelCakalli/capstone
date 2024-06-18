package it.cakalli.ProgettoPalestra.Controller;

import it.cakalli.ProgettoPalestra.DTO.UtenteDto;
import it.cakalli.ProgettoPalestra.Exception.BadRequestException;
import it.cakalli.ProgettoPalestra.Exception.UtenteNonTrovatoException;
import it.cakalli.ProgettoPalestra.Service.UtenteService;
import it.cakalli.ProgettoPalestra.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping("/api/dipendenti")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<Utente> getUtente(){
        return utenteService.getUtente();
    }

    @GetMapping("/api/dipendenti/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Utente getUtenteByUsername(@PathVariable int id){
        Optional<Utente> dipendenteOptional = utenteService.getUtenteById(id);

        if (dipendenteOptional.isPresent()){
            return dipendenteOptional.get();
        }
        else{
            throw new UtenteNonTrovatoException("Dipendente con username=" + id + " non trovato");
        }
    }


    @PutMapping("/api/dipendenti/{username}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Utente updateUtente(@PathVariable int username, @RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new BadRequestException((bindingResult.getAllErrors().stream(). //creiamo una stringa unica con tt gli errori
                    map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s+s2))); //map da ad ogni errore il messaggio; reduce per fusione che concatena accumulatore con ogni stringa
        }
        return utenteService.updateUtente(username, utenteDto);

    }


    @DeleteMapping("/api/dipendenti/{username}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteUtente(@PathVariable int id){

        if (utenteService.getUtenteById(id).isPresent()){
            return utenteService.deleteUtente(id);
        }
        else{
            throw new UtenteNonTrovatoException("Utente con username=" + id + " non trovato");
        }
    }

//    @PatchMapping("/api/dipendenti/{username}")
//    public String patchFotoDipendente(@RequestBody MultipartFile foto, @PathVariable int username) throws IOException {
//        return dipendenteService.patchFotoDipendente(username, foto);
//    }
}
