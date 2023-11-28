package Main.Tickets;

import Main.Person.Person;
import Main.Tickets.Decorators.TicketDecorator;

public class RestaurantTicket extends Ticket{
    public RestaurantTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
