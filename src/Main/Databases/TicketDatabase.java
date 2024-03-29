package Databases;

import Person.Person;
import Tickets.Ticket;
import Tickets.TicketFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TicketDatabase extends AbstractDatabase implements Observable{
    private ArrayList<Ticket> ticketList;
    private TicketFactory ticketFactory;
    private static TicketDatabase firstInstance = null;
    private Observer observer;
    private TicketDatabase(Observer observer) {
        ticketList = new ArrayList<>();
        ticketFactory = new TicketFactory();
        this.observer = observer;
    }

    public static TicketDatabase getInstance(Observer observer) {
        if (firstInstance == null) {
            firstInstance = new TicketDatabase(observer);
        }
        return firstInstance;
    }
    public void newEvenlySplitTicket(String type, double price, Person person, ArrayList<Person> paidFor) {
        Ticket newTicket = ticketFactory.createEvenlySplitTicket(type, price, person, paidFor);
        ticketList.add(newTicket);
        notifyObservers(newTicket.getBalanceDifferencePerPerson());
    }

    public void newNotEvenlySplitTicket(String type, Person person, Map<Person,Double> detailedPaidFor){
        Ticket newTicket = ticketFactory.createNotEvenlySplitTicket(type, person, detailedPaidFor);
        ticketList.add(newTicket);
        notifyObservers(newTicket.getBalanceDifferencePerPerson());
    }

    public void removeTicket(Ticket ticket) {
        ticketList.remove(ticket);
        Map<Person, Double> balanceDifference = new HashMap<>();
        for (Map.Entry<Person, Double> entry : ticket.getBalanceDifferencePerPerson().entrySet()) {
            balanceDifference.put(entry.getKey(), - entry.getValue());
        }
        notifyObservers(balanceDifference);
    }
    @Override
    public void deleteAll() {
        ticketList.clear();
    }
    @Override
    public ArrayList<Ticket> getEntries(){
        return ticketList;
    }

    public void notifyObservers(Map<Person,Double> balancePerPerson) {
        observer.updateBalance(balancePerPerson);
    }
}
