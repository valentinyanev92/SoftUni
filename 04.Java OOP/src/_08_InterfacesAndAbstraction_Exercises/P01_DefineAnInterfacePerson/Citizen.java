package _08_InterfacesAndAbstraction_Exercises.P01_DefineAnInterfacePerson;

public class Citizen implements Person {
    private String name;
    private int age;

    public Citizen(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
