package pieces;

import game.Player;

import java.util.ArrayList;

/**
 * class Board
 * authors: Petrea Daniela & Stoica Dragos
 */

public class Board {
    private static final ArrayList<String> words=new ArrayList<>();

    public static void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }

}
