package _07_StreamsFilesAndDirectories_Lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteEveryThirdLine {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\input.txt";
        String outputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\05.WriteEveryThirdLineOutput.txt";

        try {

            BufferedReader in = new BufferedReader(new FileReader(inputPath));
            BufferedWriter out = new BufferedWriter(new FileWriter(outputPath));

            int lineNumber = 0;
            while (in.ready()) {
                lineNumber++;
                String line = in.readLine();

                if (lineNumber%3==0){
                    out.write(line+"\n");
                    out.flush();
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Output path: " + outputPath);
        }

    }
}
