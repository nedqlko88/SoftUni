import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int powerLeft = 0;
        if (input.length() == 0) {
            return;
        }

        sb.append(input, 0, input.indexOf('>') + 1);
        input = input.substring(input.indexOf('>') + 1);
        int count = 0;


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                count++;
            }
        }


        while (input.contains(">")) {
            int strength = Integer.parseInt(String.valueOf(input.charAt(0))) + powerLeft;


            int nextExplosion = input.indexOf('>');

            if (nextExplosion >= strength) {
                sb.append(input, strength, nextExplosion + 1);
                input = input.substring(nextExplosion + 1);
                powerLeft = 0;
            } else {
                powerLeft = strength - nextExplosion;
                sb.append(">");
                input = input.substring(nextExplosion + 1);
            }
        }
        int str = 0;
        if (Character.isDigit(input.charAt(0))) {
            str = Integer.parseInt(String.valueOf(input.charAt(0))) + powerLeft;
        } else {
            str = powerLeft;
        }

        if (str < input.length()) {
            sb.append(input.substring(str));
        }
        System.out.println(sb.toString());
    }
}
