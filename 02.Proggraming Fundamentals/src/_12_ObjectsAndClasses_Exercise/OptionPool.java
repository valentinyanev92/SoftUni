package _12_ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionPool {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        int getAge(){
            return this.age;
        }

        String stringFormat(){
            return String.format("%s - %d",this.name, this.age);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int persons = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        String input;

        for (int i = 0; i < persons; i++) {
            input = scanner.nextLine();
            String[] inputArr = input.split(" ");

            Person person = new Person(inputArr[0], Integer.parseInt(inputArr[1]));
            personList.add(person);
        }

        for (int i = 0; i < personList.size(); i++) {
            if(personList.get(i).getAge() >= 30){
                System.out.println(personList.get(i).stringFormat());
            }
        }
    }
}
