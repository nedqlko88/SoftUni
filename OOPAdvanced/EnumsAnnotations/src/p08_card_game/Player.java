package p08_card_game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void add(Card card) {
        this.hand.add(card);
    }


    public Card getPowerfullCard() {
        return this.hand.stream()
               .max(Card::compareTo)
                .get();
    }
    public int getHandSize() {
        return this.hand.size();
    }

}
