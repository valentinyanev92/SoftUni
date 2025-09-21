package _08_Methods_Exercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int vowels = getVowels(input);
        System.out.println(vowels);
    }

    private static int getVowels(String input) {
        int vowels = 0;
        for (int i = 0; i < input.length(); i++) {
            int charAt = (int) input.charAt(i);

            if (charAt == (int) 'a' || charAt == (int) 'e' || charAt == (int) 'u' || charAt == (int) 'i'
                    || charAt == (int) 'o' || charAt == (int) 'A' || charAt == (int) 'E' || charAt == (int) 'U'
                    || charAt == (int) 'I' || charAt == (int) 'O') {
                vowels++;
            }
        }
        return vowels;
    }
}
