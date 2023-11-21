package Tickets;

import Person.Person;

import java.util.ArrayList;

public class DefaultTicket extends Ticket{
    public DefaultTicket(float price, TicketDecorator ticketDecorator, Person person, ArrayList<Person> paidFor) {
        super(price, ticketDecorator, person, paidFor);
    }
}
