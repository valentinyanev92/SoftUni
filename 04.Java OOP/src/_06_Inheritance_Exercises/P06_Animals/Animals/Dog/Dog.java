package _06_Inheritance_Exercises.P06_Animals.Animals.Dog;

import _06_Inheritance_Exercises.P06_Animals.Animals.Animal;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return "Woof!";
    }
}
