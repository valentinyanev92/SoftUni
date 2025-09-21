package FinalExam_Official;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("[@#]+[a-z]{3,}[@#]+[^a-zA-Z0-9]*\\/+\\d+\\/+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String current = matcher.group();

            Pattern patternColor = Pattern.compile("(?<=[@#])[a-z]{3,}(?=[@#]+)");
            Matcher matcherColor =  patternColor.matcher(current);
            matcherColor.find();
            String color = matcherColor.group();

            Pattern patternCount = Pattern.compile("(?<=\\/+)\\d+(?=\\/+)");
            Matcher matcherCount = patternCount.matcher(current);
            matcherCount.find();
            int count = Integer.parseInt(matcherCount.group());

            System.out.printf("You found %d %s eggs!%n", count, color);
        }
    }
}
