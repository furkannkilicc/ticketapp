package com.example.ticketapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "seat")
@Data

public class Seat {

    @Id
    Long seatId;

    Long seatNo;
}
