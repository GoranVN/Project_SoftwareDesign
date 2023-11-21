package Tickets;

import Person.Person;

import java.util.ArrayList;

public class TaxiTicket extends Ticket{
    public TaxiTicket(float price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
