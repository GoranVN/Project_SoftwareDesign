package Databases;

import Person.Person;

import java.util.Map;

public interface Observer {
    public void updateBalance(Map<Person,Double> balanceDifferencePerPerson);
}
