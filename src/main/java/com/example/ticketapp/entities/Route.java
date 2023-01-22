package com.example.ticketapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Route")
@Data
public class Route {
    @Id
    Long routeId;
    String fRoute;
    String toRoute;

}
