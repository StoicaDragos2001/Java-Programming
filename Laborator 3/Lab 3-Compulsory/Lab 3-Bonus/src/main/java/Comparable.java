/**
 * @author Petrea Daniela
 * interfata Comparable
 */

/**
 *
 * @param <Node> este de tip nod si folosim metoda compareTo pt natural ordering
 */
public interface Comparable<Node> extends java.lang.Comparable<Node>{
    int compareTo(Node object);
}