import java.util.Comparator;

/**
 * comparam adresele nodurilor care sunt identifiable
 */

public class AddressComparator implements Comparator<Node> {

    @Override
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
