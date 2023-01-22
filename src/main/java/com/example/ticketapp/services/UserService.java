package com.example.ticketapp.services;

import com.example.ticketapp.entities.User;
import com.example.ticketapp.repos.RouteRepository;
import com.example.ticketapp.repos.SeatRepository;
import com.example.ticketapp.repos.TicketRepository;
import com.example.ticketapp.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
      UserRepository userRepository;
     TicketRepository ticketRepository;
     RouteRepository routeRepository;
      SeatRepository seatRepository;
    public UserService(UserRepository userRepository,TicketRepository ticketRepository,SeatRepository seatRepository,RouteRepository routeRepository) {
        this.userRepository = userRepository;
        this.routeRepository=routeRepository;
        this.ticketRepository=ticketRepository;
        this.seatRepository=seatRepository;

    }

    public  User saveOneUser(User newUser) {
        return  UserRepository.save(newUser);
    }

    public static Optional<User> getOneUser(Long userId) {
        return  UserRepository.findById(userId).orElse(null);
    }

    public User getUserTickets(Long ticketId) {
        return (User) UserRepository.findUserById(ticketId).orElse(null);
    }


    public List<Object> getUserDetails(Long userId) {
        Optional<Object> userIds = UserRepository.findUserById(userId);
        if(userIds.isEmpty())
                return  null;
        List<Object> routes = routeRepository.findRouteById(userIds);
        List<Object> seats = seatRepository.findSeatById(userIds);
        List<Object> tickets=  ticketRepository.findTicketById(userIds);
        List<Object> result = new ArrayList<>();
        result.addAll(seats);
        result.addAll(tickets);
        result.addAll(routes);

        return result;

    }
}

