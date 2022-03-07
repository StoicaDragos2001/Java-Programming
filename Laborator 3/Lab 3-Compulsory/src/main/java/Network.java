import java.util.ArrayList;
import java.util.List;

/**
 * Clasa Network
 * @author Petrea Daniela
 */
public class Network {
    private List<Node> nodes = new ArrayList<>();

    Network(List<Node> nodes){
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}