package Tickets;

import Person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotEvenlySplitDecorator implements TicketDecorator{
    private Map<Person,Float> detailedPaidFor;
    private Person person;
    public NotEvenlySplitDecorator(Person person, Map<Person,Float> detailedPaidFor) {
        this.detailedPaidFor = detailedPaidFor;
        this.person = person;
    }

    @Override
    public Map<Person,Float> getBalanceDifferencePerPerson() {
        Map<Person,Float> differencePerPerson = new HashMap<Person, Float>();
        float totalPrice = 0;
        for (Map.Entry<Person, Float> entry : detailedPaidFor.entrySet()) {
            if (!(entry.getKey() == person)) {
                differencePerPerson.put(entry.getKey(), - entry.getValue());
                totalPrice += entry.getValue();
            }
        }
        differencePerPerson.put(person, totalPrice);
        return differencePerPerson;
    }
}
