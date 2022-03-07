/**
 * Clasa Problem
 *
 * @author Petrea Daniela
 */
public class Problem {
    /**
     * Atributele clasei Problem sunt 2 array-uri, unul de tip Event pentru evenimente si unul de tip Room pentru camere
     */

    private Event[] events;
    private Room[] rooms;

    /**
     * in constructorul de problem folosim metoda equal pentru a verifica daca avem camere sau evenimente cu acelasi nume
     * @param events
     * @param rooms
     */

    public Problem(Event[] events, Room[] rooms) {
        for(int room1=0;room1<rooms.length-1;room1++)
            for(int room2=room1+1; room2< rooms.length;room2++)
                if(rooms[room1].equals(rooms[room2])){
                    System.out.println("Same room");
                    System.exit(-1);
                }
        for(int event1=0;event1<events.length-1;event1++)
            for(int event2=event1+1; event2< events.length;event2++)
                if(events[event1].equals(events[event2])){
                    System.out.println("Same event");
                    System.exit(-1);
                }
        this.events = events;
        this.rooms = rooms;
    }

    /**
     * 2 functii setter
     */

    /**
     *
     * @param events
     */
    public void setEvents(Event[] events) {
        this.events = events;
    }

    /**
     *
     * @param rooms
     */
    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    /**
     * 2 functii getter
     */

    /**
     *
     * @return events
     */

    public Event[] getEvents() {
        return events;
    }

    /**
     *
     * @return rooms
     */

    public Room[] getRooms() {
        return rooms;
    }
}
