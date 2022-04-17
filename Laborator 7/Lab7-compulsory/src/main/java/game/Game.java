package game;
import pieces.Bag;
import pieces.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class Game
 * @authors: Petrea Daniela & Stoica Dragos
 */
public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private static ExecutorService executors = Executors.newFixedThreadPool(3);
    private String winner = null;
    private final List<Player> players = new ArrayList<>();


    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() throws InterruptedException {
        for(Player p : players) {
            executors.execute(p);
        }
        executors.shutdown();
        while (!executors.isTerminated()) {
            Thread.sleep(100);
        }
    }

    public boolean isEnded()
    {
        return winner != null;
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }
}
