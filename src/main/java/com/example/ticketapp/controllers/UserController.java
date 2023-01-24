package com.example.ticketapp.controllers;

import com.example.ticketapp.entities.User;
import com.example.ticketapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {
private  UserService userService;
    public  UserController(UserService userService){
            this.userService= userService;

    }

    @PostMapping
    public  User createUser(@RequestParam User newUser){
     return userService.saveOneUser(newUser);

    }

    @GetMapping("{userId}")
    public Optional<User> getOneUser(@PathVariable Long userId){
        return  userService.getOneUserWithId(userId);
    }





    @GetMapping("/{ticketId}")
    public User getUserTickets(@PathVariable Long ticketId){
        return userService.getUserTickets(ticketId);
    }
    @GetMapping("/details/{userId}")
    public List<Object> getUserDetails(@PathVariable Long userId) {
        return userService.getUserDetails(userId);
    }



}

