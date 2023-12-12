import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import Person.Person;
import Tickets.Decorators.EvenlySplitDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Run with PowerMock, an extended version of Mockito
@RunWith(PowerMockRunner.class)
// Prepare class EvenlySplitDecorator for testing by injecting mocks
@PrepareForTest(EvenlySplitDecorator.class)

public class EvenlySplitDecorator_UTest
{
    public EvenlySplitDecorator_UTest()
    {

    }

    @Before
    public void initialize()
    {

    }

    @Test
    public void getBalanceDifference()
    {
        // Create mock objects for persons
        Person mock_person1 = Mockito.mock(Person.class);
        Person mock_person2 = Mockito.mock(Person.class);
        Person mock_person3 = Mockito.mock(Person.class);
        Person mock_person4 = Mockito.mock(Person.class);

        // Creating an array of person that were paid for
        ArrayList<Person> paidFor = new ArrayList<>();
        paidFor.add(mock_person1);
        paidFor.add(mock_person2);
        paidFor.add(mock_person3);
        paidFor.add(mock_person4);


        EvenlySplitDecorator evenlySplitDecoratorUnderTest = new EvenlySplitDecorator(mock_person1, 10, paidFor);
        Map<Person, Double> testResult = evenlySplitDecoratorUnderTest.getBalanceDifference();
        Map<Person, Double> expectedResult = new HashMap<>();
        expectedResult.put(mock_person1, 7.5);
        expectedResult.put(mock_person2, -2.5);
        expectedResult.put(mock_person3, -2.5);
        expectedResult.put(mock_person4, -2.5);
        Assert.assertEquals("Testing getBalanceDifference()", testResult, expectedResult);
    }
}
