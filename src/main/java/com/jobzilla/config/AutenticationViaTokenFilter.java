package com.jobzilla.config;

import com.jobzilla.model.User;
import com.jobzilla.repository.UserRepository;
import com.jobzilla.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticationViaTokenFilter extends OncePerRequestFilter {


    private TokenService tokenService;

    private UserRepository repository;

    public AutenticationViaTokenFilter(TokenService tokenService, UserRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);

        if (valido) {
            autenticarCliente(token);
        }

        filterChain.doFilter(request, response);
    }

    private void autenticarCliente(String token) {
        Integer userId = tokenService.getIdUsuario(token);
        User usuario = repository.findById(userId).get();

        UsernamePasswordAuthenticationToken autentication = new UsernamePasswordAuthenticationToken(usuario,
                null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(autentication);
    }

    private String recuperarToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || token.startsWith("Beaurer")){
            return null;
        }else {
            return token.substring(7, token.length());
        }

    }
}