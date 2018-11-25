package p07_deck_of_cards;


public class Card {
    private RankType rankType;
    private SuitType suitType;

    public Card(RankType rankType, SuitType suitType) {
        this.rankType = rankType;
        this.suitType = suitType;
//        this.rankType = RankType.valueOf(rankType.toUpperCase());
//        this.suitType = SuitType.valueOf(suitType.toUpperCase());
    }



    @Override
    public String toString() {
        return String.format("%s of %s", this.rankType, this.suitType);
    }

}
