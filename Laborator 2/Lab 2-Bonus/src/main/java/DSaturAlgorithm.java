import java.util.ArrayList;
import java.util.HashSet;

/**
 * Clasa DSaturAlgorithm
 *
 * @author Petrea Daniela
 */
public class DSaturAlgorithm {
    /**
     *
     * @param a numele array-ului
     * @param i indexul parametrului 1 care se doreste interschimbat
     * @param j indexul parametrului 2 care se doreste interschimbat
     * @param <T> tipul array-ului
     */
    public <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     *
     * @param events1 array-ul de evenimente
     * @param rooms1 array-ul de camere
     */

    /**
     * ordonam evenimentele in ordine crescatoare a orei de incepere, dupa care aplicam algoritmul greedy
     */

    public void toResolve(Event[] events1, Room[] rooms1) {
        ArrayList<Room> myArray = new ArrayList<>();
        ArrayList<Event> myArray1 = new ArrayList<>();
        for(int eventIndex=0; eventIndex < events1.length-1; eventIndex++)
            for(int eventIndex2=eventIndex+1; eventIndex2 < events1.length; eventIndex2++)
            {
                int compare = events1[eventIndex].getStartTime().compareTo(events1[eventIndex2].getStartTime());
                if(compare > 0){
                    swap(events1, eventIndex, eventIndex2);
                }
            }
        int index = 0;
        for (Room r : rooms1) {
            for (Event e : events1) {
                if (e.getSize()<=r.getCapacity()) {
                    if (!myArray1.contains(e)) {
                        if (myArray.contains(r)) {
                            int comparison = myArray1.get(index - 1).getEndTime().compareTo(e.getStartTime());
                            if ( comparison <= 0) {
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
        HashSet<Room> distinct = new HashSet<>(myArray);
        System.out.println("Numarul de camere generate de algoritmul DSatur este : "
                + distinct.size());
        int j = 0;
        for (Room i : myArray) {
            System.out.println(i.getName() + " -> " + myArray1.get(j).getName());
            j++;
        }

    }
    }
