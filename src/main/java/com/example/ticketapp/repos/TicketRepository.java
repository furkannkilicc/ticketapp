package com.example.ticketapp.repos;

import com.example.ticketapp.entities.Ticket;
import com.example.ticketapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Object> findTicketById(Optional<User> userIds);
}
