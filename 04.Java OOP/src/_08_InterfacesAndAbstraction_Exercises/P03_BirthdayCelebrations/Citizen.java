package _08_InterfacesAndAbstraction_Exercises.P03_BirthdayCelebrations;

import _08_InterfacesAndAbstraction_Exercises.P03_BirthdayCelebrations.Impl.Birthable;
import _08_InterfacesAndAbstraction_Exercises.P03_BirthdayCelebrations.Impl.Identifiable;

public class Citizen implements Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }


    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
