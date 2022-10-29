import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    //Stoica Dragos-Stefan 2A5

    public static void main(String[] args) {

        ArrayList<Event> events = new ArrayList<>();
        for (int instanceEvent = 0; instanceEvent < Generator.generateNumberOfInstances(); instanceEvent++) {
            LocalTime hour = Generator.generateHour();
            events.add(new Event(Generator.generateEventName(), Generator.generateSize(), hour, hour.plusHours(2)));
        }

        ArrayList<Room> rooms = new ArrayList<>();
        for (int instanceRoom = 0; instanceRoom < Generator.generateNumberOfInstances(); instanceRoom++) {
            if (Generator.coinFlip())
                rooms.add(new ComputerLab(Generator.generateRoomName(), Generator.generateSize(), Generator.generateOS()));
            else
                rooms.add(new LectureHall(Generator.generateRoomName(), Generator.generateSize(), Generator.coinFlip()));
        }

        System.out.println("We generated " + events.size() + " events");
        System.out.println("we generated " + rooms.size() + " rooms");

        Problem pb = new Problem(events, rooms);

        for (Room roomsIndex : pb.getRooms())
            System.out.println(roomsIndex);

        for (Event eventsIndex : pb.getEvents())
            System.out.println(eventsIndex);

        long greedyStartTime = System.currentTimeMillis();
        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution solGreedy = greedy.solve();

        System.out.println("Pentru Greedy au fost folosite " + solGreedy.computeUsedRooms() + " camere:");
        if (solGreedy.getAssignment().size() < events.size())
            System.out.println("Repartizare imposibila");
        for (int assigned = 0; assigned < solGreedy.getAssignment().size(); assigned++)
            System.out.println(events.get(assigned).getName() + " -> " + solGreedy.getAssignment().get(assigned).getName());
        for (int unassigned = solGreedy.getAssignment().size(); unassigned < events.size(); unassigned++)
            System.out.println(events.get(unassigned).getName() + " -> ");

        long greedyElapsedTime = System.currentTimeMillis() - greedyStartTime;
        Runtime runtimeGreedy = Runtime.getRuntime();
        runtimeGreedy.gc();
        long memoryGreedy = runtimeGreedy.totalMemory() - runtimeGreedy.freeMemory();

        long dSaturStartTime = System.currentTimeMillis();
        Algorithm dSatur = new DSaturAlgorithm(pb);
        Solution solDSatur = dSatur.solve();

        System.out.println("Pentru DSatur au fost folosite " + solDSatur.computeUsedRooms() + " camere:");
        if (solDSatur.getAssignment().size() < events.size())
            System.out.println("Repartizare imposibila");
        for (int assigned = 0; assigned < solDSatur.getAssignment().size(); assigned++)
            System.out.println(events.get(assigned).getName() + " -> " + solDSatur.getAssignment().get(assigned).getName());
        for (int unassigned = solDSatur.getAssignment().size(); unassigned < events.size(); unassigned++)
            System.out.println(events.get(unassigned).getName() + " -> ");

        long dSaturElapsedTime = System.currentTimeMillis() - dSaturStartTime;
        Runtime runtimeDSatur = Runtime.getRuntime();
        runtimeDSatur.gc();
        long memoryDSatur = runtimeDSatur.totalMemory() - runtimeDSatur.freeMemory();

        System.out.println("Used memory in bytes for Greedy: " + memoryGreedy);
        System.out.println("Runtime in milliseconds for Greedy: " + greedyElapsedTime);
        System.out.println("Used memory in bytes for DSatur: " + memoryDSatur);
        System.out.println("Runtime in milliseconds for DSatur: " + dSaturElapsedTime);

    }
}
