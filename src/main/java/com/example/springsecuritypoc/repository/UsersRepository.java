package com.example.springsecuritypoc.repository;

import java.util.Optional;

import com.example.springsecuritypoc.modal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}