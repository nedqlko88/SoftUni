import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        Double quantity = Double.parseDouble(scanner.nextLine());
        if (city.equalsIgnoreCase("sofia")) {
            switch (product) {
                case "coffee":
                    System.out.println(0.5*quantity);
                    break;

                case "water":
                    System.out.println(0.8*quantity);
                    break;
                case "beer":
                    System.out.println(1.2*quantity);
                    break;
                case "sweets":
                    System.out.println(1.45*quantity);
                    break;
                case "peanuts":
                    System.out.println(1.60*quantity);
                    break;
                    default:
                        System.out.println("unknown");
                        break;
            }

        } else if (city.equalsIgnoreCase("plovdiv")) {
            switch (product) {
                case "coffee":
                    System.out.println(0.4*quantity);
                    break;

                case "water":
                    System.out.println(0.7*quantity);
                    break;
                case "beer":
                    System.out.println(1.15*quantity);
                    break;
                case "sweets":
                    System.out.println(1.30*quantity);
                    break;
                case "peanuts":
                    System.out.println(1.50*quantity);
                    break;
                default:
                    System.out.println("unknown");
                    break;
            }

        } else if (city.equalsIgnoreCase("varna")) {
            switch (product) {
                case "coffee":
                    System.out.println(0.45*quantity);
                    break;

                case "water":
                    System.out.println(0.7*quantity);
                    break;
                case "beer":
                    System.out.println(1.10*quantity);
                    break;
                case "sweets":
                    System.out.println(1.35*quantity);
                    break;
                case "peanuts":
                    System.out.println(1.55*quantity);
                    break;
                default:
                    System.out.println("unknown");
                    break;
            }
        }
    }
}
