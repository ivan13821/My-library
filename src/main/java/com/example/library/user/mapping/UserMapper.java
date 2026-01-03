package com.example.library.user.mapping;

import com.example.library.user.dataTransferObjects.request.RegistrationRequest;
import com.example.library.user.dataTransferObjects.response.UserResponse;
import com.example.library.user.database.UserEntity;
import com.example.library.user.database.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {



    public static UserEntity toUserEntity(RegistrationRequest request) {
        UserEntity user = new UserEntity();

        user.setEmail(request.getEmail());
        user.setLogin(request.getLogin());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        return user;
    }

    public static UserResponse toUserResponse(UserEntity user) {
        UserResponse response = new UserResponse();

        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setLogin(user.getLogin());

        return response;
    }
}
