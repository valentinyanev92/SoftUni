package _08_StreamsFilesAndDirectories_Exercises;

import java.io.*;

public class MergeTwoFiles {

    public static void main(String[] args) {

        String path1 = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2 = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merges.txt";

        try (BufferedReader br1 = new BufferedReader(new FileReader(path1));
        BufferedReader br2 = new BufferedReader(new FileReader(path2));
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(outputPath))) {

            while (br1.ready()) {
                String line = br1.readLine();
                bw1.write(line);
                bw1.newLine();
            }

            while (br2.ready()) {
                String line = br2.readLine();
                bw1.write(line);
                bw1.newLine();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
