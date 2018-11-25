import java.util.Scanner;

public class passwordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPass = scanner.nextLine();
        String thePass = "s3cr3t!P@ssw0rd";
        if (inputPass.equals(thePass)) {
            System.out.println("Welcome");
        }   else {
            System.out.println("Wrong password!");
        }
    }
}
