package Tickets;

import Person.Person;


public class TaxiTicket extends Ticket{
    public TaxiTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
