import java.util.*;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        List<Node> nodes = new ArrayList<>();
        Randomizer randomizer = new Randomizer();
        int numberOfNodes = randomizer.generateNumberOfInstances();
        for (int instance = 0; instance < numberOfNodes; instance++) {
            if (randomizer.generateWhichInstance() == 0)
                network.addNode(new Computer(randomizer.generateNodeName(), randomizer.generateIpAdress(), randomizer.generateStorageCapacity()));
            else if (randomizer.generateWhichInstance() == 1)
                network.addNode(new Router(randomizer.generateNodeName(), randomizer.generateIpAdress()));
            else
                network.addNode(new Switch(randomizer.generateNodeName()));

        }
        for (int indexNode = 0; indexNode < network.getNodes().size(); indexNode++) {
            nodes.add(network.getNodes().get(indexNode));
        }
        for (int instance = 0; instance < numberOfNodes; instance++) {
            int nr = randomizer.generateWhichNode(numberOfNodes);
          nodes.get(nr).setCost(nodes.get(randomizer.generateWhichNodeDestination(nr, numberOfNodes)), randomizer.generateCost());
          nodes.get(nr).setFailure(nodes.get(randomizer.generateWhichNodeDestination(nr, numberOfNodes)), randomizer.generateFailure());
        }
        for (int index1 = 0; index1 < nodes.size(); index1++) {
            for (int index2 = 0; index2 < nodes.size(); index2++) {
                nodes.get(index1).displayWithCosts(nodes.get(index1), nodes.get(index2));
                nodes.get(index1).displayWithFailure(nodes.get(index1), nodes.get(index2));
            }
        }
        MinimizeFailureAlgorithm algorithm = new MinimizeFailureAlgorithm();
        algorithm.createMatrix(nodes, 1, 5);
        AlgorithmTester algorithm2=new AlgorithmTester();
        algorithm2.tester(nodes);
    }
}

