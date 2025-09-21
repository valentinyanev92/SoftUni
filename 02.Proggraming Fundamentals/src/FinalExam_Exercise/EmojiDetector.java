package FinalExam_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String emoji = scanner.nextLine();

        long coolThreshold = FindCoolThreshold(emoji);
        int validEmojis = FindEmojis(emoji);

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(validEmojis + " emojis found in the text. The cool ones are:");
        printValidEmojis(emoji, coolThreshold);
    }

    public static Long FindCoolThreshold(String text) {

        String coolThresholdString = "";

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            coolThresholdString += matcher.group();
        }

        long coolThreshold = 1;
        for (int i = 0; i < coolThresholdString.length(); i++) {
            coolThreshold *= Long.parseLong(String.valueOf(coolThresholdString.charAt(i)));
        }

        return coolThreshold;
    }

    public static int FindEmojis(String text) {

        Pattern pattern = Pattern.compile("(::[A-Z][a-z]{2,}::)|(\\*\\*[A-Z][a-z]{2,}\\*\\*)");
        Matcher matcher = pattern.matcher(text);

        int validEmojis = 0;
        while (matcher.find()){
            validEmojis++;
        }

        return validEmojis;
    }

    public static void printValidEmojis(String text, long coolThreshold){
        Pattern pattern = Pattern.compile("(::[A-Z][a-z]{2,}::)|(\\*\\*[A-Z][a-z]{2,}\\*\\*)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){

            String find = matcher.group().substring(2, matcher.group().length() - 2);
            String findUntrimmed = matcher.group();

            long currentThreshold = 0;
            for (int i = 0; i < find.length(); i++) {
                 currentThreshold += find.charAt(i);
            }

            if (currentThreshold > coolThreshold){
                System.out.println(findUntrimmed);
            }
        }
    }
}
