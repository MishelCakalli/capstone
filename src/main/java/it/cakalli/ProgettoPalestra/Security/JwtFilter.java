package it.cakalli.ProgettoPalestra.Security;

import it.cakalli.ProgettoPalestra.Exception.NotFoundException;
import it.cakalli.ProgettoPalestra.Exception.UnauthorizedException;
import it.cakalli.ProgettoPalestra.Service.UtenteService;
import it.cakalli.ProgettoPalestra.entity.Utente;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private UtenteService utenteService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(authHeader==null||!authHeader.startsWith("Bearer ")){
            throw  new UnauthorizedException("La richiesta non ha un token. Riloggarsi!");
        }

        String token = authHeader.substring(7);

        jwtTool.verifyToken(token);

        int id = jwtTool.getUsernameFromDipendente(token);

        Optional<Utente> dipendenteOptional = utenteService.getUtenteById(id);

        if(dipendenteOptional.isPresent()){
            Utente dipendente = dipendenteOptional.get();
            Authentication authentication = new UsernamePasswordAuthenticationToken(dipendente, null, dipendente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        else{
            throw new UnauthorizedException("Utente non trovato nel token. Riloggati");
        }

        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return new AntPathMatcher().match("/auth/**", request.getServletPath());
    }
}