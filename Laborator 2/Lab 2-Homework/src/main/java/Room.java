/**
 * Clasa Room
 *
 * @author Petrea Daniela
 */
public abstract class Room {
    /**
     * Atributele clasei Room sunt
     * name
     * capacity
     */
    protected String name;
    protected Integer capacity;

    public Room(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
    }

     /**
      * 2 functii setters
      */

    /**
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param capacity
     */

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return name
     */

    public String getName() {
        return this.name;
    }

    /**
     *
     * @return capacity
     */
    public Integer getCapacity() {
        return this.capacity;
    }

    /**
     * o functie de print
     */

    /**
     * metoda pt a afisa numele, capacitatea si tipul unei camere
     */

    public void print() {
        System.out.println(toString());
    }

    /**
     *
     * facem @Override toString
     * deoarece suprascriem metoda toString
     */

    @Override
    public String toString() {
        return "Room{" + "name='" + name + '\'' + ", capacity=" + capacity + '}';
    }

    /**
     *
     * facem @Override equals
     * deoarece suprascriem metoda equals, care returneaza true daca 2 instante ale clasei Room au acelasi nume
     */

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Room)) {
            return false;
        }
        Room s = (Room) o;
        return this.getName().equals(s.getName());
    }

}
