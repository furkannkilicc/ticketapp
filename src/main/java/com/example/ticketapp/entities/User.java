package com.example.ticketapp.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Ticket ticket;



}
