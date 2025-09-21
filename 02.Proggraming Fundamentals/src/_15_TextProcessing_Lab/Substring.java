package _15_TextProcessing_Lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filter = scanner.nextLine();
        String input = scanner.nextLine();

        String filtered = "";
        for (int i = 0; i < input.length(); i++) {
            boolean isExist = false;
            for (int j = 0; j < filter.length(); j++) {
                if (input.charAt(i) == filter.charAt(j)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist){
                filtered += input.charAt(i);
            }
        }

        System.out.printf("%s",filtered);

    }
}

