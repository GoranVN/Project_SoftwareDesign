package Tickets;

import Person.Person;

import java.util.ArrayList;

public class AirplaneTicket extends Ticket{
    public AirplaneTicket(float price, TicketDecorator ticketDecorator, Person person) {
        super(price, ticketDecorator, person);
    }
}
