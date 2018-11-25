package p08_card_game;

public class Game {

    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }


    public Player getWinner() {
      return this.firstPlayer.getPowerfullCard().compareTo(this.secondPlayer.getPowerfullCard()) > 0 ?
              firstPlayer : secondPlayer;
        }


}
