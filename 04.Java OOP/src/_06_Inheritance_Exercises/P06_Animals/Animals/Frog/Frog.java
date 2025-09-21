package _06_Inheritance_Exercises.P06_Animals.Animals.Frog;

import _06_Inheritance_Exercises.P06_Animals.Animals.Animal;

public class Frog extends Animal {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String  produceSound() {
       return "Ribbit";
    }
}
