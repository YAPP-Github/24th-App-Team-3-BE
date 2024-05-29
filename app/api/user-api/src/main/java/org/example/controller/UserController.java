package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.SignUpRequest;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0.0.1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest request) {
        final User createdUser = request.toUser();
        final User user = userService.signUp(createdUser);

        return ResponseEntity.ok(user.getNickname() + "사용자 생성 성공!");
    }

}
