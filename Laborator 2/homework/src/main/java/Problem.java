import java.util.ArrayList;

/**
 * This class is for creating an instance of the problem
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public class Problem {
    private ArrayList<Event> events;
    private ArrayList<Room> rooms;

    /**
     * This constructor fills private ArrayLists events and rooms and tests if events or rooms appear more than once.
     *
     * @param events ArrayList of Event objects.
     * @param rooms  ArrayList of Room objects.
     */
    public Problem(ArrayList<Event> events, ArrayList<Room> rooms) {
        for (int roomIndex1 = 0; roomIndex1 < rooms.size() - 1; roomIndex1++)
            for (int roomIndex2 = roomIndex1 + 1; roomIndex2 < rooms.size(); roomIndex2++)
                if (rooms.get(roomIndex1).equals(rooms.get(roomIndex2))) {
                    System.out.println("Se repeta camere");
                    System.exit(-1);
                }
        for (int eventIndex1 = 0; eventIndex1 < events.size() - 1; eventIndex1++)
            for (int eventIndex2 = eventIndex1 + 1; eventIndex2 < events.size(); eventIndex2++)
                if (events.get(eventIndex1).equals(events.get(eventIndex2))) {
                    System.out.println("Se repeta evenimente");
                    System.exit(-1);
                }
        this.events = events;
        this.rooms = rooms;
    }

    /**
     * This method is a setter for events ArrayList.
     *
     * @param events ArrayList of Event objects.
     */
    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * This method is a setter for rooms ArrayList.
     *
     * @param rooms ArrayList of Room objects.
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * This method is a getter for events ArrayList.
     *
     * @return ArrayList of events.
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * This method is a getter for rooms ArrayList.
     *
     * @return ArrayList of rooms.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
