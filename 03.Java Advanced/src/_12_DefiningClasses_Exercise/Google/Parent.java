package _12_DefiningClasses_Exercise.Google;

public class Parent {
    String name, birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + " " + birthday;
    }
}
