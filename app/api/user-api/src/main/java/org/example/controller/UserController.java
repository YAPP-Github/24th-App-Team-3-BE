package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.request.LoginApiRequest;
import org.example.controller.dto.request.LogoutApiRequest;
import org.example.controller.dto.response.LoginApiResponse;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "회원가입 / 로그인")
    public ResponseEntity<LoginApiResponse> signUp(@Valid @RequestBody LoginApiRequest request) {

        return ResponseEntity.ok(new LoginApiResponse(
            "accessToken", "refreshToken"
        ));
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃")
    public ResponseEntity<Void> logout(@Valid @RequestBody LogoutApiRequest request) {
        return ResponseEntity.noContent().build();
    }
}
