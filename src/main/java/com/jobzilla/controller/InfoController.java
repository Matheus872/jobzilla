package com.jobzilla.controller;

import com.jobzilla.dto.request.RegisterRequestDto;
import com.jobzilla.dto.response.DefaultMessageResponseDto;
import com.jobzilla.exception.ExistingEmailException;
import com.jobzilla.exception.InvalidDataException;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
public class InfoController {


    @GetMapping("/")
    public DefaultMessageResponseDto info(){
            return new DefaultMessageResponseDto("Jobzilla App API", 200);
    }


}
