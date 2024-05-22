package org.tutorials.springBootGenerateDocumentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.springBootGenerateDocumentation.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
