package it.cakalli.ProgettoPalestra.Controller;

import it.cakalli.ProgettoPalestra.DTO.UtenteDto;
import it.cakalli.ProgettoPalestra.DTO.UtenteLoginDto;
import it.cakalli.ProgettoPalestra.Exception.BadRequestException;
import it.cakalli.ProgettoPalestra.Service.AuthService;
import it.cakalli.ProgettoPalestra.Service.UtenteService;
import it.cakalli.ProgettoPalestra.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).
                    reduce("", (s, s2) -> s+s2));
        }

        return utenteService.saveUtente(utenteDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated UtenteLoginDto utenteLoginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).
                    reduce("", (s, s2) -> s+s2));
        }

        return authService.authenticateUtenteAndCreateToken(utenteLoginDto);
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public Utente getMe(@AuthenticationPrincipal Utente utente) {
        return utente;
    }
}
