package p04_smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] phones = reader.readLine().split("\\s+");
        String[] sites = reader.readLine().split("\\s+");

        Browserable smartphone = new Smartphone(phones, sites);
        smartphone.callNumber();
        smartphone.browseSite();
    }
}
