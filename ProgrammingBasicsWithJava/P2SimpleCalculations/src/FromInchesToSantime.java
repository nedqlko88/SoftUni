import java.util.Scanner;

public class FromInchesToSantime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inches = Double.parseDouble(scanner.nextLine());
        double santimetres = inches * 2.54;
        System.out.println(santimetres);
    }
}
