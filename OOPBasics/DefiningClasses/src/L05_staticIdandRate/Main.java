package L05_staticIdandRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
            Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!"End".equals(line)) {
            String[] cmdArgs = line.split("\\s+");
            String cmd = cmdArgs[0];

            switch (cmd) {
                case "Create":
                    BankAccount newAccount = new BankAccount();
                    accounts.put(newAccount.getId() , newAccount);
                    System.out.printf("Account ID%d created%n", newAccount.getId());
                    break;
                case "Deposit":
                    int accNumber = Integer.parseInt(cmdArgs[1]);
                    double amount = Double.parseDouble(cmdArgs[2]);
                    execDeposit(accNumber, amount, accounts);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(cmdArgs[1]);
                    BankAccount.setInterest(interest);
                    break;
                case "GetInterest":
                    accNumber = Integer.parseInt(cmdArgs[1]);
                    int years = Integer.parseInt(cmdArgs[2]);
                    calculateInterest(accNumber, years, accounts);
                    break;
            }



            line = reader.readLine();
        }
    }

    private static  void calculateInterest(int accNumber, int years, Map<Integer,BankAccount> accounts) {
        if (!accounts.containsKey(accNumber)) {
            System.out.println("Account does not exist");
        } else {
            double interest = accounts.get(accNumber).getInterest(years);
            System.out.printf("%.2f%n", interest);
        }
    }

    private static void execDeposit(int accNumber, double amount, Map<Integer, BankAccount> accounts) {
        if (!accounts.containsKey(accNumber)) {
            System.out.println("Account does not exist");
        } else {
            accounts.get(accNumber).deposit(amount);
            System.out.printf("Deposited %.0f to ID%d%n", amount, accNumber);
        }
    }
}
