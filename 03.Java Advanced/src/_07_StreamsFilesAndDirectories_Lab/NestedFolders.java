package _07_StreamsFilesAndDirectories_Lab;

import java.io.File;

public class NestedFolders {

      public static void main(String[] args) {


        String path = "C:\\Users\\valen\\Desktop\\Udemy\\spring-boot-3-spring-6-hibernate-for-beginners-main\\05-spring-boot-rest-security\\Java Advanced\\src\\StreamsFilesAndDirectories_Lab\\Resources\\Files-and-Streams";

        File file = new File(path);

        int directories = 1;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                System.out.println(f.getName());
                directories++;

                File file1 = new File(path + "\\" + f.getName());
                for (File f1 : file1.listFiles()) {
                    if (f1.isDirectory()) {
                        System.out.println(f1.getName());
                        directories++;

                        File file2 = new File(path + "\\" + f.getName() + "\\" + f1.getName());
                        for (File f2 : file2.listFiles()) {
                            if (f2.isDirectory()) {
                                System.out.println(f2.getName());
                                directories++;

                                File file3 = new File(path + "\\" + f.getName() + "\\" + f1.getName() + "\\" + f2.getName());
                                for (File f3 : file3.listFiles()) {
                                    if (f3.isDirectory()) {
                                        System.out.println(f3.getName());
                                        directories++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(directories + " folders");
    }
}
