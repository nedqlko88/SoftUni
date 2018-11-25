import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05BigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bigNumber = reader.readLine();
        int num = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int littleLeft = 0;
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int currNumber = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            int multiply = currNumber * num;
            int numToAdd = (multiply % 10) + left +littleLeft;

            if (numToAdd >= 10) {
                sb.append(numToAdd % 10);
                littleLeft = 1;
            } else {
                sb.append(numToAdd);
                 littleLeft = 0;
            }

            left = multiply / 10;
        }

        if (left > 0 || littleLeft > 0) {
            sb.append(left + littleLeft);
        }

            boolean isZero = true;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                isZero = false;
            }
        }
        if (isZero) {
            System.out.println(0);
        } else {
        System.out.println(sb.reverse().toString());

        }

    }
}
