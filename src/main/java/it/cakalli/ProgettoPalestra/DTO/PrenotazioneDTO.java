package it.cakalli.ProgettoPalestra.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrenotazioneDTO {

    private Long id;

    @NotNull(message = "Inserire l'ID della lezione")
    private Long lezioneId;

    @NotNull(message = "Inserire l'ID dell'utente")
    private Long utenteId;

    @NotBlank(message = "Inserire la data della prenotazione")
    private String dataPrenotazione;
}
