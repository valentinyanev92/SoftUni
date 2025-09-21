package _06_SetsAndMapsAdvanced_Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        while (true) {
            String[] input = scanner.nextLine().split("-");

            if (input[0].equals("search")){
                break;
            } else {
                phonebook.putIfAbsent(input[0], input[1]);
            }
        }

        while (true){
            String input = scanner.nextLine();
            if (input.equals("stop")){
                break;
            }

            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
        }
    }
}
