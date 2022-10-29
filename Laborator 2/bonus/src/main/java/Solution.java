import java.util.ArrayList;

/**
 * This class is for creating and manipulating Solution class.
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public class Solution {
    private ArrayList<Room> assignment;

    /**
     * Constructor for Solution class.
     *
     * @param assignment ArrayList of Room objects where assignment[i] = what room received the event with index i.
     */
    public Solution(ArrayList<Room> assignment) {
        this.assignment = assignment;
    }

    /**
     * Getter for assignment.
     *
     * @return assignment attribute - ArrayList of Room objects.
     */
    public ArrayList<Room> getAssignment() {
        return assignment;
    }

    /**
     * Method that computes the number of distinct used rooms.
     *
     * @return An integer obtained via counting the distinct used rooms.
     */
    public int computeUsedRooms() {
        return (int) this.assignment.stream().distinct().count();
    }
}
