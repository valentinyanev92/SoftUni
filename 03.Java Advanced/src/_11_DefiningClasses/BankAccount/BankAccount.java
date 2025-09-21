package DefiningClasses_Lab.BankAccount;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountNumber = 1;

    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccountNumber++;
        System.out.println("Account ID" + id + " created");
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Deposited %.0f to ID%d%n", amount ,id);
    }
    double getInterestRate(int years) {
        return interestRate * years * this.balance;
    }

}
