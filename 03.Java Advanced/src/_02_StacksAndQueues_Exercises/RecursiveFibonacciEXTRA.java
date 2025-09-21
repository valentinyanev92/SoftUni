package _02_StacksAndQueues_Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonacciEXTRA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<Integer, Long> memo = new HashMap<>();

        System.out.println(getFibonacci(n, memo));
    }

    private static long getFibonacci(int n, HashMap<Integer, Long> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = getFibonacci(n - 1, memo) + getFibonacci(n - 2, memo);
        memo.put(n, result);

        return result;
    }
}
