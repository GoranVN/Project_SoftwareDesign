package Main.Tickets.Decorators;

import Main.Person.Person;
import java.util.Map;

public interface TicketDecorator {
    public Map<Person,Double> getBalanceDifferencePerPerson();
}
