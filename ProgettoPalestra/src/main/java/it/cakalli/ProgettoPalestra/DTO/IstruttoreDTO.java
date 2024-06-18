package it.cakalli.ProgettoPalestra.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class IstruttoreDTO {

    private Long id;

    @NotBlank(message = "Inserire il nome dell'istruttore")
    private String nome;

    @NotBlank(message = "Inserire il cognome dell'istruttore")
    private String cognome;

}