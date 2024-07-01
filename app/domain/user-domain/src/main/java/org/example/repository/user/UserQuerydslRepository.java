package org.example.repository.user;

import java.util.Optional;
import java.util.UUID;

public interface UserQuerydslRepository {

    Optional<String> findNicknameById(final UUID id);

}
