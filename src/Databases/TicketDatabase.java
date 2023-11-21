package Databases;

import Person.Person;
import Tickets.Ticket;
import Tickets.TicketFactory;

import java.util.ArrayList;
import java.util.Map;

public class TicketDatabase {
    private ArrayList<Ticket> ticketList;
    private TicketFactory ticketFactory;
    public TicketDatabase() {
        ticketList = new ArrayList<>();
        ticketFactory = new TicketFactory();
    }
    public void newEvenlySplitTicket(String type, float price, Person person, ArrayList<Person> paidFor) {
        ticketList.add(ticketFactory.createEvenlySplitTicket(type, price, person, paidFor));
    }

    public void newNotEvenlySplitTicket(String type, boolean evenlySplit, float price, Person person, Map<Person,Float> detailedPaidFor){
        ticketList.add(ticketFactory.createNotEvenlySplitTicket(type, price, person, detailedPaidFor));
    }
}
