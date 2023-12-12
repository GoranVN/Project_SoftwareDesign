import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import Person.*;
import Tickets.*;
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

    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private PersonDatabase personDB;
    private TicketDatabase ticketDBUnderTest;
    public TicketDatabase_ITest()
    {

    }

    @Before
    public void initialize()
    {
        // Create objects for persons
        person1 = new Person("Piet", 0);
        person2 = new Person("Jan", 0);
        person3 = new Person("Gert", 0);
        person4 = new Person("Bert", 0);

        // Creating the PersonDatabase, clearing it and adding the created persons to it
        personDB = PersonDatabase.getInstance();
        personDB.deleteAll();
        personDB.addEntry(person1);
        personDB.addEntry(person2);
        personDB.addEntry(person3);
        personDB.addEntry(person4);

        // Creating the ticketdatabase under test and clearing it
        ticketDBUnderTest = TicketDatabase.getInstance(personDB);
        ticketDBUnderTest.deleteAll();
    }

    @Test
    public void newNotEvenlySplitTicket()
    {
        // Creating the price per person for creating a not evenly split ticket
        Map<Person, Double> pricePerPerson = new HashMap<Person, Double>();
        pricePerPerson.put(person1, 2.0);
        pricePerPerson.put(person2, 1.5);
        pricePerPerson.put(person3, 1.5);
        pricePerPerson.put(person4, 3.0);

        // Adding a new not evenly split ticket for the test
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
        // Creating the paid for list for creating an evenly split ticket
        ArrayList<Person> paidFor = new ArrayList<Person>();
        paidFor.add(person1);
        paidFor.add(person2);
        paidFor.add(person3);
        paidFor.add(person4);

        // Adding a new evenly split ticket for the test
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

    @Test
    public void removeTicket()
    {
        // Creating the paid for list for creating an evenly split ticket
        ArrayList<Person> paidFor = new ArrayList<Person>();
        paidFor.add(person1);
        paidFor.add(person2);
        paidFor.add(person3);
        paidFor.add(person4);

        // Adding a new evenly split ticket for the test
        ticketDBUnderTest.newEvenlySplitTicket("restaurant",10, person1, paidFor);

        // Getting the last ticket (the ticket we are going to remove)
        Ticket ticketToRemove = ticketDBUnderTest.getEntries().get(0);
        ticketDBUnderTest.removeTicket(ticketToRemove);
        Map<Person, Double> testResult = new HashMap<>();
        for (Person person : personDB.getEntries()) {
            testResult.put(person, person.getBalance());
        }
        Map<Person, Double> expectedResult = new HashMap<>();
        expectedResult.put(person1, 0.0);
        expectedResult.put(person2, 0.0);
        expectedResult.put(person3, 0.0);
        expectedResult.put(person4, 0.0);
        Assert.assertEquals("Testing removeTicket()", testResult, expectedResult);
    }
}
