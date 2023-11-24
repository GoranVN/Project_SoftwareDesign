package Tickets;

import Person.Person;

public class ConcertTicket extends Ticket{
    public ConcertTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
