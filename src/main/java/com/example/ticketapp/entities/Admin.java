package com.example.ticketapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    Long id;
    String username;
    String password;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "rolename")
    Role role;

}