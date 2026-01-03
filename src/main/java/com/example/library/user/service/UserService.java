package com.example.library.user.service;

import com.example.library.user.dataTransferObjects.request.RegistrationRequest;
import com.example.library.user.dataTransferObjects.response.RegistrationResponse;
import com.example.library.user.dataTransferObjects.response.UserResponse;
import com.example.library.user.database.UserEntity;
import com.example.library.user.database.UserRepository;
import com.example.library.user.mapping.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationResponse createUser(RegistrationRequest request) {
        // Проверка
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already exists");
        }

        // Создание пользователя
        UserEntity user = UserMapper.toUserEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Сохранение
        UserEntity savedUser = userRepository.save(user);

        // Ответ
        RegistrationResponse response = new RegistrationResponse();
        response.setStatus("Success");
        return response;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserResponse)
                .toList();
    }
}