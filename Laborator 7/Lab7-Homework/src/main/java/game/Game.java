package game;
import pieces.Bag;
import pieces.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class Game
 * authors: Petrea Daniela & Stoica Dragos
 */
public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private static ExecutorService executors = Executors.newFixedThreadPool(3);
    private String winner = null;
    private final List<Player> players = new ArrayList<>();
    boolean timeUp = false;
    public Timekeeper timekeeper;

    public Game(int maxSecondsToLast) {
        timekeeper = new Timekeeper(maxSecondsToLast);
    }
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() throws InterruptedException {
        for(Player p : players) {
            executors.execute(p);
        }
        executors.shutdown();
        while (!executors.isTerminated()&& !timeUp) {
            Thread.sleep(100);
        }
        if (timeUp)
            System.out.println("Time's up!");
        Integer max=0;
        int maxIndex=0;
        for(int indexPlayer=0;indexPlayer<players.size()-1;indexPlayer++) {
            if( max<  players.get(indexPlayer).getPoints()) {
                max=players.get(indexPlayer).getPoints();
                maxIndex=indexPlayer;
            }
        }
        winner=players.get(maxIndex).getName();
        System.out.println("Winner is " + winner + " who obtains "+max+" points");
    }
    public synchronized void setWinner(Player p) {
        if (winner == null) {
            winner = p.toString();
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
