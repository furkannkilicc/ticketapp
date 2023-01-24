package com.example.ticketapp.services;

import com.example.ticketapp.entities.User;
import com.example.ticketapp.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    public RouteService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;
}
