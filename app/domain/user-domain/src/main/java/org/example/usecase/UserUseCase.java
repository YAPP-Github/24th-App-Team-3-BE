package org.example.usecase;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.user.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    @Transactional
    public User save(final User user) {
        return userRepository.save(user);
    }

    public String findNickName(final User user) {
        return userRepository.findNicknameById(user.getId()).orElseThrow();
    }
}
