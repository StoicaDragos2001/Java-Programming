/**
 * Clasa Main
 *
 * @author Petrea Daniela
 */

public class Main {
    public static void main(String[] args) {
        /**
         * Se apeleaza constructorul Event
         */
        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);
        /**
         * Se apeleaza metoda print
         */
        C1.print();
        C2.print();
        L1.print();
        L2.print();
        L3.print();
        /**
         * Se apeleaza constructorul Room
         */
        Room R401 = new Room("401", 30,RoomType.LABS);
        Room R403 = new Room("403", 30,RoomType.LABS);
        Room R405 = new Room("405", 30,RoomType.LABS);
        Room R309 = new Room("309", 100,RoomType.HALL);
        /**
         * Se apeleaza metoda print
         */
        R401.print();
        R403.print();
        R405.print();
        R309.print();
    }
}