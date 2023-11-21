package Tickets;

import Person.Person;

import java.util.ArrayList;

public class ConcertTicket extends Ticket{
    public ConcertTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
