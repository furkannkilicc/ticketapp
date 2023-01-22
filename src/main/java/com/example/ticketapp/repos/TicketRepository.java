package com.example.ticketapp.repos;

import com.example.ticketapp.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Object> findTicketById(@Param("userIds") List<Long> userIds);
}
