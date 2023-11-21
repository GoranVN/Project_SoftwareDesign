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
        TicketFactory ticketFactory = new TicketFactory();
        Person person1 = new Person("Piet", 0);
        Person person2 = new Person("Jan", 0);
        Person person3 = new Person("Gert", 0);
        ArrayList<Person> personList = new ArrayList<Person>();
        //personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        Map<Person, Double> pricePerPerson = new HashMap<Person, Double>();
        pricePerPerson.put(person1, 2.0);
        pricePerPerson.put(person2, 1.5);
        pricePerPerson.put(person3, 1.62);
        Ticket ticket1 = ticketFactory.createEvenlySplitTicket("Restaurant", 5.12, person1, personList);
        System.out.print("Ticket1: ");
        System.out.println(ticket1.getBalanceDifferencePerPerson());
        Ticket ticket2 = ticketFactory.createNotEvenlySplitTicket("Restaurant", person1, pricePerPerson);
        System.out.print("Ticket2: ");
        System.out.println(ticket2.getBalanceDifferencePerPerson());

    }
}