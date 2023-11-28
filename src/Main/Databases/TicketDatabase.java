package Main.Databases;

import Main.Person.Person;
import Main.Tickets.Ticket;
import Main.Tickets.TicketFactory;

import java.util.ArrayList;
import java.util.Map;

public class TicketDatabase extends AbstractDatabase{
    private ArrayList<Ticket> ticketList;
    private TicketFactory ticketFactory;
    private static TicketDatabase firstInstance = null;
    private TicketDatabase() {
        ticketList = new ArrayList<>();
        ticketFactory = new TicketFactory();
    }

    public static TicketDatabase getInstance() {
        if (firstInstance == null) {
            firstInstance = new TicketDatabase();
        }
        return firstInstance;
    }
    public void newEvenlySplitTicket(String type, double price, Person person, ArrayList<Person> paidFor) {
        ticketList.add(ticketFactory.createEvenlySplitTicket(type, price, person, paidFor));
    }

    public void newNotEvenlySplitTicket(String type, Person person, Map<Person,Double> detailedPaidFor){
        ticketList.add(ticketFactory.createNotEvenlySplitTicket(type, person, detailedPaidFor));
    }

    public ArrayList<Ticket> getEntries(){
        return ticketList;
    }
}
