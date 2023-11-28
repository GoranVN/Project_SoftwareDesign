package Tickets;

import Person.Person;
import Tickets.Decorators.*;

import java.util.ArrayList;
import java.util.Map;

public class TicketFactory {
    public TicketFactory(){}

    public Ticket createEvenlySplitTicket(String type, double price, Person person, ArrayList<Person> paidFor) {
        TicketDecorator decorator = new EvenlySplitDecorator(person, price, paidFor);
        return switch (type) {
            case "airplane" -> new AirplaneTicket(price, decorator, person);
            case "concert" -> new ConcertTicket(price, decorator, person);
            case "restaurant" -> new RestaurantTicket(price, decorator, person);
            case "taxi" -> new TaxiTicket(price, decorator, person);
            default -> new DefaultTicket(price, decorator, person);
        };
    }

    public Ticket createNotEvenlySplitTicket(String type, Person person, Map<Person,Double> detailedPaidFor) {
        double price = 0;
        TicketDecorator decorator = new NotEvenlySplitDecorator(person, detailedPaidFor);
        for (double i : detailedPaidFor.values()) {
            price+=i;
        }
        return switch (type) {
            case "airplane" -> new AirplaneTicket(price, decorator, person);
            case "concert" -> new ConcertTicket(price, decorator, person);
            case "restaurant" -> new RestaurantTicket(price, decorator, person);
            case "taxi" -> new TaxiTicket(price, decorator, person);
            default -> new DefaultTicket(price, decorator, person);
        };
    }
}
