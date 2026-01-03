package com.example.library.user.dataTransferObjects.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message =  "login is required")
    private String login;

    @NotBlank(message = "email is required")
    private String email;
}
