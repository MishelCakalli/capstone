package it.cakalli.ProgettoPalestra.Security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.cakalli.ProgettoPalestra.entity.Utente;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String token;

    @JsonIgnoreProperties(value = "password")
    private Utente utente;

    public AuthenticationResponse(String token, Utente utente) {
        this.token = token;
        this.utente = utente;
    }
}