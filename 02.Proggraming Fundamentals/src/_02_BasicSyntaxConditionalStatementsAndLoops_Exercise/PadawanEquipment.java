package _02_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budged = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = Double.parseDouble(scanner.nextLine());
        double ropePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int lightSaberQuantity = (int) Math.ceil(studentsCount + studentsCount * 0.1);
        int beltQuantity = studentsCount - (studentsCount / 6);

        double total = lightSaberPrice * lightSaberQuantity + ropePrice * studentsCount + beltPrice * beltQuantity;

        if (budged>=total){
            System.out.printf("The money is enough - it would cost %.2flv.",total);
        }else {
            double missingMoney = total - budged;
            System.out.printf("George Lucas will need %.2flv more.", missingMoney);
        }
    }
}
