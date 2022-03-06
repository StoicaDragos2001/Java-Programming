/**
 * Clasa Event
 *
 * @author Petrea Daniela
 */

public class Event {

    /**
     * Atributele clasei Event sunt
     * name
     * size
     * startTime
     * endTime
     */

    private String name;
    private int size;
    private int startTime;
    private int endTime;

    /**
     * Constructorul pentru clasa Event
     */

    public Event(String name, int size, int start_time, int end_time) {
        setName(name);
        setSize(size);
        setStartTime(start_time);
        setEndTime(end_time);
    }

    /**
     * 4 functii setters
     */

    /**
     *
     * @param name numele evenimentului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param size marimea evenimentului
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     *
     * @param startTime timpul de inceput al evenimentului
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @param endTime timpul de final al evenimentului
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    /**
     * 4 functii getters
     */

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     *
     * @return endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * o functie de print
     */

    /**
     * metoda pt a afisa numele, capacitatea, timpul de inceput si sfarsit al unei activitati
     */

    public void print() {
        System.out.println(toString());
    }

    /**
     * facem @Override toString
     * deoarece suprascriem metoda toString
     */

    @Override
    public String toString() {
        return "Event{" + "name='" + name + '\'' + ", size=" + size + ", start_time=" + startTime + ", end_time=" + endTime + '}';
    }
}
