package Person;

public class Person {
    private String name;
    private float balance;

    public Person(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }
    public void updateBalance(float balanceDifference) {
        this.balance += balanceDifference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
