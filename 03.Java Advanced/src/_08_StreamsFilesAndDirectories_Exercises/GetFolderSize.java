package _08_StreamsFilesAndDirectories_Exercises;

import java.io.File;

public class GetFolderSize {

    public static void main(String[] args) {

        String path = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        try {
            File file = new File(path);

            long size = file.length();
            System.out.println("Folder size: " + size);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
