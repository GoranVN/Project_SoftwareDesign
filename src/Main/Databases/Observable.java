package Databases;

import Person.Person;

import java.util.Map;

public interface Observable {
    public void notifyObservers(Map<Person,Double> balanceDifferencePerPerson);
}
