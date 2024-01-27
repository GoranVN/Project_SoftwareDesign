package Tickets.Decorators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Person.*;

public class EvenlySplitDecorator implements TicketDecorator{
    private double price;
    private Person person;
    private ArrayList<Person> paidFor;
    private  Map<Person,Double> BalanceDifference;

    public EvenlySplitDecorator(Person person, double price, ArrayList<Person> paidFor) {
        this.price = price;
        this.person = person;
        this.paidFor = paidFor;
        this.BalanceDifference = getBalanceDifferencePerPerson();
    }

    private Map<Person,Double> getBalanceDifferencePerPerson() {
        Map<Person,Double> differencePerPerson = new HashMap<Person, Double>();
        double pricePerPerson = price/paidFor.size();
        for (Person pers : paidFor) {
            if (!(pers == person)) {
                differencePerPerson.put(pers, - pricePerPerson);
            }
        }
        return differencePerPerson;
    }

    @Override
    public Map<Person, Double> getBalanceDifference() {
        return BalanceDifference;
    }
}
