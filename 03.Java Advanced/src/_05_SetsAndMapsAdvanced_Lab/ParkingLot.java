package _05_SetsAndMapsAdvanced_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> garage = new LinkedHashSet<String>();

        while (true) {
            String[] input = scanner.nextLine().split(", ");

            if (input[0].equals("END")) {
                break;
            }

            switch (input[0]) {
                case "IN": {
                        garage.add(input[1]);


                    break;
                }
                case "OUT": {
                    garage.remove(input[1]);
                    break;
                }
            }


        }

        if (!garage.isEmpty()) {
            garage.forEach(System.out::println);
        }else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
