package Tickets.Decorators;

import Person.Person;
import java.util.Map;

public interface TicketDecorator {
    public Map<Person, Double> getBalanceDifference();
}
