package Tickets;

import Person.Person;
import Tickets.Decorators.TicketDecorator;

public class AirplaneTicket extends Ticket{
    public AirplaneTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
