package com.spring.boot.backend.repository;

import java.util.Optional;

import com.spring.boot.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Optional<User> findById(Integer id);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
