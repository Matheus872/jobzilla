package com.jobzilla.dto.response;

import lombok.Data;

@Data
public class DefaultMessageResponseDto {

    private String message;
    private int status;

    public DefaultMessageResponseDto(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
