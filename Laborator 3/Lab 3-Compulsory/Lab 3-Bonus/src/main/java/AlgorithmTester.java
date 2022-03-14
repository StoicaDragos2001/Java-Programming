import org.junit.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * testam algoritmul din clasa MinimizeFailureAlgorithm si anume metoda reability care returneaza
 * sansa de reusita a unei rute dintre 2 noduri al caror index este dat de la tastatura
 * algoritmul ar trebui sa returneze 0, daca indexul nodului sursa este egal cu indexul nodului destinatie
 */
class AlgorithmTester {
    @Test
    void tester(List<Node>nodes){
        MinimizeFailureAlgorithm alg=new MinimizeFailureAlgorithm();
        assertEquals(0,alg.reability(nodes,0,0));
    }
}
