package _07_StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyBytes {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\input.txt";
        String outputPath = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\03.CopyBytesOutput.txt";

        try (FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath)){

            int oneByte = inputStream.read();

            while (oneByte != -1) {

                if (oneByte == '\n' || oneByte == ' ') {
                    outputStream.write(oneByte);
                }else {
                    outputStream.write(Integer.toString(oneByte).getBytes());
                }

                oneByte = inputStream.read();
            }


        } catch (Exception e) {
            System.out.println("File not found");
        } finally {
            System.out.println("File copied");
        }
    }
}
