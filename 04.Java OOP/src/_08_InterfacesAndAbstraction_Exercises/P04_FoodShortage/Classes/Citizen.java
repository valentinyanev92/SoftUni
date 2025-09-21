package _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage.Classes;

import _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage.Interface.Identifiable;
import _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage.Interface.Buyer;
import _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage.Interface.Person;

public class Citizen implements Person, Identifiable, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void buyFood() {
        food += 10;
    }
}
