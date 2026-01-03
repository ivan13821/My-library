package com.example.library.user.dataTransferObjects.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "login is required")
    private String login;

    @NotBlank(message = "password is required")
    private String password;
}
