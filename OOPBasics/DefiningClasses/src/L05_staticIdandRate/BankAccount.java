package L05_staticIdandRate;

public class BankAccount {

    private static final double INTEREST_RATE = 0.02;

    private static double rate = INTEREST_RATE;
    private static int countAccounts;

    private double balance;
    private int id;

    public BankAccount() {
        this.id = ++countAccounts;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}
