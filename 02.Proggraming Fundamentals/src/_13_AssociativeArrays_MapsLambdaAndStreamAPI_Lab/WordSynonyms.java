package _13_AssociativeArrays_MapsLambdaAndStreamAPI_Lab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeats = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String , List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < repeats; i++) {
           String word = scanner.nextLine();
           String synonym = scanner.nextLine();

           words.putIfAbsent(word, new ArrayList<>());
           words.get(word).add(synonym);
        }

        for (Map.Entry<String , List<String>> entry : words.entrySet()){
            System.out.printf("%s -", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf(" %s", entry.getValue().get(i));
                if (i != entry.getValue().size()-1){
                    System.out.print(",");
                }
            }
            System.out.printf("%n");
        }
    }
}
