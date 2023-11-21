package Tickets;

import Person.*;

import java.util.ArrayList;
import java.util.Map;

public abstract class Ticket {
    private float price;
    private TicketDecorator ticketDecorator;
    private Person person;
    private ArrayList<Person> paidFor;
    public Ticket(float price, TicketDecorator ticketDecorator, Person person, ArrayList<Person> paidFor) {
        this.price = price;
        this.ticketDecorator = ticketDecorator;
        this.person = person;
        this.paidFor= paidFor;
    }

    public Map<Person, Float> getBalanceDifferencePerPerson() {
        return ticketDecorator.getBalanceDifferencePerPerson(price, person, paidFor);
    }
}
