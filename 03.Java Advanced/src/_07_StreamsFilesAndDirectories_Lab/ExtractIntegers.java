package _07_StreamsFilesAndDirectories_Lab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\input.txt";
        String outputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\04.ExtractIntegersOutput.txt";

        try {
            Scanner scanner = new Scanner(new File(inputPath));
            OutputStream outputStream = new FileOutputStream(outputPath);


            while (scanner.hasNextLine()) {

                if (scanner.hasNextInt()) {
                    String number = String.valueOf(scanner.nextInt());
                    System.out.println(number);
                    outputStream.write(number.getBytes());
                    outputStream.write("\n".getBytes());
                }
                scanner.next();
            }

        } catch (Exception e ){
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Finally");
        }
    }
}
