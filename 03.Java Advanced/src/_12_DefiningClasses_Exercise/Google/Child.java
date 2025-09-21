package _12_DefiningClasses_Exercise.Google;

public class Child {
    String name, birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + " " + birthday;
    }
}
