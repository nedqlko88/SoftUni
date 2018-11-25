package p01_card_suit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
       Cards[] cards = Cards.values();
        System.out.println(a + ":");
        for (Cards card : cards) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", card.ordinal(), card.name()));
        }
    }
}
