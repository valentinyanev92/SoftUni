package FinalExam_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> destinations = new ArrayList<>();

        Pattern pattern = Pattern.compile("(=|\\/)([A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            destinations.add(matcher.group(2));  // Добавяме валидната дестинация
        }

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinations));
        int travelPoints = destinations.stream().mapToInt(String::length).sum();
        System.out.println("Travel Points: " + travelPoints);
    }
}
