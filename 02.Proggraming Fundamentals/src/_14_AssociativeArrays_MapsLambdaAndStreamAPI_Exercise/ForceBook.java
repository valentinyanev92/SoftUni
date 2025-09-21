package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> forces = new HashMap<>();

        while (true) {
            String in = scanner.nextLine();
            if (in.contains("Lumpawaroo")) {
                break;
            }

            String[] input = in.split(" ");
            boolean add = false;
            boolean move = false;
            for (int i = 0; i < input.length; i++) {
                if (input[i].equals("|")) {
                    add = true;
                    break;
                }
                if (input[i].equals("->")) {
                    move = true;
                    break;
                }
            }

            if (add) {
                String[] inputSplit = in.split(" \\| ");
                String side = inputSplit[0];
                String name = inputSplit[1];

                forces.putIfAbsent(side, new LinkedHashSet<>());
                forces.get(side).add(name);
                add = false;
            }

            if (move) {
                String[] inputSplit = in.split(" -> ");
                String sideChange = inputSplit[1];
                String nameChange = inputSplit[0];
                String key = null;

                for (Map.Entry<String, Set<String>> entry : forces.entrySet()){
                    if(entry.getValue().contains(nameChange)){
                        key = entry.getKey();
                        entry.getValue().remove(nameChange);
                        break;
                    }
                }

                forces.putIfAbsent(sideChange, new LinkedHashSet<>());
                forces.get(sideChange).add(nameChange);

                System.out.printf("%s joins the %s side!%n", nameChange, sideChange);
                move = false;
            }
        }
        forces.forEach((side, user) -> {
            System.out.printf("Side: %s, Members: %d%n", side, user.size());
            forces.get(side).forEach(u -> System.out.printf("! %s%n", u));
        });
    }
}