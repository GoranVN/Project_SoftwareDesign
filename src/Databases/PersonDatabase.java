package Databases;

import Person.Person;

import java.util.ArrayList;
import java.util.Map;

public class PersonDatabase extends AbstractDatabase{
    private final ArrayList<Person> PersonList;
    private static PersonDatabase firstInstance = null;
    private PersonDatabase() {
        this.PersonList = new ArrayList<>();
    }

    public static PersonDatabase getInstance() {
        if (firstInstance == null) {
            firstInstance = new PersonDatabase();
        }
        return firstInstance;
    }
    public void addEntry(Person p){
        this.PersonList.add(p);
    }
    public void deleteEntry(Person p){
        PersonList.remove(p);
    }
    public ArrayList<Person> getEntries(){
        return PersonList;
    }

    public void updateBalance(Map<Person,Double> balanceDifferncePerPerson) {
        for (Map.Entry<Person, Double> entry : balanceDifferncePerPerson.entrySet()) {
            Person person = entry.getKey();
            person.updateBalance(entry.getValue());
        }
    }
}
