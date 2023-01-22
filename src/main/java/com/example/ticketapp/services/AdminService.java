package com.example.ticketapp.services;

import com.example.ticketapp.entities.Admin;
import com.example.ticketapp.repos.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
      AdminRepository adminRepository;
   UserRepository userRepository;
     TicketRepository ticketRepository;
    static RouteRepository routeRepository;
    SeatRepository seatRepository;


    public AdminService(AdminRepository adminRepository,
                        UserRepository userRepository,
                        TicketRepository ticketRepository,
                        RouteRepository routeRepository ,
                        SeatRepository seatRepository)
    {

        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.routeRepository = routeRepository;
        this.seatRepository = seatRepository;
    }

    public List<Admin> getAllAdmins(Optional<Long> adminId) {
            if(adminId.isPresent())
                return  adminRepository.findByAdminId(adminId.get());
            return adminRepository.findAll();


    }

    public List<Object> getTicketDetails(Optional<Long> ticketId) {
        if(ticketId.isPresent())
        List<Object> seats = seatRepository.findSeatById(ticketId);
        List<Object> routes = routeRepository.findRouteById(ticketId);
        List<Object> tickets=  ticketRepository.findTicketById(ticketId);
        List<Object> result = new ArrayList<>();
        result.addAll(seats);
        result.addAll(tickets);
        result.addAll(routes);
        return result;
    }


    public void deleteAdmin(Long adminId) {
        try {
            adminRepository.deleteById(adminId);
        } catch (Exception e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("Admin" + adminId + "yok!");
        }
    }

}