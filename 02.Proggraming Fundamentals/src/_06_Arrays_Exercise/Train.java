package _06_Arrays_Exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            count[i] = Integer.parseInt(scanner.nextLine());
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i]+" ");
            sum +=count[i];
            if (i== count.length-1){
                System.out.println();
            }

        }
        System.out.println(sum);
    }
}
