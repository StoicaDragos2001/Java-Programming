package instances;

/**
 * Class Street
 * @author Petrea Daniela
 */
public class Street implements Comparable<Street> {
    private Integer length;
    private String name;
    private Intersection destination1, destination2;
    public Street(Integer length, String name, Intersection destination1, Intersection destination2){
        this.length = length;
        this.name = name;
        this.destination1 = destination1;
        this.destination2 = destination2;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intersection getDestination1() {
        return destination1;
    }

    public void setDestination1(Intersection destination1) {
        this.destination1 = destination1;
    }

    public Intersection getDestination2() {
        return destination2;
    }

    public void setDestination2(Intersection destination2) {
        this.destination2 = destination2;
    }
    /**
     * I do overwrite toString s.t
     * @return street with the length, the name, the first intersection and the second intersection
     */
    @Override
    public String toString() {
        return "Street{" +
                "length=" + length +
                ", name=" + name + ", destination1=" + destination1.getName() +
                ", destination2=" + destination2.getName() +
                '}';
    }
    /**
     * I do overwrite compareTo s.t. I can order streets according to their length
     * @param other of the type street
     * @return this.length.compareTo(other.length)
     */
    @Override
    public int compareTo(Street other) {
        if(other.length != 0)
            return this.length.compareTo(other.length);
        System.exit(-1);
        return -1;
    }
}