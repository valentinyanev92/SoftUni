package _08_StreamsFilesAndDirectories_Exercises;

import java.io.*;

public class CountCharacterTypes {

    public static void main(String[] args) {

        String path = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path));
        PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {

            int vowelCount = 0;
            int other = 0;
            int punctuationCount = 0;


            while (br.ready()) {
                String line = br.readLine();

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if (Character.isWhitespace(c)) {
                        continue;
                    }

                    if (isVowel(c)) {
                        vowelCount++;
                    } else if (isPunctuation(c)) {
                        punctuationCount++;
                    } else {
                        other++;
                    }
                }
            }


            pw.println("Vowels: " + vowelCount);
            pw.println("Other symbols: " + other);
            pw.println("Punctuation: " + punctuationCount);


        } catch (IOException e) {
            System.out.println("File not found");
        }


    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static boolean isPunctuation(char ch) {
        return ch == '!' || ch == ',' || ch == '.' || ch == '?';
    }
}
