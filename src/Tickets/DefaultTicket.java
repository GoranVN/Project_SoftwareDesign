package Tickets;

import Person.Person;


public class DefaultTicket extends Ticket{
    public DefaultTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
