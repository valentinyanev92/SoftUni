package _08_StreamsFilesAndDirectories_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class LineNumber {

    public static void main(String[] args) {

        String input = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String output = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             PrintWriter pw = new PrintWriter(new FileWriter(output))) {

            int lines = 1;

            while (br.ready()) {
                String line = br.readLine();
                String modifiedLine = lines + ". " + line;
                lines++;
                pw.println(modifiedLine);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Output file written to: " + output);
        }
    }
}
