package com.example.ticketapp.controllers;

import com.example.ticketapp.entities.Admin;
import com.example.ticketapp.repos.AdminRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class AdminController {
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @GetMapping("/admin")
    public List<Admin>gelAllAdmins(){ return adminRepository.findAll();
    }
    @GetMapping("/{adminId}")
    public Optional<Admin> getOneAdmin(@PathVariable Long adminId){
        return adminRepository.findById(adminId);    }


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
    @DeleteMapping("/{adminId}")
    public  void  deleteAdmin(@PathVariable Long adminId){
        adminRepository.deleteById(adminId);
    }

}
