package Tickets;

import Person.Person;

import java.util.ArrayList;

public class NotEvenlySplitTicketFactory extends TicketFactory{
    public NotEvenlySplitTicketFactory() {
        super();
    }

    public Ticket createTicket(String type, float price, Person person, ArrayList<Person> paidFor) {
        switch (type) {
            case "airplane":
                return new AirplaneTicket(price, new NotEvenlySplitDecorator(price, person, paidFor), person, paidFor);
            case "concert":
                return new ConcertTicket(price, new NotEvenlySplitDecorator(price, person, paidFor), person, paidFor);
            case "restaurant":
                return new RestaurantTicket(price, new NotEvenlySplitDecorator(price, person, paidFor), person, paidFor);
            case "taxi":
                return new TaxiTicket(price, new NotEvenlySplitDecorator(price, person, paidFor), person, paidFor);
            default:
                return new DefaultTicket(price, new NotEvenlySplitDecorator(price, person, paidFor), person, paidFor);
        }
    }
}
