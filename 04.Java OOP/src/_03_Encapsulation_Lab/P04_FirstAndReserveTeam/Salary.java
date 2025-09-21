package _03_Encapsulation_Lab.P04_FirstAndReserveTeam;

public class Salary {
    private double salary;

    public Salary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double newSalary = this.getSalary() + this.getSalary()*bonus/100;
        this.setSalary(newSalary);
    }
}
