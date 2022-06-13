package com.jobzilla.dto.response;

public class LoginResponseDto {
    private String jwt;
    private String prefix;

    public LoginResponseDto(String jwt, String prefix) {
        this.jwt = jwt;
        this.prefix = prefix;
    }

}
