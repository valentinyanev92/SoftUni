package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Map<String, String > registeredUsers = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            switch (input[0]){
                case "register":
                    if (registeredUsers.containsKey(input[1])){
                        System.out.printf("ERROR: already registered with plate number %s%n", registeredUsers.get(input[1]));
                    }else {
                        registeredUsers.put(input[1], input[2]);
                        System.out.printf("%s registered %s successfully%n", input[1], input[2]);
                    }
                    break;
                case "unregister":
                    if(registeredUsers.containsKey(input[1])){
                        registeredUsers.remove(input[1]);
                        System.out.printf("%s unregistered successfully%n", input[1]);
                    }else {
                        System.out.printf("ERROR: user %s not found%n", input[1]);
                    }
                    break;
            }
        }

        registeredUsers.forEach((user, plate) -> System.out.printf("%s => %s%n", user, plate));
    }
}
