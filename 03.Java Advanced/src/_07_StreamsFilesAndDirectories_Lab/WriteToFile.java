package _07_StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {

    public static void main(String[] args) {

        String path = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\input.txt";
        String pathOutput = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\02.WriteToFileOutput.txt";
        try {
            FileInputStream fileInput = new FileInputStream(path);
            FileOutputStream fileOutput = new FileOutputStream(pathOutput);

            List<Character> punctuation = new ArrayList<Character>();
            punctuation.add('.');
            punctuation.add(',');
            punctuation.add('!');
            punctuation.add('?');

            int oneByte = fileInput.read();
            while (oneByte != -1) {

                if (!punctuation.contains((char) oneByte)) {
                    fileOutput.write(oneByte);
                }

                oneByte = fileInput.read();
            }
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("Files written");
        }
    }
}
