package com.example.ticketapp.controllers;

import com.example.ticketapp.entities.Ticket;
import com.example.ticketapp.responses.TicketResponse;
import com.example.ticketapp.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
        private TicketService ticketService;
        public TicketController(TicketService ticketService) {
            this.ticketService = ticketService;
        }

        @GetMapping
        public TicketResponse getAllTickets(@RequestParam Optional<Long> ticketId){
            return (TicketResponse) ticketService.getAllTickets(ticketId);
        }
        @GetMapping("/{ticketId}")
    public Optional<Ticket> getTicketById(@PathVariable Long ticketId){
            return ticketService.getOneTicket(ticketId);


        }



}
