package _12_ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Student{
        String name;
        int ID;
        int age;

        Student(String name, int ID, int age){
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        String printStudent(){
            return String.format("%s with ID: %d is %d years old.",name ,ID, age);
        }

        int getAge(){
            return this.age;
        }

        static void sortByAge(List<Student> studentsList) {
            Collections.sort(studentsList, (Student a1, Student a2) -> Integer.compare(a1.getAge(), a2.getAge()));
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();
        while (!input.equals("End")){
            String[] inputArr = input.split(" ");
            Student student = new Student(inputArr[0], Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]));
            studentList.add(student);
            input = scanner.nextLine();
        }

        Student.sortByAge(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).printStudent());
        }
    }
}
