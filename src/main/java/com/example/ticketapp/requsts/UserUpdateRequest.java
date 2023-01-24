package com.example.ticketapp.requsts;

import com.example.ticketapp.entities.*;
import lombok.Data;

@Data
public class UserUpdateRequest {
    String id;
    Role role;
    Seat seat;
    User username;
    Route route;




}
