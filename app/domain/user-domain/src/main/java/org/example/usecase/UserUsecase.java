package org.example.usecase;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUsecase {

    private final UserRepository userRepository;

    public User save(final User user) {
        return userRepository.save(user);
    }

    public String findNickName(final User user) {
        return userRepository.findNicknameById(user.getId()).orElseThrow();
    }
}