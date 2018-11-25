import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double inputAge = Double.parseDouble(scanner.nextLine());
        String inputGender = scanner.nextLine();
        if (inputGender.equalsIgnoreCase("m")) {
            if (inputAge >= 16) {
                System.out.println("Mr.");
            }   else {
                System.out.println("Master");
            }

        }
        if (inputGender.equalsIgnoreCase("f")) {
            if (inputAge >= 16) {
                System.out.println("Ms.");
            } else {
                System.out.println("Miss");
            }
        }
    }
}
