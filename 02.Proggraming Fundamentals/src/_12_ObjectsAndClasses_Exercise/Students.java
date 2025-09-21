package _12_ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        String firstName;
        String lastName;
        double grade;

        public double getGrade() {
            return grade;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }


        static void sortByGrade(List<Student> studentsList) {
            Collections.sort(studentsList, (Student a1, Student a2) -> Double.compare(a2.getGrade(), a1.getGrade()));
        }



        String  formatString(){
            return String.format("%s %s: %.2f%n",firstName, lastName, grade);
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int count = Integer.parseInt(scanner.nextLine());
            String input;
            List<Student> studentsList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                input = scanner.nextLine();
                String[] inputArr = input.split(" ");
                Student student = new Student(inputArr[0], inputArr[1], Double.parseDouble(inputArr[2]));
                studentsList.add(student);
            }

            sortByGrade(studentsList);
            for (int i = 0; i < studentsList.size(); i++) {
                System.out.print(studentsList.get(i).formatString());
            }
        }
    }
}
