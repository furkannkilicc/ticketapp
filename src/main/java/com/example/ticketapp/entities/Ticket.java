package com.example.ticketapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    Long id;

    Long ticket_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
     User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatNo",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Seat seat;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "routename" )
    @OnDelete(action = OnDeleteAction.CASCADE)
    Route route;



}
