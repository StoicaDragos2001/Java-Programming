import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for creating DSaturAlgorithm subclass
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public class DSaturAlgorithm extends Algorithm {
    /**
     * Constructor for DSaturAlgorithm that inherits Algorithm superclass
     *
     * @param pb Instance of Problem class.
     */
    public DSaturAlgorithm(Problem pb) {
        super(pb);
    }

    /**
     * Method that solves the instance of the given problem.
     *
     * @return Objects of Solution class obtained my using the DSatur strategy on the given problem.
     */
    public Solution solve() {
        ArrayList<Room> assigment = new ArrayList<>();
        for(int eventIndex=0; eventIndex < pb.getEvents().size()-1; eventIndex++)
            for(int eventIndex2=eventIndex+1; eventIndex2 < pb.getEvents().size(); eventIndex2++)
            {
                int compare = pb.getEvents().get(eventIndex).getStartTime().compareTo(pb.getEvents().get(eventIndex2).getStartTime());
                if(compare > 0){
                    Collections.swap(pb.getEvents(), eventIndex, eventIndex2);
                }
            }
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
