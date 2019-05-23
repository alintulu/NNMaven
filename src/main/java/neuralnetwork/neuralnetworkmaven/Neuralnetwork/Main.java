package neuralnetwork.neuralnetworkmaven.Neuralnetwork;

import neuralnetwork.neuralnetworkmaven.Help.trainingData;
import neuralnetwork.neuralnetworkmaven.Nodes.Edge;
import neuralnetwork.neuralnetworkmaven.Nodes.InternalOrOutputNode;
import neuralnetwork.neuralnetworkmaven.Nodes.Node;
import neuralnetwork.neuralnetworkmaven.Nodes.InputNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alintulu
 */
public class Main {

    public static Network makeNetwork(int numInputs, int numHiddenLayers, int numInEachLayer) {

        // create neural network
        Network network = new Network();
        List<Node> inputNodes = new ArrayList<>();
        // create the one output node
        Node outputNode = new InternalOrOutputNode("outputNode");

        // create list of input nodes
        for (int i = 0; i < numInputs; i++) {
            inputNodes.add(new InputNode(i, "inputNode" + Integer.toString(i)));
        }

        network.setOutputNode(outputNode);
        network.setInputNodes(inputNodes);

        // create interlayer nodes
        List<List<Node>> layers = new ArrayList<>();
        List<Node> layer = null;
        // first for loop creates lists of layers
        for (int i = 0; i < numHiddenLayers; i++) {
            layer = new ArrayList<>();
            // second for loop creates list of nodes in one layer
            for (int j = 0; j < numInEachLayer; j++) {
                Node interLayerNode = new InternalOrOutputNode("interLayerNode" + Integer.toString(i) + Integer.toString(j));
                layer.add(interLayerNode);
            }
            layers.add(layer);
        }

        // create edges between input nodes and first layer nodes
        for (Node inputNode : inputNodes) {
            for (Node firstLayerNode : layers.get(0)) {
                Edge edge = new Edge(inputNode, firstLayerNode);
            }

        }

        // create edges between interlayer nodes
        // loop over all hidden layers
        for (int k = 0; k < numHiddenLayers - 1; k++) {

            // take layer k
            List<Node> layerK = layers.get(k);
            // loop over nodes in layer k
            for (Node layerKNode : layerK) {

                // take layer (k + 1)
                List<Node> layerKK = layers.get(k + 1);
                // loop over nodes in layer (k + 1)
                for (Node layerKKNode : layerKK) {

                    // create edge between node in layer k and all nodes in layer (k + 1)
                    Edge edge = new Edge(layerKNode, layerKKNode);
                }
            }

        }

        // create edge between layers in last layer and output node
        for (Node node : layers.get(numHiddenLayers - 1)) {
            Edge edge = new Edge(node, outputNode);
        }

        return network;

    }

    public static Double func(double x) {
        return 0.5 * (1.0 + Math.sin(x));
    }

    public static List<trainingData> sineTest(int numValues) {

        double[] domain = new double[numValues];

        for (int i = 0; i < numValues; i++) {
            domain[i] = Math.random() * Math.PI * 4;
        }

        List<trainingData> sineData = new ArrayList<>();

        for (int i = 0; i < numValues; i++) {
            trainingData data = new trainingData(new double[]{domain[i]}, func(domain[i]));
            sineData.add(data);
        }

        return sineData;
    }

    public static void main(String[] args) {

        Network network = makeNetwork(1, 3, 10); // numInputNodes numHiddenLayers numInEachLayer
        
        List<Double> trainingLoss = network.trainNetwork(sineTest(100), 100, 0.01, 1000, false); // trainingdata dataSetSize learningrate numIter printError
        
        for (Double tL : trainingLoss) {
            System.out.println(tL);
        }
        
        double[] testLoss = network.testNetwork(sineTest(50), 50); // trainingdata dataSetSize
        
        System.out.println("Test loss : " + testLoss[0] + "\nTest error : " + testLoss[1]);

    }

}
