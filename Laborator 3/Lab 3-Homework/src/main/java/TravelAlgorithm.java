import java.util.List;

public class TravelAlgorithm {
    /**
     *
     * @param dist array de tip double in care stocam distantele
     * @param sequence array de tip boolean in care stocam daca am calculat path-ul minim pt acel nod (rerezentat prin index)
     * @return min_index, ce reprezinta indexul urmatorului nod pt care vom calcula distanta
     */
    int minDistance(int dist[], Boolean sequence[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < dist.length; v++)
            if (sequence[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    /**
     *
     * @param matrix matricea reprezentativa a grafului
     * @param src nodul sursa
     */
    void dijkstra(int matrix[][], int src) {
        int dist[] = new int[matrix.length];
        Boolean sequence[] = new Boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            sequence[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < matrix.length - 1; count++) {
            int u = minDistance(dist, sequence);
            sequence[u] = true;
            for (int v = 0; v < matrix.length; v++)
                if (!sequence[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + matrix[u][v] < dist[v])
                    dist[v] = dist[u] + matrix[u][v];
        }
        for (int i = 0; i < matrix.length; i++)
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("There is no path from source node " + src + " to node " + i);
            else
                System.out.println("Distance from the source node " + src + " to node " + i + " is " + dist[i]);
    }
    /**
     * metoda prin care cream matricea reprezentativa a grafului
     * @param nodes lista cu nodurile
     */
    void createMatrix(List<Node> nodes) {
        int[][] mat = new int[nodes.size()][nodes.size()];
        for (int nodei = 0; nodei < nodes.size(); nodei++) {
            for (int nodej = 0; nodej < nodes.size(); nodej++) {
                mat[nodei][nodej] = nodes.get(nodei).getCostTo(nodes.get(nodej));
            }
        }
        for (int nodei = 0; nodei < nodes.size(); nodei++) {
            dijkstra(mat, nodei);
        }
    }
}