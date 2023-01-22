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
        return  UserService.saveOneUser(newUser);
    }
    @GetMapping("/{userId}")
    public Optional<User> getOneUser(@PathVariable Long userId){
//        custom exception eklenecek


        return  UserService.getOneUser(userId);

    }
    @GetMapping("/{ticketId}")
    public Optional<User> getUserTickets(@PathVariable Long ticketId){
        return  UserService.getUserTickets(ticketId);
    }
    @GetMapping("/details/{userId}")
    public List<Object> getUserDetails(@PathVariable Long userId) {
        return userService.getUserDetails(userId);
    }

//    @PutMapping("/{userId]")
//    public  User UpdateOneUser(@PathVariable Long userId, @RequestBody User newUser){
//        Optional<User> user = userRepository.findById(userId);
//        if(user.isPresent()){
//            User foundUser = user.get();
//            foundUser.setUsername(newUser.getUsername());
//            foundUser.setPassword(newUser.getPassword());
//            userRepository.save(foundUser);
//            return  foundUser;
//        }
//        else{
//            return  null;}
//    }


}

