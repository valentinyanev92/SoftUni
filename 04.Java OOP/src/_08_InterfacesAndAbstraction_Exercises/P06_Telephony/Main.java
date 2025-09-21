package _08_InterfacesAndAbstraction_Exercises.P06_Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneNumbers = Arrays.asList(scanner.nextLine().split(" "));
        List<String> websites = Arrays.asList(scanner.nextLine().split(" "));

        Smartphone smartphone = new Smartphone(phoneNumbers, websites);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}
