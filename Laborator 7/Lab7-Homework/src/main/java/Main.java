import game.Game;
import game.Player;

import java.util.concurrent.TimeUnit;

/**
 * class Main
 * authors: Petrea Daniela & Stoica Dragos
 */
public class Main {
    public static void main(String args[]) throws InterruptedException {
        Game game = new Game(1);
        game.timekeeper.setStartGameTime(System.nanoTime());
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
        game.timekeeper.setEndGameTime(System.nanoTime());
        System.out.println(game.timekeeper.getEndGameTime()-game.timekeeper.getStartGameTime() + " nanoseconds");
        long timeInSeconds = TimeUnit.SECONDS.convert((game.timekeeper.getEndGameTime()-game.timekeeper.getStartGameTime()), TimeUnit.NANOSECONDS);
        System.out.println(timeInSeconds + " seconds");
    }

}