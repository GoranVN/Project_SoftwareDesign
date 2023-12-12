package Databases;

import Person.Person;

import java.util.ArrayList;
import java.util.Map;

public class PersonDatabase extends AbstractDatabase implements Observer{
    private final ArrayList<Person> personList;
    private static PersonDatabase firstInstance = null;
    private PersonDatabase() {
        this.personList = new ArrayList<>();
    }

    public static PersonDatabase getInstance() {
        if (firstInstance == null) {
            firstInstance = new PersonDatabase();
        }
        return firstInstance;
    }
    public void addEntry(Person p){
        this.personList.add(p);
    }
    public void deleteEntry(Person p){
        personList.remove(p);
    }

    public void deleteAll() {
        personList.clear();
    }
    public ArrayList<Person> getEntries(){
        return personList;
    }

    public void updateBalance(Map<Person,Double> balanceDifferencePerPerson) {
        for (Map.Entry<Person, Double> entry : balanceDifferencePerPerson.entrySet()) {
            Person person = entry.getKey();
            person.updateBalance(entry.getValue());
        }
    }
}
