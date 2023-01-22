package com.example.ticketapp.controllers;

import com.example.ticketapp.entities.User;
import com.example.ticketapp.repos.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserRepository userRepository;

    public  UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping()
    public  User createUser(@RequestParam User newUser){
        return  userRepository.save(newUser);
    }
    @GetMapping("/{userId}")
    public Optional<User> getOneUser(@PathVariable Long userId){
//        custom exception eklenecek


        return  userRepository.findById(userId);

    }
    @GetMapping("/{ticketId}")
    public Optional<User> getUserTickets(@PathVariable Long ticketId){
        return  userRepository.findById(ticketId);
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

