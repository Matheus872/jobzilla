package com.jobzilla.dto.response.auth;

public class LoginResponseDto {
    private String jwt;
    private String prefix;
    private Integer profileType;

    public LoginResponseDto(String jwt, String prefix, Integer profileType) {
        this.jwt = jwt;
        this.prefix = prefix;
        this.profileType = profileType;
    }

}
