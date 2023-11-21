import Databases.TicketDatabase;
import Person.Person;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TicketDatabase ticketDatabase = new TicketDatabase();
        Person person1 = new Person("Piet", 0);
        Person person2 = new Person("Jan", 0);
        Person person3 = new Person("Gert", 0);
        ArrayList<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        ticketDatabase.newEvenlySplitTicket("Restaurant", 5.12, person1, personList);
    }
}