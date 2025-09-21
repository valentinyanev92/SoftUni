package DefiningClasses_Lab.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_BankAccount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BankAccount> bankAccounts = new ArrayList<>();
        while (true) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input[0].equals("End")) {
                break;
            }

            switch (input[0]) {
                case "Create" -> {
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.add(bankAccount);
                }
                case "Deposit" -> {
                    int id = Integer.parseInt(input[1]);
                    double amount = Double.parseDouble(input[2]);
                    if (id > 0 && id <= bankAccounts.size()) {
                        BankAccount account = bankAccounts.get(id - 1);
                        account.deposit(amount);
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                case "SetInterest" -> {
                    double interest = Double.parseDouble(input[1]);
                    BankAccount.setInterestRate(interest);
                }
                case "GetInterest" -> {
                    int id = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);
                    if (id > 0 && id <= bankAccounts.size()) {
                        BankAccount account = bankAccounts.get(id - 1);
                        System.out.printf("%.2f%n",account.getInterestRate(years));
                    }else {
                        System.out.println("Account does not exist");

                    }
                }
            }
        }

    }
}
