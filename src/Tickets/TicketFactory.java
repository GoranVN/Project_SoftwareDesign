package Tickets;

import Person.Person;

import java.util.ArrayList;
import java.util.Map;

public class TicketFactory {
    public TicketFactory(){}

    public Ticket createEvenlySplitTicket(String type, double price, Person person, ArrayList<Person> paidFor) {
        TicketDecorator decorator = new EvenlySplitDecorator(person, price, paidFor);
        switch (type) {
            case "airplane":
                return new AirplaneTicket(price, decorator, person);
            case "concert":
                return new ConcertTicket(price, decorator, person);
            case "restaurant":
                return new RestaurantTicket(price, decorator, person);
            case "taxi":
                return new TaxiTicket(price, decorator, person);
            default:
                return new DefaultTicket(price, decorator, person);
        }
    }

    public Ticket createNotEvenlySplitTicket(String type, Person person, Map<Person,Double> detailedPaidFor) {
        double price = 0;
        TicketDecorator decorator = new NotEvenlySplitDecorator(person, detailedPaidFor);
        for (double i : detailedPaidFor.values()) {
            price+=i;
        }
        switch (type) {
            case "airplane":
                return new AirplaneTicket(price, decorator, person);
            case "concert":
                return new ConcertTicket(price, decorator, person);
            case "restaurant":
                return new RestaurantTicket(price, decorator, person);
            case "taxi":
                return new TaxiTicket(price, decorator, person);
            default:
                return new DefaultTicket(price, decorator, person);
            }
    }
}
