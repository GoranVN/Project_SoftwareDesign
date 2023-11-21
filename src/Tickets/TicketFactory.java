package Tickets;

import Person.Person;

import java.util.ArrayList;
import java.util.Map;

public class TicketFactory {
    public TicketFactory(){}

    public Ticket createEvenlySplitTicket(String type, float price, Person person, ArrayList<Person> paidFor) {
        switch (type) {
            case "airplane":
                return new AirplaneTicket(price, new EvenlySplitDecorator(person, price, paidFor), person);
            case "concert":
                return new ConcertTicket(price, new EvenlySplitDecorator(person, price, paidFor), person);
            case "restaurant":
                return new RestaurantTicket(price, new EvenlySplitDecorator(person, price, paidFor), person);
            case "taxi":
                return new TaxiTicket(price, new EvenlySplitDecorator(person, price, paidFor), person);
            default:
                return new DefaultTicket(price, new EvenlySplitDecorator(person, price, paidFor), person);
        }
    }

    public Ticket createNotEvenlySplitTicket(String type, float price, Person person, Map<Person,Float> detailedPaidFor) {
        switch (type) {
            case "airplane":
                return new AirplaneTicket(price, new NotEvenlySplitDecorator(person, detailedPaidFor), person);
            case "concert":
                return new ConcertTicket(price, new NotEvenlySplitDecorator(person, detailedPaidFor), person);
            case "restaurant":
                return new RestaurantTicket(price, new NotEvenlySplitDecorator(person, detailedPaidFor), person);
            case "taxi":
                return new TaxiTicket(price, new NotEvenlySplitDecorator(person, detailedPaidFor), person);
            default:
                return new DefaultTicket(price, new NotEvenlySplitDecorator(person, detailedPaidFor), person);
            }
    }
}
