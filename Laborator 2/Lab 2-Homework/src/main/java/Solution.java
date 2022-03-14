/**
 * Clasa Solution
 *
 * @author Petrea Daniela
 */
import java.util.ArrayList;

/**
 * Folosim un algoritm greedy pentru a repartiza evenimentele din vectorul de tip Event la camere din vectorul de tip Room,
 * astfel incat numarul de camere folosite sa fie minim
 */
public class Solution {
    public void toResolve(Event[] events1, Room[] rooms1) {
        ArrayList<Room> myArray = new ArrayList<>();
        ArrayList<Event> myArray1 = new ArrayList<>();
        int index = 0;
        for (Room r : rooms1) {
            for (Event e : events1) {
                if (e.getSize()<=r.getCapacity()) {
                    if (!myArray1.contains(e)) {
                        if (myArray.contains(r)) {
                            if (myArray1.get(index - 1).getEndTime() <= e.getStartTime()) {
                                myArray.add(r);
                                myArray1.add(e);
                                index++;
                            }
                        } else {
                            myArray.add(r);
                            myArray1.add(e);
                            index++;
                        }
                    }
                }
            }
        }
        int j = 0;
        for (Room i : myArray) {
            System.out.println(i.getName() + " -> " + myArray1.get(j).getName());
            j++;
        }

    }
}