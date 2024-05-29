package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.usecase.UserUsecase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserUsecase userUsecase;

    public User signUp(final User user) {
        return userUsecase.save(user);
    }
}
