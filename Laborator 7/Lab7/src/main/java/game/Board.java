package game;

import java.util.ArrayList;

public class Board {
    private final ArrayList<String> words;
    public static void addWord(Player player, String word) {
       // add the word to the collection;
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }



}
