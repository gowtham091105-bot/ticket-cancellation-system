package com.example.ticket;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Duration;

@Service
public class RefundService {

    public Ticket processCancellation(Ticket ticket) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, ticket.getDepartureTime());
        long hoursBeforeDeparture = duration.toHours();

        ticket.setCancelled(true);

        if (hoursBeforeDeparture >= 24) {
            ticket.setRefundAmount(ticket.getPrice() * 0.90);
        } else if (hoursBeforeDeparture >= 2) {
            ticket.setRefundAmount(ticket.getPrice() * 0.50);
        } else {
            ticket.setRefundAmount(0.0);
        }

        return ticket;
    }
}
