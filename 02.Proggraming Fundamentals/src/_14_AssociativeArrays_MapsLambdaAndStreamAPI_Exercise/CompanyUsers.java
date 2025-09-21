package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> employs = new LinkedHashMap<>();
        while (true) {
            String[] input = scanner.nextLine().split(" -> ");
            if (input[0].equals("End")) {
                break;
            }

            employs.putIfAbsent(input[0], new LinkedHashSet<>());
            employs.get(input[0]).add(input[1]);
        }

        employs.forEach((company, id) -> {
            System.out.printf("%s%n", company);
            id.forEach(worker -> System.out.printf("-- %s%n",worker));
        });

}
}
