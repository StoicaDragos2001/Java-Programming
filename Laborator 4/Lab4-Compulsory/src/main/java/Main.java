import instances.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * @author Petrea Daniela
 */

public class Main {

    public static void main(String[] args) {
        List<Intersection> nodes = IntStream.rangeClosed(0, 8).mapToObj(i -> new Intersection("v" + i)).collect(Collectors.toList());

        for (Intersection node : nodes)
            System.out.print(node.getName() + " ");
        System.out.println();

        LinkedList<Street> streets = new LinkedList<>();
        streets.add(new Street(2, "s0", nodes.get(0), nodes.get(1)));
        streets.add(new Street(2, "s1", nodes.get(0), nodes.get(2)));
        streets.add(new Street(2, "s2", nodes.get(0), nodes.get(3)));
        streets.add(new Street(2, "s3", nodes.get(1), nodes.get(2)));
        streets.add(new Street(3, "s4", nodes.get(1), nodes.get(4)));
        streets.add(new Street(1, "s5", nodes.get(2), nodes.get(3)));
        streets.add(new Street(2, "s6", nodes.get(2), nodes.get(5)));
        streets.add(new Street(2, "s7", nodes.get(2), nodes.get(6)));
        streets.add(new Street(3, "s8", nodes.get(3), nodes.get(6)));
        streets.add(new Street(1, "s9", nodes.get(4), nodes.get(6)));
        streets.add(new Street(1, "s10", nodes.get(4), nodes.get(7)));
        streets.add(new Street(2, "s11", nodes.get(4), nodes.get(8)));
        streets.add(new Street(1, "s12", nodes.get(5), nodes.get(7)));
        streets.add(new Street(1, "s13", nodes.get(5), nodes.get(8)));
        streets.add(new Street(3, "s14", nodes.get(6), nodes.get(8)));
        streets.add(new Street(1, "s15", nodes.get(7), nodes.get(8)));

        Collections.sort(streets);

        for (Street street : streets)
            System.out.println(street);

        Set<Intersection> intersectionSet = new HashSet<>();
        for (Intersection intersection : nodes)
            intersectionSet.add(intersection);
        for (Intersection node : intersectionSet)
            System.out.print(node.getName() + " ");
        System.out.println();

    }
}