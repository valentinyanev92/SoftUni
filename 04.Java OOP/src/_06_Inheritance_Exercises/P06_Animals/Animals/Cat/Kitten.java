package _06_Inheritance_Exercises.P06_Animals.Animals.Cat;

public class Kitten extends Cat{

    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    public String produceSound() {
        return "Meow";
    }
}
