package Tickets;

import Person.Person;

import java.util.ArrayList;

public class ConcertTicket extends Ticket{
    public ConcertTicket(float price, TicketDecorator ticketDecorator, Person person, ArrayList<Person> paidFor) {
        super(price, ticketDecorator, person, paidFor);
    }
}
