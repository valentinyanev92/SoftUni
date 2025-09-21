package _07_StreamsFilesAndDirectories_Lab;

import java.io.*;

public class ReadFile {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);

            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
