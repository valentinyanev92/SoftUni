package _12_ObjectsAndClasses_Exercise;

import java.util.Random;
import java.util.Scanner;

public class AdvertisimentMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rolls = Integer.parseInt(scanner.nextLine());

        String[] phases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] event = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();
        for (int i = 0; i <rolls; i++) {
            System.out.printf("%s %s %s - %s%n", phases[random.nextInt(phases.length)], event[random.nextInt(event.length)], authors[random.nextInt(authors.length)], cities[random.nextInt(cities.length)]);
        }
    }
}