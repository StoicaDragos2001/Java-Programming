import Instances.City;
import Instances.Intersection;
import Instances.Street;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import com.github.javafaker.Faker;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Main {

    public static void main(String[] args) {
        List<Instances.Intersection> nodes = IntStream.rangeClosed(0, 8).mapToObj(i -> new Intersection("v" + i)).collect(Collectors.toList());
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
        City Galati = new City();
        for (int index = 0; index <= 8; index++) {
            List<String> streetList = new ArrayList<>();
            for (Street streetIndex : streets)
                if (streetIndex.getDestination1() == nodes.get(index) || streetIndex.getDestination2() == nodes.get(index))
                    streetList.add(streetIndex.getName());
            Galati.setStreetForIntersection(nodes.get(index), streetList);
        }
        /**
         * display the city
         */
        Galati.displayCity();
        /**
         *  a query that display all the streets that are longer than a specified value(in my case 2) and join at least 3 streets
         */
        streets.stream()
                .filter(v -> ((Galati.returnMap()).get(v.getDestination1()).size() + (Galati.returnMap()).get(v.getDestination2()).size() >= 5) && v.getLength() > 2)
                .forEach(System.out::println);
        /**
         * generate random fake names for intersections and streets
         */
        Faker faker = new Faker();
        for (Street streetIndex : streets)
            streetIndex.setName(faker.address().streetName());
        for (Intersection intersectionIndex : nodes)
            intersectionIndex.setName(faker.address().zipCode());
        for (Street street : streets)
            System.out.print(street.getName());
        System.out.println();
        for (Intersection node : nodes)
            System.out.print(node.getName() + " ");
        System.out.println();
        /**
         * using this package of JGraphT for the implementation of the Prim's algorithm
         */
        DefaultDirectedGraph<String, DefaultWeightedEdge> g = new DefaultDirectedGraph<>(DefaultWeightedEdge.class);
        for (Intersection vertex : nodes)
            g.addVertex(vertex.getName());
        for (Street street : streets)
        g.setEdgeWeight(g.addEdge(street.getDestination1().getName(), street.getDestination2().getName()),street.getLength());
        var dp = new PrimMinimumSpanningTree<>(g);
        System.out.println(dp.getSpanningTree());
    }
}
