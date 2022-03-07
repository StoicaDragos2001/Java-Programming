/**
 * Clasa Node
 * @author Petrea Daniela
 */

public abstract class Node implements Comparable<Node> {
    public String name;

    /**
     * construcorul clasei Node
     * @param name
     */
    Node(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Node{" +
                "name='" + name +
        '}';
    }

    @Override
    public int compareTo(Node other) {
        if(other.name != null)
            return this.name.compareTo(other.name);
        return -1;
    }

}
