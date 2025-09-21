package _15_TextProcessing_Lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWord = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < banWord.length; i++) {
            int banLength = banWord[i].length();
            String banned = "";
            for (int j = 0; j < banLength; j++) {
                banned += "*";
            }
            text = text.replaceAll(banWord[i], banned);
        }

        System.out.println(text);
    }
}
