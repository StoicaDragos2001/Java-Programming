import java.time.LocalTime;

/**
 * Clasa Event
 *
 * @author Petrea Daniela
 */
public class Event {
    /**
     * Atributele clasei Event
     */

    private String name;
    private Integer size;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * Constructorul pentru clasa Event
     */
    /**
     *
     * @param name
     * @param size
     * @param start_time
     * @param end_time
     */

    public Event(String name, Integer size, LocalTime start_time, LocalTime end_time) {
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

    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @param startTime timpul de inceput al evenimentului
     */

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @param endTime timpul de final al evenimentului
     */

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 4 functii getters
     */

    /**
     *
     * @return name numele evenimentului
     */

    public String getName() {
        return this.name;
    }

    /**
     *
     * @return size marimea evenimentului
     */

    public Integer getSize() {
        return this.size;
    }

    /**
     *
     * @return startTime timpul de inceput al evenimentului
     */

    public LocalTime getStartTime() {
        return this.startTime;
    }

    /**
     *
     * @return endTime timpul de final al evenimentului
     */
    public LocalTime getEndTime() {
        return this.endTime;
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
     *
     * facem @Override toString
     * deoarece suprascriem metoda toString
     */

    @Override
    public String toString() {
        return "Event{" + "name='" + name + '\'' + ", size=" + size + ", start_time=" + startTime + ", end_time=" + endTime + '}';
    }

    /**
     *
     * facem @Override equals
     * deoarece suprascriem metoda equals, care returneaza true daca 2 instante ale clasei Event au acelasi nume
     */

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Event)) {
            return false;
        }
        Event s = (Event) o;
        return this.getName().equals(s.getName()) ;
    }

}
