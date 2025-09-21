package _08_StreamsFilesAndDirectories_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

    public static void main(String[] args) {

        String path = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while (br.ready()) {
                String line = br.readLine();

                long sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                System.out.println(sum);
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
