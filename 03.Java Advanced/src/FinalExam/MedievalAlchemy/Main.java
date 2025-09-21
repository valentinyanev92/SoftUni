package FinalExam.MedievalAlchemy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Deque<Integer> substances = new ArrayDeque<>();
            Queue<Integer> crystals = new LinkedList<>();

            Map<String, Integer> potionEnergy = new HashMap<>();
            potionEnergy.put("Brew of Immortality", 110);
            potionEnergy.put("Essence of Resilience", 100);
            potionEnergy.put("Draught of Wisdom", 90);
            potionEnergy.put("Potion of Agility", 80);
            potionEnergy.put("Elixir of Strength", 70);


            List<String> craftedPotions = new ArrayList<>();
            Set<Integer> craftedLevels = new HashSet<>();

            String[] substancesArray = scanner.nextLine().split(", ");
            String[] crystalsArray = scanner.nextLine().split(", ");

            for (int i = 0; i < substancesArray.length; i++) {
                substances.push(Integer.parseInt(substancesArray[i]));
            }
            for (int i = 0; i < crystalsArray.length; i++) {
                crystals.add(Integer.parseInt(crystalsArray[i]));
            }

            while (!substances.isEmpty() && !crystals.isEmpty() && craftedPotions.size() < 5) {
                int substance = substances.pop();
                int crystal = crystals.poll();
                int totalEnergy = substance + crystal;

                if (potionEnergy.containsValue(totalEnergy) && !craftedLevels.contains(totalEnergy)) {
                    for (Map.Entry<String, Integer> entry : potionEnergy.entrySet()) {
                        if (entry.getValue() == totalEnergy) {
                            craftedPotions.add(entry.getKey());
                            craftedLevels.add(totalEnergy);
                            break;
                        }
                    }
                } else {
                    int bestFit = -1;
                    String bestPotion = "";
                    for (Map.Entry<String, Integer> entry : potionEnergy.entrySet()) {
                        if (entry.getValue() < totalEnergy && !craftedLevels.contains(entry.getValue()) && entry.getValue() > bestFit) {
                            bestFit = entry.getValue();
                            bestPotion = entry.getKey();
                        }
                    }

                    if (bestFit != -1) {
                        craftedPotions.add(bestPotion);
                        craftedLevels.add(bestFit);
                        int reducedCrystal = crystal - 20;
                        if (reducedCrystal > 0) crystals.add(reducedCrystal);
                    } else {
                        int reducedCrystal = crystal - 5;
                        if (reducedCrystal > 0) crystals.add(reducedCrystal);
                    }
                }
            }

            if (craftedPotions.size() == 5) {
                System.out.println("Success! The alchemist has forged all potions!");
            }else {
                System.out.println("The alchemist failed to complete his quest.");
            }

            if (!craftedPotions.isEmpty()) {
                System.out.print("Crafted potions: ");
                AtomicInteger size = new AtomicInteger(0);
                craftedPotions.forEach(s -> {
                    System.out.print(s);
                    size.getAndIncrement();
                    if (craftedPotions.size() != size.get()){
                        System.out.print(", ");
                    }
                });
                System.out.println();
            }

            if (!substances.isEmpty()) {
                System.out.print("Substances: ");
                AtomicInteger size = new AtomicInteger(0);
                substances.forEach(s -> {
                    System.out.print(s);
                    size.getAndIncrement();
                    if (substances.size() != size.get()){
                        System.out.print(", ");
                    }
                });
                System.out.println();
            }

            if (!crystals.isEmpty()) {
                System.out.print("Crystals: ");
                AtomicInteger size = new AtomicInteger(0);
                crystals.forEach(s -> {
                    System.out.print(s);
                    size.getAndIncrement();
                    if (crystals.size() != size.get()){
                        System.out.print(", ");
                    }
                });
                System.out.println();
            }
        }

}
