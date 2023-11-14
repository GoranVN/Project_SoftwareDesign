package Tickets;

public abstract class TicketFactory {
    public TicketFactory(){}

    public abstract Ticket createTicket(String type, float price);
}
