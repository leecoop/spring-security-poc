package com.example.springsecuritypoc.repository;

import java.util.Optional;

import com.example.springsecuritypoc.modal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>{
    Optional<Users> findByUsername(String username);
}