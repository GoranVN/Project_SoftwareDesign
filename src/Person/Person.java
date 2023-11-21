package Person;

public class Person {
    private String name;
    private int balance;

    public Person(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    public void updateBalance(int balanceDifference) {
        this.balance += balanceDifference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
