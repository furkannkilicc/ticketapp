package com.example.ticketapp.repos;

import com.example.ticketapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
