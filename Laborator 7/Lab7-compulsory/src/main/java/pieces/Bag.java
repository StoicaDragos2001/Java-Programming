package pieces;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class Bag
 * authors: Petrea Daniela & Stoica Dragos
 */

public class Bag {
    private final ArrayList<Tile> tiles = new ArrayList<>();

    /**
     * there are 10 tiles for each letter in the bag
     */
    public Bag() {
        for (int i = 0; i < 10; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                Tile tile = new Tile(c);
                tiles.add(tile);
            }
        }
    }

    /**
     *
     * @param howMany tiles we want to extract
     * @return extracted that is the list with the extracted tiles
     */
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
