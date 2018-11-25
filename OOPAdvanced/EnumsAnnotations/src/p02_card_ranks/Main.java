package p02_card_ranks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        System.out.println(a + ":");

        CardsRank[] cardsRanks = CardsRank.values();
        for (CardsRank cardsRank : cardsRanks) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", cardsRank.ordinal(), cardsRank.name()));
        }
    }
}
