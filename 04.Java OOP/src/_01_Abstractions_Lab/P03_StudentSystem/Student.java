package _01_Abstractions_Lab.P03_StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        if (grade >= 5) {
            return getName() + " is " + getAge() + " years old. Excellent student.";
        } else if (grade >= 3.50) {
            return getName() + " is " + getAge() + " years old. Average student.";
        } else {
            return getName() + " is " + getAge() + " years old. Very nice person.";
        }
    }
}
