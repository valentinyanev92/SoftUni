package _07_Methods_Lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        if (type.equals("int")) {
            int f = Integer.parseInt(scanner.nextLine());
            int s = Integer.parseInt(scanner.nextLine());

            int result = getMax(f, s);
            System.out.println(result);

        } else if (type.equals("char")) {
            String fr = scanner.nextLine();
            String se = scanner.nextLine();
            char f = fr.charAt(0);
            char s = se.charAt(0);

            char result = getMax(f, s);
            System.out.println(result);

        } else if (type.equals("string")) {
            String f = scanner.nextLine();
            String s = scanner.nextLine();

            String result = getMax(f, s);
            System.out.println(result);
        }


    }

    private static String getMax(String f, String s) {
        if (f.compareTo(s)>=0){
            return f;
        }else {
            return s;
        }
    }

    private static int getMax(int f, int s){
        if(f>s){
            return f;
        }else {
            return s;
        }
    }

    private static char getMax(char f, char s){
        if (f>s){
            return f;
        }else {
            return s;
        }
    }
}
