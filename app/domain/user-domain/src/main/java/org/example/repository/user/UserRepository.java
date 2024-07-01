package org.example.repository.user;

import java.util.UUID;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID>, UserQuerydslRepository {

}
