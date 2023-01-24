package com.example.ticketapp.responses;

import com.example.ticketapp.entities.Ticket;
import lombok.Data;

import java.util.List;

@Data
public class TicketResponse {
    Long ticket_id;
    Long user_id;
    Long seatNo;
    String routename;
    List<TicketResponse> ticketResponseList;



    public TicketResponse(Ticket entity) {
        this.ticket_id = entity.getTicket_id();
        this.user_id =entity.getUser().getId();
        this.seatNo =entity.getSeat().getSeatNo();
        this.routename =entity.getRoute().getRoutename();
    }


}
