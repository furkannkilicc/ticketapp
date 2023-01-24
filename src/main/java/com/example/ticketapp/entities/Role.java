package com.example.ticketapp.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private   String rolename;


}