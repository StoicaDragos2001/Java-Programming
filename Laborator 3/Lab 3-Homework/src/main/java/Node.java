/**
 * Clasa Node
 * @author Petrea Daniela
 */

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    /**
     * name - numele nodului
     * cost - map format dintr-un nod, ce reprezinta nodul destinatie si un int, ce reprezinta costul drumului
     */
    private final String name;
    private final Map<Node, Integer> cost;
    /**
     *
     * @param name care este unic si identifica nodurile
     */
    public Node(String name) {
        this.name = name;
        cost = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setCost(Node nodeDestination, int value) {
        cost.put(nodeDestination, value);
    }

    public int getCostTo(Node nodeDestination) {
        if (cost.containsKey(nodeDestination))
            return cost.get(nodeDestination);
        else
            return 0;
    }

    public void displayWithCosts(Node nodeSource, Node nodeDestination) {
        if (nodeSource.getCostTo(nodeDestination) != 0)
            System.out.println(nodeSource.getName() + " -> " + nodeDestination.getName() + "; cost:" + nodeSource.getCostTo(nodeDestination));
        // else
        //     System.out.println(nodeSource.getName() + " nu are drum spre " + nodeDestination.getName());
    }

    @Override
    public String toString() {
        return "Network{" +
                "name='" + name + " " + cost + "}";
    }
    /**
     * metoda folosita pentru a face natural ordering
     * @param other alt nod
     * @return 0 daca cle 2 siruri sunt egale, >0 daca this.name>other.name
     */
    @Override
    public int compareTo(Node other) {
        if (other.name != null)
            return this.name.compareTo(other.name);
        return -1;
    }


}