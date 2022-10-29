import java.util.ArrayList;

/**
 * Class for creating GreedyAlgorithm subclass
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public class GreedyAlgorithm extends Algorithm {
    /**
     * Constructor for GreedyAlgorithm that inherits Algorithm superclass
     *
     * @param pb Instance of Problem class.
     */
    public GreedyAlgorithm(Problem pb) {
        super(pb);
    }

    /**
     * Method that solves the instance of the given problem.
     *
     * @return Objects of Solution class obtained my using the greedy strategy on the given problem.
     */
    public Solution solve() {
        ArrayList<Room> assigment = new ArrayList<>();
        for (int eventIndex = 0; eventIndex < pb.getEvents().size(); eventIndex++) {
            for (int roomIndex = 0; roomIndex < pb.getRooms().size(); roomIndex++) {
                if (pb.getEvents().get(eventIndex).getSize() <= pb.getRooms().get(roomIndex).getCapacity()) {
                    int noOverlapping = 1;
                    for (int assigIndex = 0; assigIndex < assigment.size(); assigIndex++)
                        if (pb.getRooms().get(roomIndex) == assigment.get(assigIndex) && pb.getEvents().get(eventIndex).getStartTime() == pb.getEvents().get(assigIndex).getStartTime()) {
                            noOverlapping = 0;
                            break;
                        }
                    if (noOverlapping == 1) {
                        assigment.add(pb.getRooms().get(roomIndex));
                        break;
                    }
                }
            }
        }

        Solution sol = new Solution(assigment);
        return sol;
    }
}
