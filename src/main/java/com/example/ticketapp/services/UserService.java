package com.example.ticketapp.services;

import com.example.ticketapp.entities.User;
import com.example.ticketapp.repos.RouteRepository;
import com.example.ticketapp.repos.SeatRepository;
import com.example.ticketapp.repos.TicketRepository;
import com.example.ticketapp.repos.UserRepository;
import com.example.ticketapp.requsts.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    TicketRepository ticketRepository;
    RouteRepository routeRepository;
    SeatRepository seatRepository;

    public UserService(UserRepository userRepository, TicketRepository ticketRepository, SeatRepository seatRepository, RouteRepository routeRepository) {
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;

    }


    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getUserTickets(Long ticketId) {
        return userRepository.findById(ticketId).orElse(null);
    }


    public List<Object> getUserDetails(Long userId) {
        Optional<User> userIds = userRepository.findById(userId);
        if (userIds.isEmpty())
            return null;
        List<Object> routes = routeRepository.findRouteById(Optional.of(userIds));
        List<Object> seats = seatRepository.findSeatById(userIds);
        List<Object> tickets = ticketRepository.findTicketById(userIds);
        List<Object> result = new ArrayList<>();
        result.addAll(seats);
        result.addAll(tickets);
        result.addAll(routes);

        return result;

    }

    public Optional<User> getOneUserWithId(Long userId) {
        return userRepository.findById(userId);

    }

    public void deleteById(Long userid) {
        try {
            userRepository.deleteById(userid);
        } catch (Exception ex) {
            System.out.println(ex+"kayit edilemedi");
        }
    }


}

