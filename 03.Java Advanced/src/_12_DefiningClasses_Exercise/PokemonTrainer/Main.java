package _12_DefiningClasses_Exercise.PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Tournament")) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(new Pokemon(pokemonName, element, health));
        }

        while (!(input = scanner.nextLine()).equals("End")) {
            String element = input;
            trainers.values().forEach(trainer -> trainer.processElement(element));
        }

        trainers.values()
                .stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(trainer -> System.out.printf("%s %d %d%n", trainer.getName(), trainer.getBadges(), trainer.getPokemonCount()));
    }
}
