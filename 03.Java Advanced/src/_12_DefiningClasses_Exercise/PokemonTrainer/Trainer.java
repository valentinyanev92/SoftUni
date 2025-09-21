package _12_DefiningClasses_Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public int getPokemonCount() {
        return pokemons.size();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void processElement(String element) {
        boolean hasElement = pokemons.stream().anyMatch(p -> p.getElement().equals(element));
        if (hasElement) {
            badges++;
        } else {
            pokemons.forEach(p -> p.reduceHealth(10));
            pokemons.removeIf(p -> !p.isAlive());
        }
    }
}
