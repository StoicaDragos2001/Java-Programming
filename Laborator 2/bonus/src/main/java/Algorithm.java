import java.util.ArrayList;

/**
 * This class is for creating Algorithm superclass.
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public abstract class Algorithm {
    protected Problem pb;

    /**
     * Constructor for superclass Algorithm.
     *
     * @param pb Instance of Problem class.
     */
    public Algorithm(Problem pb) {
        this.pb = pb;
    }

    /**
     * Definition of solve method
     *
     * @return Object of Solution class.
     */
    public abstract Solution solve();
}
