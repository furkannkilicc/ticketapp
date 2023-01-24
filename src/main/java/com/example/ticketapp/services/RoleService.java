package com.example.ticketapp.services;

import com.example.ticketapp.repos.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
