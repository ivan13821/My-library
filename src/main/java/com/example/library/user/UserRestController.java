package com.example.library.user;

import com.example.library.user.dataTransferObjects.response.UserResponse;
import com.example.library.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.library.user.dataTransferObjects.response.RegistrationResponse;
import com.example.library.user.dataTransferObjects.request.RegistrationRequest;
import java.util.List;



@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("registration")
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(userService.createUser(request));
    }

    @GetMapping("user/getAllUsers")
    public ResponseEntity<List<UserResponse>> getAllUser() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(userService.getAllUsers());
    }
}
