import Databases.PersonDatabase;
import GUI.Controller;
import GUI.View;

import Databases.TicketDatabase;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Person person1 = new Person("Piet", 0);
        Person person2 = new Person("Jan", 0);
        Person person3 = new Person("Gert", 0);
        TicketDatabase ticketDB = TicketDatabase.getInstance();
        PersonDatabase personDB = PersonDatabase.getInstance();
        personDB.addEntry(person1);
        personDB.addEntry(person2);
        personDB.addEntry(person3);

        Map<Person, Double> pricePerPerson = new HashMap<Person, Double>();
        pricePerPerson.put(person1, 2.0);
        pricePerPerson.put(person2, 1.5);
        pricePerPerson.put(person3, 1.62);

        //ticketDB.newEvenlySplitTicket("Restaurant", 5.12, person1, personDB.getEntries());
        ticketDB.newNotEvenlySplitTicket("Restaurant", person1, pricePerPerson);
        for (Ticket ticket : ticketDB.getEntries()) {
            personDB.updateBalance(ticket.getBalanceDifferencePerPerson());
        }
        System.out.print("Person database: ");
        for (Person person : personDB.getEntries())
            System.out.print(person.toString());
    }
}