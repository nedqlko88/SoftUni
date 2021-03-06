package p08_card_game;

public enum SuitType {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    SuitType(int power) {
        this.power = power;
    }

    public int getPower()
    {
        return this.power;
    }
}
