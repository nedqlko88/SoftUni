
import java.util.Scanner;
import java.text.DecimalFormat;
public class oddEvenPosition {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double oddSum = 0;
        double evenSum = 0;
        double oddMin = 1000000000.0;
        double evenMin = 1000000000.0;
        double oddMax = -1000000000.0;

        double evenMax = -1000000000.0;
        for (int i=1;i<=n;i++)  {
            double  a = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += a;
                if (a > evenMax) {
                    evenMax = a;
                }
                if (a < evenMin) {
                    evenMin = a;
                }
            } else  {
                    oddSum += a;
                    if (a > oddMax) {
                        oddMax = a;
                    }
                    if (a < oddMin) {
                        oddMin = a;
                    }
            }

        }
        System.out.printf("OddSum=%s,%n",formatter.format(oddSum));
        if (oddMin == 1000000000.0) {
            System.out.println("OddMin=No,");
        } else {
            System.out.printf("OddMin=%s,%n",formatter.format(oddMin));
        }
        if (oddMax == -1000000000.0) {
            System.out.println("OddMax=No,");
        } else {
            System.out.printf("OddMax=%s,%n",formatter.format(oddMax));
        }
        System.out.printf("EvenSum=%s,%n",formatter.format(evenSum));
        if (evenMin == 1000000000.0) {
            System.out.println("EvenMin=No,");
        } else {
            System.out.printf("EvenMin=%s,%n",formatter.format(evenMin));
        }
        if (evenMax == -1000000000.0) {
            System.out.println("EvenMax=No,");
        } else {
            System.out.printf("EvenMax=%s,%n",formatter.format(evenMax));
        }
    }
}

