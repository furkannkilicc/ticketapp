package com.example.ticketapp.services;

import com.example.ticketapp.entities.User;
import com.example.ticketapp.repos.UserRepository;
import com.example.ticketapp.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImp implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//UserDetails tipinde obje döndürüyor, JwtUserdetails  i kapsar
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return JwtUserDetails.create(user);
    }
    public  UserDetails loadUserById(Long id){
        User user = userRepository.findById(id).get();
        return  JwtUserDetails.create(user);
    }

}
