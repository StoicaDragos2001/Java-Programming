/**
 * @author Petrea Daniela
 * clasa Network
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    /**
     *
     * @return nodurile care sunt identificabile si pe care le-am sortat
     */
    public List<Node> showIdentifiableNodes() {

        List<Node> identifiableNodes = new ArrayList<>();

        for (Node node : nodes) {
            if (node instanceof Identifiable) {
                identifiableNodes.add(node);
            }
        }

        Collections.sort(identifiableNodes, new AddressComparator());

        for (Node node : identifiableNodes) {
            System.out.println(node);
        }
        return identifiableNodes;
    }

}
