package com.bd2.api.dto;

public class GoodbyeDTO {
    
    private String message;

    @SuppressWarnings("unused")
    public GoodbyeDTO() {
    }

    public GoodbyeDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
