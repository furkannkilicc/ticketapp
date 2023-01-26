package com.example.ticketapp.repos;

import com.example.ticketapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository  extends JpaRepository<User,Long> {
    User  findByUsername(String username);
}