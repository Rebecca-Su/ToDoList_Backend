package com.rebecca.toDoList.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebecca.toDoList.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
