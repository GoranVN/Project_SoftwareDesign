import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import Person.*;
import Tickets.Decorators.*;
import Databases.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Run with PowerMock, an extended version of Mockito
@RunWith(PowerMockRunner.class)
// Prepare class Conroller for an integration test
@PrepareForTest(TicketDatabase.class)

public class TicketDatabase_ITest
{
    public TicketDatabase_ITest()
    {

    }

    @Before
    public void initialize()
    {

    }

    @Test
    public void newNotEvenlySplitTicket()
    {
        // Create objects for persons
        Person person1 = new Person("Piet", 0);
        Person person2 = new Person("Jan", 0);
        Person person3 = new Person("Gert", 0);
        Person person4 = new Person("Bert", 0);

        // Creating the PersonDatabase and adding the created persons to it
        // (for testing set the private constructor for PersonDatabase to public)
        PersonDatabase personDB = new PersonDatabase();
        personDB.addEntry(person1);
        personDB.addEntry(person2);
        personDB.addEntry(person3);
        personDB.addEntry(person4);

        // Creating the price per person for creating a not evenly split ticket
        Map<Person, Double> pricePerPerson = new HashMap<Person, Double>();
        pricePerPerson.put(person1, 2.0);
        pricePerPerson.put(person2, 1.5);
        pricePerPerson.put(person3, 1.5);
        pricePerPerson.put(person4, 3.0);

        // Creating the ticketdatabase under test
        // (for testing set the private contructor for TicketDatabase to public)
        TicketDatabase ticketDBUnderTest = new TicketDatabase(personDB);

        ticketDBUnderTest.newNotEvenlySplitTicket("restaurant", person1, pricePerPerson);
        Map<Person, Double> testResult = new HashMap<>();
        for (Person person : personDB.getEntries()) {
            testResult.put(person, person.getBalance());
        }
        Map<Person, Double> expectedResult = new HashMap<>();
        expectedResult.put(person1, 6.0);
        expectedResult.put(person2, -1.5);
        expectedResult.put(person3, -1.5);
        expectedResult.put(person4, -3.0);
        Assert.assertEquals("Testing newNotEvenlySplitTicket()", testResult, expectedResult);
    }

    @Test
    public void newEvenlySplitTicket()
    {
        // Create objects for persons
        Person person1 = new Person("Piet", 0);
        Person person2 = new Person("Jan", 0);
        Person person3 = new Person("Gert", 0);
        Person person4 = new Person("Bert", 0);

        // Creating the PersonDatabase and adding the created persons to it
        // (for testing set the private constructor for PersonDatabase to public)
        PersonDatabase personDB = new PersonDatabase();
        personDB.addEntry(person1);
        personDB.addEntry(person2);
        personDB.addEntry(person3);
        personDB.addEntry(person4);

        // Creating the paid for list for creating an evenly split ticket
        ArrayList<Person> paidFor = new ArrayList<>();
        paidFor.add(person1);
        paidFor.add(person2);
        paidFor.add(person3);
        paidFor.add(person4);

        // Creating the ticketdatabase under test
        // (for testing set the private constructor for TicketDatabase to public)
        TicketDatabase ticketDBUnderTest = new TicketDatabase(personDB);

        ticketDBUnderTest.newEvenlySplitTicket("restaurant",10, person1, paidFor);
        Map<Person, Double> testResult = new HashMap<>();
        for (Person person : personDB.getEntries()) {
            testResult.put(person, person.getBalance());
        }
        Map<Person, Double> expectedResult = new HashMap<>();
        expectedResult.put(person1, 7.5);
        expectedResult.put(person2, -2.5);
        expectedResult.put(person3, -2.5);
        expectedResult.put(person4, -2.5);
        Assert.assertEquals("Testing newEvenlySplitTicket()", testResult, expectedResult);
    }
}
