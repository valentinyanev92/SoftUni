package _08_StreamsFilesAndDirectories_Exercises;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {

        String input = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String output = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";
        String text = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        BufferedReader br2 = new BufferedReader(new FileReader(text));) {

            while (br.ready()) {
                String line = br.readLine();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    wordCount.put(word, 0);

                }
            }

            while (br2.ready()) {
                String line = br2.readLine();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                bw.write(entry.getKey() + " - " + entry.getValue());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
        }

    }
}
