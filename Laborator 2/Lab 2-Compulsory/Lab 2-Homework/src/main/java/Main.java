/**
 * Clasa Main
 *
 * @author Petrea Daniela
 */
public class Main {
    public static void main(String[] args) {
        Event[] events = new Event[5];
        events[0] = new Event("C1", 100, 8, 10);
        events[1] = new Event("C2", 100, 10, 12);
        events[2] = new Event("L1", 30, 8, 10);
        events[3] = new Event("L2", 30, 8, 10);
        events[4] = new Event("L3", 30, 10, 12);
        Room[] rooms = new Room[4];
        rooms[0] = new ComputerLab("401", 30, "Windows 10");
        rooms[1] = new ComputerLab("403", 30, "Linux");
        rooms[2] = new ComputerLab("405", 30, "Windows XP");
        rooms[3] = new LectureHall("309", 100, true);
        Problem problem = new Problem(events, rooms);
        Room[] rooms1 = problem.getRooms();
        Event[] events1 = problem.getEvents();
        for(Room r : rooms1){
            r.print();
        }
        for(Event e : events1){
            e.print();
        }
        Solution solution = new Solution();
        solution.toResolve(events1,rooms1);
    }

}
