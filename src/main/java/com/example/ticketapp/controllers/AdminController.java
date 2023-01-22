package com.example.ticketapp.controllers;
import com.example.ticketapp.entities.Admin;
import com.example.ticketapp.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;
    public AdminController(AdminService adminService) {
            this.adminService=adminService;
    }
    @GetMapping
    public List<Admin>gelAllAdmins(@RequestParam Optional<Long> adminId){ return AdminService.getAllAdmins(adminId);
    }
    @GetMapping("/tickets/{ticketId}")
    public List<Admin> GetTicketDetails(@RequestParam Optional<Long> ticketId ){
        return AdminService.getTicketDetails(ticketId);
    }


    @DeleteMapping("/{adminId}")
    public  void  deleteAdmin(@PathVariable Long adminId){
        adminService.deleteAdmin(adminId);
    }



//    @GetMapping("/{userId}")
//    public List<User>getAllUsers(){ return UserRepository;
//
//    }
//    @GetMapping("/{userId}")
//    public Optional<User>GetUserWithId(){ return UserRepository;
//    }

//    @PutMapping("/{userId]")
//    public User UpdateOneUser(@PathVariable Long userId , @RequestBody User newUser){
//        Optional<User> user = userRepository.findById(userId);
//        if(user.isPresent()){
//            User foundUser = user.get();
//            foundUser.setUsername(newUser.getUsername());
//            userRepository.save(foundUser);
//            return  foundUser;
//        }
//        else{
//            return  null;}
//    }


}
