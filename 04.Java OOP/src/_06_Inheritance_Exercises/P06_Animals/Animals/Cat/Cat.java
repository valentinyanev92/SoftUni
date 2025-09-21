package _06_Inheritance_Exercises.P06_Animals.Animals.Cat;

import _06_Inheritance_Exercises.P06_Animals.Animals.Animal;

public class Cat extends Animal{

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
