package p06_custom_annotation;

@CustomAnnotation(category = "Suit", descriotion = "Provides suit constants for a Card class.")
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
