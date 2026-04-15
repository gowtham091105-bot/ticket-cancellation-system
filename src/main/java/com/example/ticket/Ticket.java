package com.example.ticket;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private double price;
    private LocalDateTime departureTime;
    private boolean cancelled;
    private double refundAmount;

    public Ticket(String ticketId, double price, LocalDateTime departureTime) {
        this.ticketId = ticketId;
        this.price = price;
        this.departureTime = departureTime;
        this.cancelled = false;
        this.refundAmount = 0.0;
    }

    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public boolean isCancelled() { return cancelled; }
    public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
    public double getRefundAmount() { return refundAmount; }
    public void setRefundAmount(double refundAmount) { this.refundAmount = refundAmount; }
}
