package com.example.ticketapp.reponses;

import com.example.ticketapp.entities.Role;
import lombok.Data;

@Data
public class RoleResponse {
    Long id;
    String rolename;


    public RoleResponse(Role entity){
        this.rolename = entity.getRolename();
        this.id = entity.getId();
    }

}
