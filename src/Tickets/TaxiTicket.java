package Tickets;

import Person.Person;

import java.util.ArrayList;

public class TaxiTicket extends Ticket{
    public TaxiTicket(float price, TicketDecorator ticketDecorator, Person person, ArrayList<Person> paidFor) {
        super(price, ticketDecorator, person, paidFor);
    }
}
