package p03_cards_power;

import p01_card_suit.Cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();

        try {
            Card card = new Card(rank, suit);
            System.out.println(card);
        } catch (IllegalArgumentException ignored) {
            //good practice to do when we don't need the error;
            ;
        }


    }
}
