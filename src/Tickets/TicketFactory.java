package Tickets;

import Person.Person;

import java.util.ArrayList;

public abstract class TicketFactory {
    public TicketFactory(){}

    public abstract Ticket createTicket(String type, float price, Person person, ArrayList<Person> paidFor);
}
