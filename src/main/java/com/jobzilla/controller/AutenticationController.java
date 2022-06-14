package com.jobzilla.controller;
import com.jobzilla.dto.request.LoginRequestDto;
import com.jobzilla.dto.request.RegisterRequestDto;
import com.jobzilla.dto.response.DefaultMessageResponseDto;
import com.jobzilla.dto.response.TokenDto;
import com.jobzilla.exception.ExistingEmailException;
import com.jobzilla.exception.InvalidDataException;
import com.jobzilla.repository.UserRepository;
import com.jobzilla.service.AutenticationService;
import com.jobzilla.service.TokenService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private AutenticationService autenticationService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> userRegistration(@NotNull @RequestBody RegisterRequestDto request){
        try {
            autenticationService.userRegister(request);
            return ResponseEntity.ok().build();
        }
        catch (ExistingEmailException | InvalidDataException e) {
            return new ResponseEntity(new DefaultMessageResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()),
                    HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/signin")
    public ResponseEntity<Object> autenticar(@RequestBody @Valid LoginRequestDto loginRequest) {
        UsernamePasswordAuthenticationToken dadosLogin = loginRequest.converter();

        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            Integer profileType = autenticationService.loadUserByUsernameReturnUser(dadosLogin.getName()).getProfileType();

            return ResponseEntity.ok(new TokenDto(token, "Bearer", profileType));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }


}
