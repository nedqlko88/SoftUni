import java.util.Scanner;

public class equalPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arraySums = new int[n];
        int[] arrayDiffs = new int[n-1];
        boolean equals = true;
        int sumG = 0 ;
        for (int i=0;i<n;i++) {
           int a = Integer.parseInt(scanner.nextLine());
           int b = Integer.parseInt(scanner.nextLine());
           arraySums[i]= a + b;
        }
        if (n==1) {
            sumG = arraySums[0];
        }
        for (int i = 0; i < arraySums.length-1; i++) {
            arrayDiffs[i] = Math.abs(arraySums[i] - arraySums[i+1]);
            if (arraySums[i] == arraySums[i+1] && equals) {
                sumG = arraySums[i];
            }   else {
                equals = false;
            }

        }
        int maxDiff = -100000000;
        for (int i=0;i < arrayDiffs.length;i++) {
            if (arrayDiffs[i] > maxDiff) {
                maxDiff = arrayDiffs[i];
            }
        }
        if (equals) {
            System.out.printf("Yes, value=%d",sumG);
        } else {
            System.out.printf("No, maxdiff=%d",maxDiff);
        }
    }
}

