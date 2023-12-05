package Main;

import Main.Databases.PersonDatabase;
import Main.GUI.Controller;

import Main.Databases.TicketDatabase;
import Main.Person.Person;
import Main.Tickets.Ticket;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Person person1 = new Person("Piet", 0);
        Person person2 = new Person("Jan", 0);
        Person person3 = new Person("Gert", 0);
        Person person4 = new Person("Bert", 0);
        TicketDatabase ticketDB = TicketDatabase.getInstance();
        PersonDatabase personDB = PersonDatabase.getInstance();
        personDB.addEntry(person1);
        personDB.addEntry(person2);
        personDB.addEntry(person3);
        personDB.addEntry(person4);

        Map<Person, Double> pricePerPerson = new HashMap<Person, Double>();
        pricePerPerson.put(person1, 2.0);
        pricePerPerson.put(person2, 1.5);
        pricePerPerson.put(person3, 1.62);
        //pricePerPerson.put(person4, 3.0);

        ticketDB.newEvenlySplitTicket("Restaurant", 10.0, person3, personDB.getEntries());
        ticketDB.newNotEvenlySplitTicket("Restaurant", person2, pricePerPerson);
        for (Ticket ticket : ticketDB.getEntries()) {
            personDB.updateBalance(ticket.getBalanceDifferencePerPerson());
        }
        System.out.print("Main.Person database: ");
        for (Person person : personDB.getEntries())
            System.out.print(person.toString() + ' ');
    }
}