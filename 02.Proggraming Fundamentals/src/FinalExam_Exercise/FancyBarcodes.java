package FinalExam_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int barcodes = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");


        for (int i = 0; i < barcodes; i++) {

            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            boolean matchFound = matcher.find();

            if (matchFound) {
                String group = getDigits(barcode);
                if (group.isEmpty()){
                    group = "00";
                }
                System.out.println("Product group: " + group);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }

    public static String getDigits(String barcode) {

        String group = "";
        for (int i = 0; i < barcode.length(); i++) {

            try {
                int current = Integer.parseInt(String.valueOf(barcode.charAt(i)));
                group += current;
            } catch (RuntimeException e) {
            }
        }

        return group;
    }
}
