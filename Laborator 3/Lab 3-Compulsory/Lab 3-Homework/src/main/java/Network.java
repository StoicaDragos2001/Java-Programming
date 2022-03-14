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

        Collections.sort(identifiableNodes, new AdressComparator());

        for (Node node : identifiableNodes) {
            System.out.println(node);
        }
        return identifiableNodes;
    }

    /**
     * comparam adresele nodurilor care sunt identifiable
     */
    class AdressComparator implements Comparator<Node> {
        public int compare(Node NodeA, Node NodeB) {
            String address1 = getAddress(NodeA);
            String address2 = getAddress(NodeB);
            return address1.compareTo(address2);
        }

        private String getAddress(Node node) {
            if (node instanceof Computer computer) {
                return computer.getAddress();
            }

            Router router = (Router) node;
            return router.getAddress();
        }
    }

}
