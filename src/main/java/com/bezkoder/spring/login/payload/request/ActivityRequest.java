package com.bezkoder.spring.login.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;

public class ActivityRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
