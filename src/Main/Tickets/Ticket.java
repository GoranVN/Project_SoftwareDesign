package Tickets;

import Person.*;
import Tickets.Decorators.TicketDecorator;

import java.util.Map;

public abstract class Ticket {
    private double price;
    private TicketDecorator ticketDecorator;
    private Person person;
    public Ticket(double price, TicketDecorator ticketDecorator, Person person) {
        this.price = price;
        this.ticketDecorator = ticketDecorator;
        this.person = person;
    }

    public Map<Person, Double> getBalanceDifferencePerPerson() {
        return ticketDecorator.getBalanceDifference();
    }
}
