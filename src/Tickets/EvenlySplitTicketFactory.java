package Tickets;

import java.util.ArrayList;
import Person.*;

public class EvenlySplitTicketFactory extends TicketFactory{
    public EvenlySplitTicketFactory() {
        super();
    }

    public Ticket createTicket(String type, float price, Person person, ArrayList<Person> paidFor) {
        switch (type) {
            case "airplane":
                return new AirplaneTicket(price, new EvenlySplitDecorator(price, person, paidFor), person, paidFor);
            case "concert":
                return new ConcertTicket(price, new EvenlySplitDecorator(price, person, paidFor), person, paidFor);
            case "restaurant":
                return new RestaurantTicket(price, new EvenlySplitDecorator(price, person, paidFor), person, paidFor);
            case "taxi":
                return new TaxiTicket(price, new EvenlySplitDecorator(price, person, paidFor), person, paidFor);
            default:
                return new DefaultTicket(price, new EvenlySplitDecorator(price, person, paidFor), person, paidFor);
        }
    }
}
