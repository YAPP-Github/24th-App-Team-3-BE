package org.example.dto.request;

import jakarta.validation.constraints.NotNull;
import org.example.entity.User;
import org.example.vo.SocialType;

public record SignUpRequest(

    @NotNull(message = "닉네임은 필수 입력값입니다.")
    String nickname,

    @NotNull(message = "소셜 타입은 필수 입력값입니다.")
    SocialType socialType,

    @NotNull(message = "소셜 식별자는 필수 입력값입니다.")
    String socialIdentifier
) {

    public User toUser() {
        return User.builder()
            .nickname(nickname)
            .socialType(socialType)
            .socialIdentifier(socialIdentifier)
            .build();
    }
}
