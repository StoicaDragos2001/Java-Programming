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
     * failure - map format dintr-un nod, ce reprezinta nodul destinatie si un double, ce reprezinta rata de esec a drumului
     */
    private final String name;
    private final Map<Node, Integer> cost;
    private final Map<Node, Double> failure;

    /**
     *
     * @param name care este unic si identifica nodurile
     */
    public Node(String name) {
        this.name = name;
        cost = new HashMap<>();
        failure = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    /**
     * metoda de a seta costul drumului (de la nodul care apeleaza metoda) spre nodul destinatie cu costul value
     * @param nodeDestination nodul destinatie
     * @param value costul drumului
     */
    public void setCost(Node nodeDestination, int value) {
        cost.put(nodeDestination, value);
    }

    /**
     * verificam prima daca map-ul de cost contine drept cheie nodul destinatie
     * @param nodeDestination nodul destinatie
     * @return costul drumului ( e 0 daca nu exista drum de la nodul care apeleaza metoda la nodul destinatie)
     */
    public int getCostTo(Node nodeDestination) {
        if (cost.containsKey(nodeDestination))
            return cost.get(nodeDestination);
        else
            return 0;
    }

    /**
     * afiseaza drumurile si costul acestora
     * @param nodeSource nodul sursa
     * @param nodeDestination nodul destinatie
     */
    public void displayWithCosts(Node nodeSource, Node nodeDestination) {
        if (nodeSource.getCostTo(nodeDestination) != 0)
            System.out.println(nodeSource.getName() + " -> " + nodeDestination.getName() + "; cost:" + nodeSource.getCostTo(nodeDestination));
        // else
        //     System.out.println(nodeSource.getName() + " nu are drum spre " + nodeDestination.getName());
    }
    /**
     * metoda de a seta rata de esec a drumului (de la nodul care apeleaza metoda) spre nodul destinatie cu sansa de esec chance
     * @param nodeDestination nodul destinatie
     * @param chance sansa de esec
     */
    public void setFailure(Node nodeDestination, Double chance) {
        failure.put(nodeDestination, chance);
    }

    public Double getFailureTo(Node nodeDestination) {
        if (failure.containsKey(nodeDestination))
            return failure.get(nodeDestination);
        else
            return 1.0;
    }
    /**
     * afiseaza drumurile si sansa de esec
     * @param nodeSource nodul sursa
     * @param nodeDestination nodul destinatie
     */
    public void displayWithFailure(Node nodeSource, Node nodeDestination) {
        if (nodeSource.getFailureTo(nodeDestination) != 1.0f)
            System.out.println(nodeSource.getName() + " -> " + nodeDestination.getName() + "; chance of failure:" + nodeSource.getFailureTo(nodeDestination));
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