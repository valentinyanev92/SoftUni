package _03_Encapsulation_Lab.P02_SalaryIncrease;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Salary salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = new Salary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary.getSalary();
    }

    public void setSalary(double money) {
        this.salary.setSalary(money);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva.", this.getFirstName(), this.getLastName(), this.getSalary());
    }

    public void increaseSalary(double bonus) {
        salary.increaseSalary(bonus);
    }
}
