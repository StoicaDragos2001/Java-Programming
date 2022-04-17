package pieces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * class Bag
 * authors: Petrea Daniela & Stoica Dragos
 */
public class Bag {
    private final ArrayList<Tile> tiles = new ArrayList<>();
    private HashMap<Character, Integer> numberOfTiles = new HashMap<Character, Integer>();

    public Bag() {
        numberOfTiles.put('a',9);
        numberOfTiles.put('b',2);
        numberOfTiles.put('c',2);
        numberOfTiles.put('d',4);
        numberOfTiles.put('e',12);
        numberOfTiles.put('f',2);
        numberOfTiles.put('g',3);
        numberOfTiles.put('h',2);
        numberOfTiles.put('i',9);
        numberOfTiles.put('j',1);
        numberOfTiles.put('k',1);
        numberOfTiles.put('l',4);
        numberOfTiles.put('m',2);
        numberOfTiles.put('n',6);
        numberOfTiles.put('o',8);
        numberOfTiles.put('p',2);
        numberOfTiles.put('q',1);
        numberOfTiles.put('r',6);
        numberOfTiles.put('s',4);
        numberOfTiles.put('t',6);
        numberOfTiles.put('u',4);
        numberOfTiles.put('v',2);
        numberOfTiles.put('w',2);
        numberOfTiles.put('x',1);
        numberOfTiles.put('y',2);
        numberOfTiles.put('z',1);
            for (char c = 'a'; c <= 'z'; c++) {
                Tile tile = new Tile(c);
                for(int numberOfAppearances=0;numberOfAppearances<numberOfTiles.get(c);numberOfAppearances++)
                tiles.add(tile);
            }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            Random random = new Random();
            int randomTile = random.nextInt(0, tiles.size());
            Tile toExtract = tiles.get(randomTile);
            extracted.add(toExtract);
            tiles.remove(randomTile);
        }
        return extracted;
    }

    public boolean emptyBag() {
        return tiles.isEmpty();
    }

}
