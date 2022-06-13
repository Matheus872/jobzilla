package com.jobzilla.dto.request;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String email;
    private String password;

    public boolean isNullOrEmpty() {
        return this.getUsername() == null || this.getPassword() == null || this.getEmail() == null||
        this.getUsername().isEmpty() || this.getPassword().isEmpty() || this.getEmail().isEmpty();
    }

}
