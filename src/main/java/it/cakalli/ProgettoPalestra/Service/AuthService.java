package it.cakalli.ProgettoPalestra.Service;

import it.cakalli.ProgettoPalestra.DTO.UtenteLoginDto;
import it.cakalli.ProgettoPalestra.DTO.UtenteLoginDto;
import it.cakalli.ProgettoPalestra.Security.JwtTool;
import it.cakalli.ProgettoPalestra.Exception.UnauthorizedException;
import it.cakalli.ProgettoPalestra.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUtenteAndCreateToken(UtenteLoginDto utenteLoginDto){
        Optional<Utente> dipendenteOptional = utenteService.getUtenteByEmail(utenteLoginDto.getEmail());

        if(dipendenteOptional.isPresent()){
            Utente dipendente = dipendenteOptional.get();

            if(passwordEncoder.matches(utenteLoginDto.getPassword(), dipendente.getPassword())){
                return jwtTool.createToken(dipendente);
            }
            else{
                throw  new UnauthorizedException("Utente non presente. Riloggarsi!");
            }
        }
        else{
            throw  new UnauthorizedException("Utente non presente. Riloggarsi!");
        }

    }
}
