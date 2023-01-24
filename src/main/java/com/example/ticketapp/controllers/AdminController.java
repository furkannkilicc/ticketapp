package com.example.ticketapp.controllers;

import com.example.ticketapp.entities.Admin;
import com.example.ticketapp.entities.User;
import com.example.ticketapp.reponses.AdminResponse;
import com.example.ticketapp.requsts.UserUpdateRequest;
import com.example.ticketapp.services.AdminService;
import com.example.ticketapp.services.TicketService;
import com.example.ticketapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private AdminService adminService;
    private TicketService ticketService;
    private UserService userService;

    public AdminController(AdminService adminService,
                           TicketService ticketService,
                           UserService userService) {
        this.adminService = adminService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();


    }

    @GetMapping("/{role}")
    public AdminResponse findAdminRole(@RequestParam String role) {
        return adminService.findAdminRole(role);
    }

    @DeleteMapping("/{userid}")
    public User deleteOneUser(@RequestParam Long userid) {
        if (userService.getOneUserWithId(userid).isPresent()) {
            userService.deleteById(userid);
        }

            return null;
    }

    @PutMapping("{/userid}")
    public  User UpdateUser(@PathVariable Long userid, @RequestParam  UserUpdateRequest updateuser){
        return  adminService.updateUserWithid(userid,updateuser);


    }


}




