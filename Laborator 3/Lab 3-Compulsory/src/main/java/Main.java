import java.util.*;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        List<Node> nodes = new ArrayList<>();
        network.addNode(new Computer("v1", "127.089.23.13", 450));
        network.addNode(new Router("v2", "134.56.890.143"));
        network.addNode(new Switch("v3"));
        network.addNode(new Switch("v4"));
        network.addNode(new Router("v5", "876.894.562.113"));
        network.addNode(new Computer("v6", "194.110.890.760", 900));
        for (int indexNode = 0; indexNode < network.getNodes().size(); indexNode++) {
            nodes.add(network.getNodes().get(indexNode));
        }
        nodes.get(0).setCost(nodes.get(1), 10);
        nodes.get(0).setCost(nodes.get(2), 50);
        nodes.get(1).setCost(nodes.get(2), 20);
        nodes.get(1).setCost(nodes.get(3), 20);
        nodes.get(1).setCost(nodes.get(4), 20);
        nodes.get(2).setCost(nodes.get(3), 10);
        nodes.get(3).setCost(nodes.get(4), 30);
        nodes.get(3).setCost(nodes.get(5), 10);
        nodes.get(4).setCost(nodes.get(5), 20);
        System.out.println(network.getNodes());
        for (int index1 = 0; index1 < nodes.size(); index1++) {
            for (int index2 = 0; index2 < nodes.size(); index2++) {
                nodes.get(index1).displayWithoutCosts(nodes.get(index1), nodes.get(index2));
            }
        }
        System.out.println("Before sorting: ");
        for (Node nod : nodes) {
            System.out.println(nod);
        }
        Collections.sort(nodes);
        System.out.println("After sorting: ");
        for (Node nod : nodes) {
            System.out.println(nod);
        }
    }
}

