package Tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Person.*;

public class EvenlySplitDecorator implements TicketDecorator{
    public EvenlySplitDecorator() {
    }

    public Map<Person,Float> getBalanceDifferencePerPerson(float price, Person person, ArrayList<Person> paidFor) {
        Map<Person,Float> differencePerPerson = new HashMap<Person, Float>();
        float pricePerPerson = price/paidFor.size();
        for (Person pers : paidFor) {
            if (!(pers == person)) {
                differencePerPerson.put(pers, - pricePerPerson);
            }
        }
        if (paidFor.contains(person)) {
            differencePerPerson.put(person, price - pricePerPerson);
        } else {
            differencePerPerson.put(person, price);
        }
        return differencePerPerson;
    }
}
