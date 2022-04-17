package pieces;

/**
 * class Tile
 * authors: Petrea Daniela & Stoica Dragos
 */

public class Tile {
    private final char letter;
    private int points=0;

    public Tile(char letter) {
        this.letter = letter;
        if (this.letter == 'a' || this.letter == 'e' || this.letter == 'i' || this.letter == 'o' || this.letter == 'u' || this.letter == 'l'
                || this.letter == 'n' || this.letter == 's' || this.letter == 't' || this.letter == 'r')
            this.points = 1;
        else if (this.letter == 'd' || this.letter == 'g')
            this.points = 2;
        else if (this.letter == 'b' || this.letter == 'c' || this.letter == 'm' || this.letter == 'p')
            this.points = 3;
        else if (this.letter == 'f' || this.letter == 'h' || this.letter == 'v' || this.letter == 'w' || this.letter == 'y')
            this.points = 4;
        else if (this.letter == 'k')
            this.points = 5;
        else if (this.letter == 'j' || this.letter == 'x')
            this.points = 8;
        else if (this.letter == 'q' || this.letter == 'z')
            this.points = 10;
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