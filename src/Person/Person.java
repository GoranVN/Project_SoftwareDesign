package Person;

public class Person {
    private String name;
    private double balance;

    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public void updateBalance(double balanceDifference) {
        this.balance += balanceDifference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "(Name: " + name + ", Balance: " + balance + ")";
    }
}
