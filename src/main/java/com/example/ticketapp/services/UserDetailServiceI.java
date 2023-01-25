package com.example.ticketapp.services;

import com.example.ticketapp.entities.User;
import com.example.ticketapp.repos.UserRepository;
import com.example.ticketapp.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserDetailServiceI implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailServiceI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(Long.valueOf(username));
        return JwtUserDetails.create(user);
    }

}
