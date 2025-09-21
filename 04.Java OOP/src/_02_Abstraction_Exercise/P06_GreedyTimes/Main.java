
package _02_Abstraction_Exercise.P06_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long input = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        var stash = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            String inputString = "";

            if (name.length() == 3) {
                inputString = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                inputString = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                inputString = "Gold";
            }

            if (inputString.equals("")) {
                continue;
            } else if (input < stash.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (inputString) {
                case "Gem":
                    putGems(inputString, stash, count);
                    break;
                case "Cash":
                    putCash(inputString, stash, count);
                    break;
            }

            if (!stash.containsKey(inputString)) {
                stash.put((inputString), new LinkedHashMap<String, Long>());
            }

            if (!stash.get(inputString).containsKey(name)) {
                stash.get(inputString).put(name, 0L);
            }

            stash.get(inputString).put(name, stash.get(inputString).get(name) + count);
            if (inputString.equals("Gold")) {
                gold += count;
            } else if (inputString.equals("Gem")) {
                gems += count;
            } else if (inputString.equals("Cash")) {
                cash += count;
            }
        }

        printStash(stash);

    }

    private static void printStash(LinkedHashMap<String, LinkedHashMap<String, Long>> stash) {
        for (var x : stash.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static void putCash(String inputString, LinkedHashMap<String, LinkedHashMap<String, Long>> stash, long count) {
        if (!stash.containsKey(inputString)) {
            if (stash.containsKey("Gem")) {
                if (count > stash.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                }
            }
        } else if (stash.get(inputString).values().stream().mapToLong(e -> e).sum() + count > stash.get("Gem").values().stream().mapToLong(e -> e).sum()) {
        }
    }

    private static void putGems(String inputString, LinkedHashMap<String, LinkedHashMap<String, Long>> stash, long count) {
        if (!stash.containsKey(inputString)) {
            if (stash.containsKey("Gold")) {
                if (count > stash.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                }
            }
        } else if (stash.get(inputString).values().stream().mapToLong(e -> e).sum() + count > stash.get("Gold").values().stream().mapToLong(e -> e).sum()) {
        }
    }
}