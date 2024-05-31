package org.example.security.token;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.security.dto.TokenParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshTokenProcessor {

    private final JWTProcessor jwtProcessor;
    private final JWTGenerator jwtGenerator;

    public TokenParam process(HttpServletRequest request, HttpServletResponse response) {
        String accessToken = jwtProcessor.extractAccessToken(request);
        String refreshToken = jwtProcessor.extractRefreshToken(request);

        return new TokenParam(accessToken, refreshToken);
    }
}
