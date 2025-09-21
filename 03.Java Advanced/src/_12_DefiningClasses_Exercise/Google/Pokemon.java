package _12_DefiningClasses_Exercise.Google;

public class Pokemon {
    String name, type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " " + type;
    }
}

