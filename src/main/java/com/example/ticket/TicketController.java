package com.example.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private RefundService refundService;

    @PostMapping("/cancel")
    public Ticket cancelTicket(@RequestBody TicketRequest request) {
        // In a real app, we'd fetch the ticket from a DB.
        // For this demo, we'll create a dummy ticket based on the request.
        Ticket ticket = new Ticket(request.getTicketId(), request.getPrice(), request.getDepartureTime());
        return refundService.processCancellation(ticket);
    }
}

class TicketRequest {
    private String ticketId;
    private double price;
    private LocalDateTime departureTime;

    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
}
