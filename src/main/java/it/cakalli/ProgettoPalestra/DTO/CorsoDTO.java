package it.cakalli.ProgettoPalestra.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CorsoDTO {

    private Long id;

    @NotBlank(message = "Inserire il nome del corso")
    @Size(max = 255, message = "Il nome del corso non può superare i 255 caratteri")
    private String nome;

    @NotBlank(message = "Inserire la descrizione del corso")
    private String descrizione;
}