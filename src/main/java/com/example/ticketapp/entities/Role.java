package com.example.ticketapp.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    private   String rolename;


}