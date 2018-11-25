package p05_card_compare;

public class Card implements Comparable<Card> {
    private RankType rankType;
    private SuitType suitType;

    public Card(String rankType, String suitType) {
        this.rankType = Enum.valueOf(RankType.class, rankType.toUpperCase());
        this.suitType = Enum.valueOf(SuitType.class, suitType.toUpperCase());
//        this.rankType = RankType.valueOf(rankType.toUpperCase());
//        this.suitType = SuitType.valueOf(suitType.toUpperCase());
    }


    public int getPower() {
        return this.rankType.getPower() + this.suitType.getPower();
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getPower(), other.getPower());
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rankType, this.suitType);
    }

}
