package Databases;

import Person.Person;

import java.util.ArrayList;

public class PersonDatabase extends AbstractDatabase{
    private final ArrayList<Person> PersonList;
    public PersonDatabase() {
        this.PersonList = new ArrayList<>();
    }

    public void addEntry(Person p){
        this.PersonList.add(p);
    }

    public Person getEntry(Person p){
        return
    }
}
