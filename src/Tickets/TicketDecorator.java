package Tickets;

import Person.Person;

import java.util.ArrayList;
import java.util.Map;

public interface TicketDecorator {
    public Map<Person,Float> getBalanceDifferencePerPerson();
}
