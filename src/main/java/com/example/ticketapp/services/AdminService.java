package com.example.ticketapp.services;

import com.example.ticketapp.entities.Admin;
import com.example.ticketapp.entities.User;
import com.example.ticketapp.reponses.AdminResponse;
import com.example.ticketapp.repos.*;
import com.example.ticketapp.requsts.UserUpdateRequest;
import com.example.ticketapp.responses.TicketResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    AdminRepository adminRepository;
    TicketService ticketService;
    UserService userService;


    public AdminService(AdminRepository adminRepository, TicketService ticketService,UserService userService )

    {

        this.adminRepository = adminRepository;
        this.ticketService = ticketService;
        this.userService= userService;

    }

    public AdminResponse findAdminRole(String role) {
        return adminRepository.findByRole(role);
    }

    public List<Admin> getAllAdmins() {
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


    public Admin deleteAdmin(Long adminId) {
        try {
            adminRepository.deleteById(adminId);
        } catch (Exception e) { //user zaten yok, db'den empty result gelmiş

                   System.out.println("Admin" + adminId + "yok!")
        }
    }


    public User updateUserWithid(Long userid, UserUpdateRequest updateuser) {
        Optional<User> user = userService.getOneUserWithId(userid);
        if (user.isPresent()){
            User toUpdate = user.get();
            toUpdate.setUsername(updateuser.getUsername());
            toUpdate.setRole(updateuser.getRole());
            toUpdate.setTicket(updateuser.getTicket());
            toUpdate.setRoute(updateuser.getRoute());
            toUpdate.setSeat(updateuser.getSeat());
            userService.userRepository.save(toUpdate);
            return  toUpdate;


        }

    }
}

