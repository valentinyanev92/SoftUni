package _10_FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));

        String command;
        while (!(command = scanner.nextLine()).equals("Party!")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];
            String criteria = tokens[1];
            String value = tokens[2];

            Predicate<String> filter = getPredicate(criteria, value);

            if (action.equals("Remove")) {
                guests.removeIf(filter);
            } else if (action.equals("Double")) {
                List<String> toAdd = guests.stream().filter(filter).collect(Collectors.toList());
                guests.addAll(toAdd);
            }
        }

        Collections.sort(guests);
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String criteria, String value) {
        switch (criteria) {
            case "StartsWith":
                return name -> name.startsWith(value);
            case "EndsWith":
                return name -> name.endsWith(value);
            case "Length":
                return name -> name.length() == Integer.parseInt(value);
            default:
                throw new IllegalArgumentException("Invalid criteria: " + criteria);
        }
    }
}
