import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Petrea Daniela
 */

public class Main {
    static Set<Intersection> convertion(Intersection[] nodes) {
        Set<Intersection> setConverted = new HashSet<>();
        setConverted.addAll( Arrays.asList(nodes) );
        return setConverted;
    }

    public static void main(String[] args) {
        var nodes = IntStream.rangeClosed(0, 8).mapToObj(i -> new Intersection("v" + i)).toArray(Intersection[]::new);

        for (Intersection node : nodes)
            System.out.print(node.getName() + " ");
        System.out.println();

        LinkedList<Street> streets = new LinkedList<>();
        streets.add(new Street(2, "s0", nodes[0], nodes[1]));
        streets.add(new Street(2, "s1", nodes[0], nodes[2]));
        streets.add(new Street(2, "s2", nodes[0], nodes[3]));
        streets.add(new Street(2, "s3", nodes[1], nodes[2]));
        streets.add(new Street(3, "s4", nodes[1], nodes[4]));
        streets.add(new Street(1, "s5", nodes[2], nodes[3]));
        streets.add(new Street(2, "s6", nodes[2], nodes[5]));
        streets.add(new Street(2, "s7", nodes[2], nodes[6]));
        streets.add(new Street(3, "s8", nodes[3], nodes[6]));
        streets.add(new Street(1, "s9", nodes[4], nodes[6]));
        streets.add(new Street(1, "s10", nodes[4], nodes[7]));
        streets.add(new Street(2, "s11", nodes[4], nodes[8]));
        streets.add(new Street(1, "s12", nodes[5], nodes[7]));
        streets.add(new Street(1, "s13", nodes[5], nodes[8]));
        streets.add(new Street(3, "s14", nodes[6], nodes[8]));
        streets.add(new Street(1, "s15", nodes[7], nodes[8]));

        Collections.sort(streets);

        for (Street street : streets)
            System.out.println(street);

        Set<Intersection> intersectionSet = convertion(nodes);
        for (Intersection node : intersectionSet)
            System.out.print(node.getName()+" ");
        System.out.println();
    }
}