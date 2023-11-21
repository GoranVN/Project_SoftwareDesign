package Tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Person.*;

public class EvenlySplitDecorator implements TicketDecorator{
    private float price;
    private Person person;
    private ArrayList<Person> paidFor;

    public EvenlySplitDecorator(Person person, float price, ArrayList<Person> paidFor) {
        this.price = price;
        this.person = person;
        this.paidFor = paidFor;
    }

    @Override
    public Map<Person,Float> getBalanceDifferencePerPerson() {
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
