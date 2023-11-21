package Tickets;

import Person.Person;

import java.util.ArrayList;

public class RestaurantTicket extends Ticket{
    public RestaurantTicket(float price, TicketDecorator ticketDecorator, Person person, ArrayList<Person> paidFor) {
        super(price, ticketDecorator, person, paidFor);
    }
}
