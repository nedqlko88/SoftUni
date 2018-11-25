package p08_card_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player firstPlayer = new Player(reader.readLine());
        Player secondPlayer = new Player(reader.readLine());

        Game game = new Game(firstPlayer, secondPlayer);
        Deck deck = new Deck();


        while (true) {
            if (secondPlayer.getHandSize() == 5) {
                break;
            }
            String[] tokens = reader.readLine().split(" of ");

            Card card;
            try {
                RankType rankType = Enum.valueOf(RankType.class, tokens[0].toUpperCase());
                SuitType suitType = Enum.valueOf(SuitType.class, tokens[1].toUpperCase());

                card = new Card(rankType, suitType);

            } catch (IllegalArgumentException iae) {
                System.out.println("No such card exists.");
                continue;
            }

            if (!deck.contains(card)) {
                System.out.println("Card is not in the deck.");
                continue;
            }

            deck.remove(card);

            if (firstPlayer.getHandSize() < 5) {
                firstPlayer.add(card);
            } else if (secondPlayer.getHandSize() < 5) {
                secondPlayer.add(card);
            }
        }
        Player winner = game.getWinner();
        System.out.println(String.format("%s wins with %s.", winner.getName(), winner.getPowerfullCard()));
    }
}
