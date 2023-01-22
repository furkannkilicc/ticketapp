package com.example.ticketapp.repos;

import com.example.ticketapp.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Object> findSeatById(@Param("userIds") List<Long> userIds);
}
