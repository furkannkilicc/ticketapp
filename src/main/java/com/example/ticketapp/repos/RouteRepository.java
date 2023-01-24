package com.example.ticketapp.repos;

import com.example.ticketapp.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Object> findRouteById(@Param("userIds") Optional<Object> userIds);
}
