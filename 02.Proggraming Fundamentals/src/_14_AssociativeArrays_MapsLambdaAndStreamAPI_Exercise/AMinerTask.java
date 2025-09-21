package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> resources = new LinkedHashMap<>();
        while (true){
            String resource = scanner.nextLine();
            if (resource.equals("stop")){
                break;
            }
            Long quantity = Long.parseLong(scanner.nextLine());

            resources.merge(resource, quantity, Long::sum);
        }

        resources.entrySet().forEach(s -> {
            System.out.println(s.getKey() + " -> "+s.getValue());
        });
    }
}
