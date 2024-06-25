import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppuntamentoService } from '../../service/appuntamento.service';
import { Appuntamento } from '../../interfaces/appuntamento';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  prenotazioneForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private appuntamentoService: AppuntamentoService
  ) {
    this.prenotazioneForm = this.fb.group({
      data: ['', Validators.required],
      corso: ['', Validators.required],
      utenteId: [null]
    });
  }

  onSubmit() {
    if (this.prenotazioneForm.valid) {
      const newAppuntamento: Appuntamento = {
        id: 0,
        data: this.prenotazioneForm.value.data,
        corso: this.prenotazioneForm.value.corso,
        utenteId: this.prenotazioneForm.value.utenteId
      };

      this.appuntamentoService.createAppuntamento(newAppuntamento).subscribe(
        response => {
          console.log('Prenotazione creata con successo', response);
          // Aggiungi logica per gestire la risposta, come reindirizzare l'utente o mostrare un messaggio di successo
        },
        error => {
          console.error('Errore nella creazione della prenotazione', error);
          // Aggiungi logica per gestire l'errore
        }
      );
    }
  }
}
