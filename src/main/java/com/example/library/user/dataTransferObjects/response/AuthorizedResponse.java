package com.example.library.user.dataTransferObjects.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorizedResponse {

    private String token;
    private String type;
    private int expiresIn;
}
