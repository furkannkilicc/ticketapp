package com.example.ticketapp.repos;

import com.example.ticketapp.entities.Seat;
import com.example.ticketapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Object> findSeatById(Optional<User> userIds);
}
