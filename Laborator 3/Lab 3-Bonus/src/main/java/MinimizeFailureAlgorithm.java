/**
 * Clasa MinimizeFailureAlgorithm
 * author Petrea Daniela
 */

import java.util.List;
import java.lang.Math;

public class MinimizeFailureAlgorithm {
    /**
     *
     * @param dist array de tip double in care stocam distantele
     * @param sequence array de tip boolean in care stocam daca am calculat path-ul minim pt acel nod (rerezentat prin index)
     * @return min_index, ce reprezinta indexul urmatorului nod pt care vom calcula distanta
     */
    double minDistance(double dist[], Boolean sequence[]) {
        double min = Double.MAX_VALUE, min_index = -1;
        for (int indexNode = 0; indexNode < dist.length; indexNode++)
            if (sequence[indexNode] == false && dist[indexNode] <= min) {
                min = dist[indexNode];
                min_index = indexNode;
            }
        return min_index;
    }

    /**
     * metoda recursiva pt a afisa si drumul( adica indexul nodurilor prin care trece)
     * @param parent vector care intial este intializat cu -1
     * @param j indexul nodului
     */
    void printPath(int parent[], int j) {
        if (parent[j] == -1) {           // in cazul in care j este indexul nodului sursa
            System.out.print(j + " ");
            return;
        }
        printPath(parent, parent[j]);
        System.out.print(j + " ");
    }
    /**
     *
     * @param matrix matricea reprezentativa a grafului
     * @param src nodul sursa
     */
    void dijkstra(double matrix[][], int src, int destination) {
        double dist[] = new double[matrix.length];
        Boolean sequence[] = new Boolean[matrix.length];
        int parent[] = new int[matrix.length];
        for (int initialization = 0; initialization < matrix.length; initialization++) {
            parent[0] = -1;
            dist[initialization] = Double.MAX_VALUE;
            sequence[initialization] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < matrix.length - 1; count++) {
            double distance = minDistance(dist, sequence);
            sequence[(int) distance] = true;
            for (int nodeIndex = 0; nodeIndex < matrix.length; nodeIndex++)
                if (!sequence[nodeIndex] && matrix[(int) distance][nodeIndex] != 0 && dist[(int) distance] != Integer.MAX_VALUE && dist[(int) distance] + matrix[(int) distance][nodeIndex] < dist[nodeIndex]) {
                    parent[nodeIndex] = (int) distance;
                    dist[nodeIndex] = dist[(int) distance] + matrix[(int) distance][nodeIndex];
                }
        }
        if (dist[destination] == Double.MAX_VALUE)
            System.out.println("There is no path from source node " + src + " to node " + destination);
        else {
            System.out.print("Reliability from the source " + src + " to node " + destination + " is " + dist[destination] + " and the path is ");
            printPath(parent, destination);
            System.out.println();
        }
    }

    /**
     * metoda prin care cream matricea reprezentativa a grafului
     * @param nodes lista cu nodurile
     * @param indexA nodul sursa
     * @param indexB nodul destinatie
     */
    void createMatrix(List<Node> nodes, int indexA, int indexB) {
        double[][] matrix = new double[nodes.size()][nodes.size()];
        for (int nodei = 0; nodei < nodes.size(); nodei++) {
            for (int nodej = 0; nodej < nodes.size(); nodej++) {
                if (nodes.get(nodei).getFailureTo(nodes.get(nodej)) == 1.0) {
                    matrix[nodei][nodej] = 0.0;
                } else if (nodes.get(nodei).getFailureTo(nodes.get(nodej)) < 1.0 && nodes.get(nodei).getFailureTo(nodes.get(nodej)) > 0.0) {
                    matrix[nodei][nodej] = -Math.log(1 - nodes.get(nodei).getFailureTo(nodes.get(nodej)));
                } else if (nodes.get(nodei).getFailureTo(nodes.get(nodej)) > 1.0 || nodes.get(nodei).getFailureTo(nodes.get(nodej)) < 0.0) {
                    System.out.println("Error: the rate of failure must be a number between 0 and 1");
                }
            }
        }
        System.out.println("Matrix of the given graph is ");
        for (int nodei = 0; nodei < nodes.size(); nodei++) {
            for (int nodej = 0; nodej < nodes.size(); nodej++) {
                System.out.print(matrix[nodei][nodej] + " ");
            }
            System.out.println();
        }
        dijkstra(matrix, indexA, indexB);
    }

    /**
     *
     * @param nodes lista cu nodurile
     * @param src nodul sursa
     * @param destination nodul destinatie
     * @return reability of the path from src to destination
     */
    double reability(List<Node> nodes, int src, int destination) {
        double[][] matrix = new double[nodes.size()][nodes.size()];
        for (int nodei = 0; nodei < nodes.size(); nodei++) {
            for (int nodej = 0; nodej < nodes.size(); nodej++) {
                if (nodes.get(nodei).getFailureTo(nodes.get(nodej)) == 1.0) {
                    matrix[nodei][nodej] = 0.0;
                } else if (nodes.get(nodei).getFailureTo(nodes.get(nodej)) < 1.0 && nodes.get(nodei).getFailureTo(nodes.get(nodej)) > 0.0) {
                    matrix[nodei][nodej] = -Math.log(1 - nodes.get(nodei).getFailureTo(nodes.get(nodej)));
                } else if (nodes.get(nodei).getFailureTo(nodes.get(nodej)) > 1.0 || nodes.get(nodei).getFailureTo(nodes.get(nodej)) < 0.0) {
                    System.out.println("Error: the rate of failure must be a number between 0 and 1");
                }
            }
        }
        double dist[] = new double[matrix.length];
        Boolean sequence[] = new Boolean[matrix.length];
        int parent[] = new int[matrix.length];
        for (int initialization = 0; initialization < matrix.length; initialization++) {
            parent[0] = -1;
            dist[initialization] = Double.MAX_VALUE;
            sequence[initialization] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < matrix.length - 1; count++) {
            double distance = minDistance(dist, sequence);
            sequence[(int) distance] = true;
            for (int nodeIndex = 0; nodeIndex < matrix.length; nodeIndex++)
                if (!sequence[nodeIndex] && matrix[(int) distance][nodeIndex] != 0 && dist[(int) distance] != Integer.MAX_VALUE && dist[(int) distance] + matrix[(int) distance][nodeIndex] < dist[nodeIndex]) {
                    parent[nodeIndex] = (int) distance;
                    dist[nodeIndex] = dist[(int) distance] + matrix[(int) distance][nodeIndex];
                }
        }
        if (dist[destination] == Double.MAX_VALUE)
            return 0;
        else
            return dist[destination];

    }

}