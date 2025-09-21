package FinalExam_Official;

import java.util.*;

public class Dictionary {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] firstLine = scanner.nextLine().split("\\| ");
        String[] test = scanner.nextLine().split("\\| ");
        String testing = scanner.nextLine();

        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        for (int i = 0; i < firstLine.length; i++) {
            String[] firstLineSplit = firstLine[i].split(":");
            dictionary.putIfAbsent(firstLineSplit[0], new ArrayList<>());

            String description = firstLineSplit[1];
            dictionary.get(firstLineSplit[0]).add(description);
        }

        switch (testing) {
            case "Test" -> {
                for (int i = 0; i < test.length; i++) {
                    String word = test[i].trim();
                    if (dictionary.containsKey(word)) {
                        System.out.println(word + ":");
                        dictionary.get(word).forEach(string -> {
                            string = string.trim();
                            System.out.printf(" -%s%n", string);
                        });
                    }
                }
            }
            case "Hand Over" -> {
                dictionary.forEach((key, value) -> {
                    System.out.printf("%s ", key);
                });
            }
        }
    }
}
