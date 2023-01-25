package com.example.ticketapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "route")
@Data
public class Route {
    @Id
    @Column(name = "route_id")
    Long routeId;
    String routename;


}
