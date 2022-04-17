package game;

import dictionary.MockDictionary;
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
    private static MockDictionary dictionary;
    private static String word="";

    static {
        try {
            dictionary = new MockDictionary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static String getWord() {
        return word;
    }

    public static void setWord(String wordGiven) {
        word = wordGiven;
    }

    private boolean submitWord() throws IOException, InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        setWord("");
        String word1="";
        Integer pointsSum = getPoints();
        for (Tile letter : extracted) {
            word1 += letter.getLetter();
            pointsSum += letter.getPoints();
        }
        setWord(word1);
        dictionary.setOk(0);
        for (int k = 1; k <= 7; k++)
            perm("", getWord(), k);
        //  create a word with all the extracted tiles;
        game.getBoard().addWord(this, getWord());
        if (dictionary.getOk()==1) {
            game.getBag().extractTiles(word.length());
        }
        else {
            pointsSum=0;
            game.getBag().extractTiles(7);
        }
        setPoints(pointsSum);
        //    make the player sleep 50ms;
        Thread.sleep(THINKING_TIME);
        return true;
    }

    /**
     * k permutations
     * we try all the possibilities to see if the player manages to compose a word from the 7 tiles
     * @param prefix
     * @param string
     * @param k
     * @throws IOException
     */
    public static void perm(String prefix, String string, int k) throws IOException {
        int prefixLength = prefix.length();

        int wordLength = string.length();

        if (prefixLength == k) {
            if (dictionary.isWord(prefix)) {
                dictionary.setOk(1);
                setWord(prefix);
            }
        } else {
            for (int i = 0; i < wordLength; i++)
                perm(prefix + string.charAt(i), string.substring(0, i) + string.substring(i + 1, wordLength), k);
        }
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
