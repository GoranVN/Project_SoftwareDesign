package Tickets;

import Person.Person;

import java.util.ArrayList;

public class AirplaneTicket extends Ticket{
    public AirplaneTicket(float price, TicketDecorator ticketDecorator, Person person, ArrayList<Person> paidFor) {
        super(price, ticketDecorator, person, paidFor);
    }
}
