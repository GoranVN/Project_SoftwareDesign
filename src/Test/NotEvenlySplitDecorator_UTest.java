import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import Tickets.Decorators.*;
import Person.Person;

import java.util.HashMap;
import java.util.Map;

// Run with PowerMock, an extended version of Mockito
@RunWith(PowerMockRunner.class)
// Prepare class NotEvenlySplitDecorator for testing by injecting mocks
@PrepareForTest(NotEvenlySplitDecorator.class)

public class NotEvenlySplitDecorator_UTest
{
    public NotEvenlySplitDecorator_UTest()
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

        // Creating the price per person
        Map<Person, Double> pricePerPerson = new HashMap<Person, Double>();
        pricePerPerson.put(mock_person1, 2.0);
        pricePerPerson.put(mock_person2, 1.5);
        pricePerPerson.put(mock_person3, 1.5);
        pricePerPerson.put(mock_person4, 3.0);


        NotEvenlySplitDecorator notEvenlySplitDecoratorUnderTest = new NotEvenlySplitDecorator(mock_person1, pricePerPerson);
        Map<Person, Double> testResult = notEvenlySplitDecoratorUnderTest.getBalanceDifference();
        Map<Person, Double> expectedResult = new HashMap<>();
        expectedResult.put(mock_person1, 6.0);
        expectedResult.put(mock_person2, -1.5);
        expectedResult.put(mock_person3, -1.5);
        expectedResult.put(mock_person4, -3.0);
        Assert.assertEquals("Testing getBalanceDifference()", testResult, expectedResult);
    }
}
