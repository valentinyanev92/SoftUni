package _03_Encapsulation_Lab.P03_ValidationData;

import _03_Encapsulation_Lab.P02_SalaryIncrease.Salary;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Salary salary;

    public Person(String firstName, String lastName, int age, double salary) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name must be at least 3 symbols");
        } else {
            this.firstName = firstName;
        }

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name must be at least 3 symbols");
        } else {
            this.lastName = lastName;

        }

        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        } else {
            this.age = age;
        }

        if (salary <= 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        } else {
            this.salary = new Salary(salary);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name must be at least 3 symbols");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name must be at least 3 symbols");
        } else {
            this.lastName = lastName;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        } else {
            this.age = age;
        }
    }

    public double getSalary() {
        return salary.getSalary();
    }

    public void setSalary(double money) {
        if (money <= 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        } else {
            this.salary.setSalary(money);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva.", this.getFirstName(), this.getLastName(), this.getSalary());
    }

    public void increaseSalary(double bonus) {
        salary.increaseSalary(bonus);
    }
}
