package _05_Arrays_Lab;

import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String list = scanner.nextLine();
        String[] listString = list.split(" ");
        int[] array = new int[listString.length];
        int sum =0 ;
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(listString[i]);
        }
        for (int n = 0; n< array.length; n++){
            if (array[n]%2==0){
                sum += array[n];
            }
        }
        System.out.println(sum);
    }
}
