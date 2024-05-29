package org.example.dto.request;

import org.example.entity.User;

public record SignUpRequest(
    String nickname
) {

    public User toUser() {
        return new User(nickname);
    }
}
