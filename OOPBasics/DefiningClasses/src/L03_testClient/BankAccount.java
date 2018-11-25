package L03_testClient;

public class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void makeWithdraw(double balance) {
        if (this.balance < balance) {
            System.out.println("Insufficient balance");
        } else {
        this.balance -= balance;
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}
