package _12_DefiningClasses_Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(String companyName, String department, double salary) {
        this.company = new Company(companyName, department, salary);
    }

    public void setCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    public void addParent(String name, String birthday) {
        this.parents.add(new Parent(name, birthday));
    }

    public void addChild(String name, String birthday) {
        this.children.add(new Child(name, birthday));
    }

    public void addPokemon(String name, String type) {
        this.pokemons.add(new Pokemon(name, type));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n");

        sb.append("Company:\n");
        if (company != null) sb.append(company).append("\n");

        sb.append("Car:\n");
        if (car != null) sb.append(car).append("\n");

        sb.append("Pokemon:\n");
        for (Pokemon p : pokemons) sb.append(p).append("\n");

        sb.append("Parents:\n");
        for (Parent p : parents) sb.append(p).append("\n");

        sb.append("Children:\n");
        for (Child c : children) sb.append(c).append("\n");

        return sb.toString().trim();
    }
}
