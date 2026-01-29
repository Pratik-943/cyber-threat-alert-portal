package com.project.cyberalert.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cyberalert.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
