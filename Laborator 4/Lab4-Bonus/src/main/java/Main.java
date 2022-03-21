import Instances.*;
import Randomizer.RandomInstances;
import com.github.javafaker.Faker;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.ListenableUndirectedWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Main {

    public static void main(String[] args) {
        /**
         * I generate random instances
         */
        RandomInstances randomizer = new RandomInstances();
        int numberOfIntersections = randomizer.generateNumberOfIntersections();
        int numberOfStreets = randomizer.generateNumberOfStreets(numberOfIntersections);
        List<Intersection> nodes = IntStream.rangeClosed(0, numberOfIntersections - 1).mapToObj(i -> new Intersection("v" + i)).collect(Collectors.toList());
        for (Intersection node : nodes)
            System.out.print(node.getName() + " ");
        System.out.println();
        LinkedList<Street> streets = new LinkedList<>();
        Faker faker = new Faker();
        System.out.println("Number of streets " + numberOfStreets + ", number of intersections " + numberOfIntersections);
        for (int indexStreet = 0; indexStreet < numberOfStreets; indexStreet++) {
            int firstIntersection = randomizer.generateWhichNode(numberOfIntersections);
            streets.add(new Street(randomizer.generateLength(), faker.address().streetName(), nodes.get(firstIntersection), nodes.get(randomizer.generateWhichNodeDestination(firstIntersection, numberOfIntersections))));
        }

        List<Integer> indexes = new ArrayList<>();
        for (int indexStreet1 = 0; indexStreet1 < numberOfStreets - 1; indexStreet1++) {
            for (int indexStreet2 = indexStreet1 + 1; indexStreet2 < numberOfStreets; indexStreet2++) {
                if (streets.get(indexStreet1).getDestination1().equals(streets.get(indexStreet2).getDestination1()) && streets.get(indexStreet2).getDestination2().equals(streets.get(indexStreet1).getDestination2())) {
                    if (!(indexes.contains(indexStreet2)))
                        indexes.add(indexStreet2);
                }
            }
        }

        for (Street street : streets) {
            System.out.println(street);
        }
        Collections.sort(indexes);
        /**
         * I remove the streets that have the same intersection 1 and the same intersection 2
         */
        int nr = 0;
        for (Integer index : indexes) {
            streets.remove(index - nr);
            nr++;
        }
        numberOfStreets = streets.size();
        System.out.println("--------------------");
        for (Street street : streets) {
            System.out.println(street);
        }

        /**
         * using this package of JGraphT for the implementation of the Prim's algorithm
         */
        ListenableUndirectedWeightedGraph<String, DefaultWeightedEdge> g = new ListenableUndirectedWeightedGraph<>(DefaultWeightedEdge.class);
        for (Intersection vertex : nodes)
            g.addVertex(vertex.getName());
        for (Street street : streets) {
            System.out.println(street.getLength() + " " + street.getDestination1().getName() + " " + street.getDestination2().getName());
            g.setEdgeWeight(g.addEdge(street.getDestination1().getName(), street.getDestination2().getName()), street.getLength());
        }
        for (int indexIntersection1 = 0; indexIntersection1 < numberOfIntersections - 2; indexIntersection1++) {
            for (int indexIntersection2 = indexIntersection1 + 1; indexIntersection2 < numberOfIntersections - 1; indexIntersection2++) {
                for (int indexIntersection3 = indexIntersection2 + 1; indexIntersection3 < numberOfIntersections; indexIntersection3++) {
                    if (g.containsEdge(nodes.get(indexIntersection1).getName(), nodes.get(indexIntersection2).getName()) && (g.containsEdge(nodes.get(indexIntersection2).getName(), nodes.get(indexIntersection3).getName()) && (g.containsEdge(nodes.get(indexIntersection1).getName(), nodes.get(indexIntersection3).getName())))) {
                        var edge1 = g.getEdge(nodes.get(indexIntersection1).getName(), nodes.get(indexIntersection2).getName());
                        var edge2 = g.getEdge(nodes.get(indexIntersection2).getName(), nodes.get(indexIntersection3).getName());
                        var edge3 = g.getEdge(nodes.get(indexIntersection1).getName(), nodes.get(indexIntersection3).getName());
                        System.out.println(edge1 + " " + edge2 + " " + edge3);
                        double lengthEdge1 = g.getEdgeWeight(edge1);
                        double lengthEdge2 = g.getEdgeWeight(edge2);
                        double lengthEdge3 = g.getEdgeWeight(edge3);
                        if (lengthEdge1 + lengthEdge2 > lengthEdge3 && lengthEdge1 + lengthEdge3 > lengthEdge2 && lengthEdge2 + lengthEdge3 > lengthEdge1)
                            System.out.println("triangle");
                        else {
                            double biggest = (lengthEdge1 > lengthEdge2) ? (Math.max(lengthEdge1, lengthEdge3)) : (Math.max(lengthEdge2, lengthEdge3));
                            if (biggest == lengthEdge1)
                                g.setEdgeWeight(edge1, lengthEdge2 + lengthEdge3 - 1);
                            else if (biggest == lengthEdge2)
                                g.setEdgeWeight(edge2, lengthEdge1 + lengthEdge3 - 1);
                            else if (biggest == lengthEdge3)
                                g.setEdgeWeight(edge3, lengthEdge1 + lengthEdge2 - 1);
                        }
                    }
                }
            }
        }
        var minimumSpanningTree = new PrimMinimumSpanningTree<>(g);
        System.out.println(minimumSpanningTree.getSpanningTree());
        /**
         * I convert the Prim Minimum Spanning Tree into a graph s.t. after I can apply DFS
         */
        ListenableUndirectedWeightedGraph<String, DefaultWeightedEdge> g2 = new ListenableUndirectedWeightedGraph<>(DefaultWeightedEdge.class);
        var graph = minimumSpanningTree.getSpanningTree().getEdges();
        for (Intersection vertex : nodes)
            g2.addVertex(vertex.getName());
        System.out.println(graph);
        for (DefaultWeightedEdge value : graph) {
            g2.setEdgeWeight(g2.addEdge(g.getEdgeSource(value), g.getEdgeTarget(value)), g.getEdgeWeight(value));
            System.out.println(g.getEdgeSource(value) + " " + g.getEdgeTarget(value) + " " + g.getEdgeWeight(value));
        }
        System.out.println(g2);
        /**
         * using this package of JGraphT for the implementation of the DFS algorithm
         */
        System.out.print("The route is ");
        var dfs = new DepthFirstIterator<>(g2);
        while (dfs.hasNext()) {
            System.out.print(dfs.next() + " ");
        }
        System.out.println();

    }
}
