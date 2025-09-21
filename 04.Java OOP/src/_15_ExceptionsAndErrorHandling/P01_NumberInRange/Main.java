package _15_ExceptionsAndErrorHandling.P01_NumberInRange;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberRange = scanner.nextLine();
        System.out.println("Range: [" + numberRange.split(" ")[0] + "..." + numberRange.split(" ")[1] + "]");

        while (true){
            String input = scanner.nextLine();
            try{
                int number = Integer.parseInt(input);

                if(isValid(number, numberRange)){
                    System.out.println("Valid number: " + number);
                    break;
                }else {
                    throw new NumberFormatException();
                }
            }catch (Exception e){
                System.out.println("Invalid number: " + input);
            }


        }
    }

    private static boolean isValid(int number, String numberRange) {
        int begin = Integer.parseInt(numberRange.split(" ")[0]);
        int end = Integer.parseInt(numberRange.split(" ")[1]);

        if (number >= begin && number <= end){
            return true;
        }
        return false;
    }
}
