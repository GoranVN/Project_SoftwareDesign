package Tickets;

import Person.Person;

public class RestaurantTicket extends Ticket{
    public RestaurantTicket(double price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
