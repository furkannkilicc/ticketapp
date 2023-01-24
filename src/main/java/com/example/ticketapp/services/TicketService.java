package com.example.ticketapp.services;

import com.example.ticketapp.entities.Ticket;
import com.example.ticketapp.repos.TicketRepository;
import com.example.ticketapp.responses.TicketResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service

public class TicketService {
    TicketRepository ticketRepository;
    TicketResponse ticketResponse;

    public TicketService(TicketRepository ticketRepository, TicketResponse ticketResponse) {
        this.ticketRepository = ticketRepository;
        this.ticketResponse = ticketResponse;
    }

    public Optional<Ticket> getOneTicket(Long ticketId) {
        return ticketRepository.findById(ticketId);

    }

    public List<TicketResponse> getAllTickets(Optional<Long> ticketId) {
        List<Ticket> tickets = null;
        if (ticketId.isPresent()) {
            ticketRepository.findById(ticketId.get());
        }
         ticketRepository.findAll();
       return tickets.stream().map(ticket -> new TicketResponse(ticket)).collect(Collectors.toList());

    }


}
