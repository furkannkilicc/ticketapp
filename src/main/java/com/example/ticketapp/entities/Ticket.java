package com.example.ticketapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ticket_id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
     User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatNo")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Seat seat;
    String status;
    String route;

}
