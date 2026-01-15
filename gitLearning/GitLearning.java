package com.example.ticket;

import java.time.LocalDate;

public class GitLeaning {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private TicketStatus status;
    private String assignedTo;

    public Ticket(Long id, String title, String description,
                  LocalDate startDate, LocalDate endDate,
                  TicketStatus status, String assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        System.out.println("getTitle called");
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        System.out.println("getEndDate called");
        return endDate;
    }

    public TicketStatus getStatus() {
        System.out.println("getStatus called");
        return status;
    }

    public void setStatus(TicketStatus status) {
        System.out.println("setStatus called");
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
