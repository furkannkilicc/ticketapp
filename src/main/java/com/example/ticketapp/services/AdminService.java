package com.example.ticketapp.services;

import com.example.ticketapp.entities.Admin;
import com.example.ticketapp.entities.Ticket;
import com.example.ticketapp.repos.*;
import com.example.ticketapp.responses.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    AdminRepository adminRepository;
    TicketService ticketService;


    public AdminService(AdminRepository adminRepository, TicketService ticketService)

    {

        this.adminRepository = adminRepository;
        this.ticketService = ticketService;

    }

    public List<Admin> getAllAdmins(Optional<Long> adminId) {
        if(adminId.isPresent())
            return  adminRepository.findByAdminId(adminId.get());
        return adminRepository.findAll();


    }
    public  List <TicketResponse> getAllTickets(Optional <Long> ticketId){
        if(ticketService.getAllTickets(ticketId).isEmpty()){
            return  null;
        }
        return ticketService.getAllTickets(ticketId);
    }

//    public List<Object> (Optional<Long> ticketId) {
//        if(ticketId.isPresent())
//            List<Object> seats = seatRepository.findSeatById(ticketId);
//        List<Object> routes = routeRepository.findRouteById(ticketId);
//        List<Object> tickets=  ticketRepository.findTicketById(ticketId);
//        List<Object> result = new ArrayList<>();
//        result.addAll(seats);
//        result.addAll(tickets);
//        result.addAll(routes);
//        return result;
//    }


    public void deleteAdmin(Long adminId) {
        try {
            adminRepository.deleteById(adminId);
        } catch (Exception e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("Admin" + adminId + "yok!");
        }
    }

}