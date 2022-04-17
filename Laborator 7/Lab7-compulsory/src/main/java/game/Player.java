package game;

import pieces.Tile;

import java.io.IOException;
import java.util.List;

/**
 * class Player
 * authors: Petrea Daniela & Stoica Dragos
 */
public class Player implements Runnable {
    private String name;
    private Game game;
    private Integer points;
    private final int THINKING_TIME = 50;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    private boolean submitWord() throws IOException, InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        String word = "";
        Integer pointsSum = getPoints();
        for (Tile letter : extracted) {
            word += letter.getLetter();
            pointsSum += letter.getPoints();
        }

        //  create a word with all the extracted tiles;
        game.getBoard().addWord(this, word);
        setPoints(pointsSum);
        //    make the player sleep 50ms;
        Thread.sleep(THINKING_TIME);
        return true;
    }

    public void run() {
        try {
            while (this.submitWord()) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setGame(Game g) {
        game = g;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
