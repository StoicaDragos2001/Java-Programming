/**
 * @author Petrea Daniela
 * clasa Network
 */

import java.util.ArrayList;
import java.util.List;
/**
 * o retea este formata din mai multe noduri si de aceea in clasa network avem o lista de noduri Node
 */
public class Network {
    private List<Node> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    protected List<Node> getNodes() {
        return nodes;
    }

}
