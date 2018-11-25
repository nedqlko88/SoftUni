package L03_testClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        HashMap<Integer,BankAccount> accounts = new HashMap<>();

        while (!"End".equals(command)) {
            String[] cmdArgs = command.split("\\s+");
            String cmd = cmdArgs[0];
            int accNumber = Integer.parseInt(cmdArgs[1]);

            switch (cmd) {
                case "Create":
                    execCreate(accNumber, accounts);
                    break;
                case "Deposit":
                    double amountForDeposit = Double.parseDouble(cmdArgs[2]);
                    execDeposit(accNumber, amountForDeposit, accounts);
                    break;
                case "Withdraw":
                    double amountForWithdraw = Double.parseDouble(cmdArgs[2]);
                    execWithdraw(accNumber,amountForWithdraw,accounts);
                    break;
                case "Print":
                    execPrint(accNumber, accounts);
                    break;
            }

            command = reader.readLine();
        }
    }

    private static void execPrint(int accNumber, HashMap<Integer, BankAccount> accounts) {
        if (!accounts.containsKey(accNumber)) {
            System.out.println("Account does not exist");
        } else {
            System.out.println(accounts.get(accNumber));
        }
    }

    private static void execWithdraw(int accNumber, double amountForWithdraw, HashMap<Integer, BankAccount> accounts) {
        if (!accounts.containsKey(accNumber)) {
            System.out.println("Account does not exist");
        } else {
            accounts.get(accNumber).makeWithdraw(amountForWithdraw);
        }
    }

    private static void execDeposit(int accNumber, double amount, HashMap<Integer, BankAccount> accounts) {
        if (!accounts.containsKey(accNumber)) {
            System.out.println("Account does not exist");
        } else {
            accounts.get(accNumber).addBalance(amount);
        }
    }

    private static void execCreate(int accNumber, HashMap<Integer, BankAccount> accounts) {
        if (accounts.containsKey(accNumber)) {
            System.out.println("Account already exists");
        } else {
            BankAccount newAccount = new BankAccount(accNumber);
            accounts.put(accNumber, newAccount);
        }
    }


}
