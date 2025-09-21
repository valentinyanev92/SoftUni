package _13_AssociativeArrays_MapsLambdaAndStreamAPI_Lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        HashMap<String, Integer> wordsCount = new LinkedHashMap<>();
        for (String s : input) {
            String word = s.toLowerCase(Locale.ROOT);
            wordsCount.putIfAbsent(word, 0);
            wordsCount.put(word, wordsCount.get(word) + 1);
        }

        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()){
            if (entry.getValue() % 2 == 1){
                oddWords.add(entry.getKey());
            }
        }

        for (int i = 0; i < oddWords.size(); i++) {
            System.out.printf("%s",oddWords.get(i));
            if (i != oddWords.size()-1){
                System.out.print(", ");
            }
        }
    }
}
