package Main.Tickets;

import Main.Person.Person;
import Main.Tickets.Decorators.TicketDecorator;

public class ConcertTicket extends Ticket{
    public ConcertTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
