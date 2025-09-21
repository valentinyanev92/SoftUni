package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class Pokemon_Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());

        int originalN = N;
        int pokeCount = 0;

        while (N >= M) {
            N -= M;
            pokeCount++;

            if (N == originalN / 2 && Y != 0) {
                if (N % Y == 0) {
                    N /= Y;
                }
            }
        }

        System.out.println(N);
        System.out.println(pokeCount);
    }
}
