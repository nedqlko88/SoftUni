package p07_deck_of_cards;


public enum SuitType {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    SuitType(int power) {
        this.power = power;
    }


}
