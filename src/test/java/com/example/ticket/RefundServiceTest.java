package com.example.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class RefundServiceTest {

    private final RefundService refundService = new RefundService();

    @Test
    public void testFullRefund_90Percent() {
        LocalDateTime tomorrow = LocalDateTime.now().plusHours(25);
        Ticket ticket = new Ticket("T123", 100.0, tomorrow);
        
        Ticket cancelledTicket = refundService.processCancellation(ticket);
        
        assertEquals(90.0, cancelledTicket.getRefundAmount());
        assertTrue(cancelledTicket.isCancelled());
    }

    @Test
    public void testPartialRefund_50Percent() {
        LocalDateTime inFiveHours = LocalDateTime.now().plusHours(5);
        Ticket ticket = new Ticket("T456", 100.0, inFiveHours);
        
        Ticket cancelledTicket = refundService.processCancellation(ticket);
        
        assertEquals(50.0, cancelledTicket.getRefundAmount());
        assertTrue(cancelledTicket.isCancelled());
    }

    @Test
    public void testNoRefund() {
        LocalDateTime inOneHour = LocalDateTime.now().plusHours(1);
        Ticket ticket = new Ticket("T789", 100.0, inOneHour);
        
        Ticket cancelledTicket = refundService.processCancellation(ticket);
        
        assertEquals(0.0, cancelledTicket.getRefundAmount());
        assertTrue(cancelledTicket.isCancelled());
    }
}
