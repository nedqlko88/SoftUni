import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (!checkLenght(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!checkConsists(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!checkDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (checkLenght(password) && checkConsists(password) && checkDigits(password)) {
            System.out.println("Password is valid");
        }


    }

    private static boolean checkDigits(String password) {
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                count++;
            }
        }
        if (count < 2) {
            return false;
        }
        return true;
    }

    private static boolean checkConsists(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLenght(String password) {
        if (password.length() < 6 || password.length() > 10) {
            return false;
        }
        return true;
    }
}
