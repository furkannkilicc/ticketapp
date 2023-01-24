package com.example.ticketapp.reponses;

import com.example.ticketapp.entities.Route;
import lombok.Data;

@Data
public class RouteResponse {
    Long id;
    String routenames;

    public  RouteResponse(Route entity){
        this.id= entity.getRouteId();
        this.routenames= entity.getRoutename();
    }

}
