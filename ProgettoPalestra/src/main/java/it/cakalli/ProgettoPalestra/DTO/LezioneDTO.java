package it.cakalli.ProgettoPalestra.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LezioneDTO {

    private Long id;

    @NotBlank(message = "Inserire l'orario della lezione")
    private String orario;

    @NotNull(message = "Inserire l'ID del corso")
    private Long corsoId;

    @NotNull(message = "Inserire l'ID dell'istruttore")
    private Long istruttoreId;
}