package org.example.repository;

import java.util.UUID;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

}
