package Tickets;

import Person.*;

import java.util.ArrayList;
import java.util.Map;

public abstract class Ticket {
    private float price;
    private TicketDecorator ticketDecorator;
    private Person person;
    public Ticket(float price, TicketDecorator ticketDecorator, Person person) {
        this.price = price;
        this.ticketDecorator = ticketDecorator;
        this.person = person;
    }

    public Map<Person, Float> getBalanceDifferencePerPerson() {
        return ticketDecorator.getBalanceDifferencePerPerson();
    }
}
