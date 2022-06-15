package com.jobzilla.controller;

import com.jobzilla.dto.response.DefaultMessageResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
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
