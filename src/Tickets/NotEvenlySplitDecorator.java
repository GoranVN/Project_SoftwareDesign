package Tickets;

import Person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotEvenlySplitDecorator implements TicketDecorator{
    public NotEvenlySplitDecorator() {
    }

    public Map<Person,Float> getBalanceDifferencePerPerson(float price, Person person, ArrayList<Person> paidFor) {
        Map<Person,Float> differencePerPerson = new HashMap<Person, Float>();
        return differencePerPerson;
    }
}
