package _07_Methods_Lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        printingTriangle(number);
    }

    public static void printingTriangle(int n){
        for (int i = 1; i <= n; i++) {
            printingTriangleRow(i);
            System.out.println();
        }

        for (int s = n-1; s>0;s--){
            printingTriangleRow(s);
            System.out.println();
        }
    }

     public static void printingTriangleRow(int n){
        for (int i = 1; i <= n; i++){
            System.out.print(i+" ");
        }
    }
}
