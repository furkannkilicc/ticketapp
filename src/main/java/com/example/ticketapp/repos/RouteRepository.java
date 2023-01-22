package com.example.ticketapp.repos;

import com.example.ticketapp.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Long> {
}
