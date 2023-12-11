package com.vovi.backend_new.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank
    @NotNull
    private String login;

    @NotBlank
    @NotNull
    private String password;
}