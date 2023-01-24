package com.example.ticketapp.reponses;

import com.example.ticketapp.entities.Admin;
import lombok.Data;

@Data
public class AdminResponse {
    Long id;
    String username;
    RoleResponse roles;

public AdminResponse(Admin entity){
    this.id = entity.getId();
    this.username= entity.getUsername();
    this.roles = roles;

}

}
