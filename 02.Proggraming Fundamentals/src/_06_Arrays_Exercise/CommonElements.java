package _06_Arrays_Exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String[] firstArray = first.split(" ");
        String[] secondArray = second.split(" ");
        for (int n = 0; n< secondArray.length; n++){
            for (int i=0; i< firstArray.length;i++){
                if (secondArray[n].equals(firstArray[i])){
                    System.out.print(firstArray[i]+" ");
                }
            }
        }
    }
}
