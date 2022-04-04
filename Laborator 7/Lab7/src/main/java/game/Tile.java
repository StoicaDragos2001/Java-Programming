package game;

import java.util.Random;

public class Tile {
    private final char letter;
    private final int points;

    public Tile() {
        letter = 0;
        Random random = new Random();
        points= random.nextInt(1,11);
    }

    public int getPoints() {
        return points;
    }

    public char getLetter() {
        return letter;
    }

}