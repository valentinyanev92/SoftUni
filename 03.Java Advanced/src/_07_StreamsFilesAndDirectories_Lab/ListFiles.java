package _07_StreamsFilesAndDirectories_Lab;

import java.io.File;

public class ListFiles {

    public static void main(String[] args) {

        String path = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\Files-and-Streams";

        File file = new File(path);

        for (File f : file.listFiles()) {
            if (f.isFile()) {
                System.out.println(f.getName() + ": [" + f.length() + "]");
            }
        }
    }
}
