package com.jobzilla.controller;

import com.jobzilla.dto.request.auth.RegisterRequestDto;
import com.jobzilla.dto.request.job.JobRegisterRequestDto;
import com.jobzilla.dto.response.DefaultMessageResponseDto;
import com.jobzilla.exception.ExistingEmailException;
import com.jobzilla.exception.InvalidDataException;
import com.jobzilla.service.JobService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/create")
    public ResponseEntity<?> userRegistration(@NotNull @RequestBody JobRegisterRequestDto request){
        try {
            jobService.jobRegister(request);
            return ResponseEntity.ok().build();
        }
        catch (ExistingEmailException | InvalidDataException e) {
            return new ResponseEntity(new DefaultMessageResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
