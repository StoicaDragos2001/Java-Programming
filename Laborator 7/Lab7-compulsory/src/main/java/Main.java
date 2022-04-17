import game.Game;
import game.Player;

/**
 *  class Main
 *  @authors: Petrea Daniela & Stoica Dragos
 */
public class Main {
    public static void main(String args[]) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}