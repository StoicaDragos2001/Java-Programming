package pieces;

import java.util.Random;

/**
 * class Tile
 * authors: Petrea Daniela & Stoica Dragos
 */

public class Tile {
    private final char letter;
    private final int points;

    /**
     * each letter is worth a random number of points (between 1 and 10)
     * @param letter
     */
    public Tile(char letter) {
        this.letter = letter;
        Random random = new Random();
        this.points= random.nextInt(1,11);
    }

    public int getPoints() {
        return points;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "letter=" + letter +
                ", points=" + points +
                '}';
    }
}