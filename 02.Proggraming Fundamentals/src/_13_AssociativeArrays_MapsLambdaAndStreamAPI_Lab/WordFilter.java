package _13_AssociativeArrays_MapsLambdaAndStreamAPI_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String[] input = scanner.nextLine().split("\\s+");

//        List<String> words = new ArrayList<>();
//        for (int i = 0; i < input.length; i++) {
//            if (input[i].length() %2 ==0){
//                words.add(input[i]);
//            }
//        }
//
//        for (int i = 0; i < words.size(); i++) {
//            System.out.println(words.get(i));
//        }

        String[] words = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                        .filter(word -> word.length() % 2 == 0)
                .toArray(String[]::new);

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}
