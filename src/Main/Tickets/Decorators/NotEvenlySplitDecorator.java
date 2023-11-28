package Main.Tickets.Decorators;

import Main.Person.Person;

import java.util.HashMap;
import java.util.Map;

public class NotEvenlySplitDecorator implements TicketDecorator {
    private Map<Person,Double> detailedPaidFor;
    private Person person;
    public NotEvenlySplitDecorator(Person person, Map<Person,Double> detailedPaidFor) {
        this.detailedPaidFor = detailedPaidFor;
        this.person = person;
    }

    @Override
    public Map<Person,Double> getBalanceDifferencePerPerson() {
        Map<Person,Double> differencePerPerson = new HashMap<Person, Double>();
        double totalPrice = 0;
        for (Map.Entry<Person, Double> entry : detailedPaidFor.entrySet()) {
            if (!(entry.getKey() == person)) {
                differencePerPerson.put(entry.getKey(), - entry.getValue());
                totalPrice += entry.getValue();
            }
        }
        differencePerPerson.put(person, totalPrice);
        return differencePerPerson;
    }
}
