import java.util.ArrayList;

public class Main {
    //Stoica Dragos-Stefan 2A5
    public static void main(String[] args) {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("C1", 100, 8, 10));
        events.add(new Event("C2", 100, 10, 12));
        events.add(new Event("L1", 30, 8, 10));
        events.add(new Event("L2", 30, 8, 10));
        events.add(new Event("L3", 30, 10, 12));
        //events.add(new Event("L3", 30, 10, 12));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new ComputerLab("401", 30, "Windows 10"));
        rooms.add(new ComputerLab("403", 30, "Linux"));
        rooms.add(new ComputerLab("405", 30, "Windows XP"));
        rooms.add(new LectureHall("309", 100, true));
        //rooms.add(new LectureHall("309", 100, true));

        Problem pb = new Problem(events, rooms);

        for (Room roomsIndex : pb.getRooms())
            System.out.println(roomsIndex);

        for (Event eventsIndex : pb.getEvents())
            System.out.println(eventsIndex);

        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution sol = greedy.solve();

        System.out.println("Au fost folosite " + sol.computeUsedRooms() + " camere:");
        if (sol.getAssignment().size() < events.size())
            System.out.println("Repartizare imposibila");
        for (int assigned = 0; assigned < sol.getAssignment().size(); assigned++)
            System.out.println(events.get(assigned).getName() + " -> " + sol.getAssignment().get(assigned).getName());
        for (int unassigned = sol.getAssignment().size(); unassigned < events.size(); unassigned++)
            System.out.println(events.get(unassigned).getName() + " -> ");


    }
}
