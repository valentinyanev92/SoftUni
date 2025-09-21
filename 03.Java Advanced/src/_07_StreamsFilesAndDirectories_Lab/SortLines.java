package _07_StreamsFilesAndDirectories_Lab;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\input.txt";
        String outputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\06.SortLinesOutput.txt";

        try {

            List<String> lines = Files.readAllLines(Paths.get(inputPath));
            Collections.sort(lines);
            Files.write(Paths.get(outputPath), lines);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("End of file");
        }

    }
}
