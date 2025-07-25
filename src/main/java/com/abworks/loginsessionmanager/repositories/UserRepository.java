package com.abworks.loginsessionmanager.repositories;

import com.abworks.loginsessionmanager.domain.entitities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail(String email);
}
