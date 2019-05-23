package neuralnetwork.neuralnetworkmaven.Nodes;

import neuralnetwork.neuralnetworkmaven.Nodes.Node;
import neuralnetwork.neuralnetworkmaven.Nodes.BiasNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alintulu
 *
 * This class represents the interal nodes as well as the output node. They are
 * represented by the same class since their methods differ very little/not at
 * all. When initialised a bias node is automatically connected with an edge.
 *
 * Methods in this class (in addition to interface) is - weightFunc(), method
 * for updating weights - actFunc(), activation function for output - addBias(),
 * method to add a bias node
 */
public class InternalOrOutputNode implements Node {

    // building network debug
    private boolean debug = false;

    /* list of most recent input values. Every internal node has at least two input values,
    the output of the ancestor node as well as output of the bias node associated to this node.
    These are used when updating weights for every incoming edge
     */
    public List<Double> input;
    // most recent output of this node
    public Double output;
    // most recenet error for this node
    public Double error;
    // list of incoming edges
    public List<Edge> inEdges;
    // list of outgoing edges
    public List<Edge> outEdges;
    // name of non-input node, used during debugging
    public String name;

    public InternalOrOutputNode(String name) {
        this.input = null;
        this.output = null;
        this.error = null;
        this.inEdges = new ArrayList<>();
        this.outEdges = new ArrayList<>();
        this.name = name;

        this.addBias();
    }

    public String getName() 
    {
        return this.name;
    }

    // update weights function
    public double weightFunc(double learningRate, double output, double error, double input) 
    {
        return learningRate * output * (1 - output) * error * input;
    }

    // activation function, the sigmoid curve
    private Double actFunc(double weightedSum) 
    {
        return 1.0 / (1.0 + Math.exp(-1.0 * weightedSum));
    }

    // return output of this node, inputVal is this iterations input values
    public double getOutput(double[] inputVal) 
    {
        // if we just calculated the output return it, otherwise calculate it
        if (this.output != null) 
        {
            return this.output;
        }

        // create new list of input values
        this.input = new ArrayList<>();
        
        /* weightedSum is the sum of all the weghts of the incoming edges times
        the output of the source node of that edge */
        double weightedSum = 0.0;

        // for each incoming edge calculate the sum of the product between the input to the node times the weight of the incoming edge
        for (Edge edge : this.inEdges) {

            double theInput = edge.getSource().getOutput(inputVal);

            // add input values to list of inputs to use later when calling method updateWeights()
            this.input.add(theInput);
            weightedSum += edge.getWeight() * theInput;
        }

        // calculate new output
        this.output = actFunc(weightedSum);

        return this.output;
    }

    // add bias node
    public void addBias() 
    {
        Edge edge = new Edge(new BiasNode("BiasNode-" + this.name), this);
    }

    // add edge between nodes, edgeType tells you if it is a outgoing or incoming edge
    public void addEdge(Edge edge, boolean edgeType) 
    {
        if (edgeType) {
            // outgoing edge
            this.outEdges.add(edge);
        } else {
            // incoming edge
            this.inEdges.add(edge);
        }

    }

    // return error of this node
    public double getError(double trueVal, boolean printError) 
    {
        // if we just calculated the error, return it, otherwise calculate it
        if (this.error != null) 
        {
            return this.error;
        } 
        else 
        {
            // if this node is an output node, error is caluclated through trueVal (= the correct value of the output)
            if (this.outEdges.size() == 0) 
            {
                this.error = trueVal - this.output;
            } 
            else 
            {
                // otherwise backpropagate to find the error
                for (Edge edge : outEdges) 
                {
                    // not the nicest way but necessary conversion
                    if (this.error == null) 
                    {
                        this.error = 0.0;
                        this.error += edge.getWeight() * edge.getTarget().getError(trueVal, printError);

                    } else {
                        this.error += edge.getWeight() * edge.getTarget().getError(trueVal, printError);

                    }
                }
            }
        }
        return this.error;
    }

    /* update all the weights and when done make error, input and output equel null,
    this way the network can keep track on which weights have already been updated
    */
    public void updateWeights(double learningRate) 
    {

        // if input, output and error is null, we have already updated the weights for this edge
        if (this.input != null && this.output != null && this.error != null) 
        {

            // loop over incoming edges and update weights
            for (int i = 0; i < inEdges.size(); i++) 
            {
                double temp = inEdges.get(i).getWeight();
                temp += weightFunc(learningRate, this.output, this.error, this.input.get(i));

                this.inEdges.get(i).setWeight(temp);
            }

            // loop over outgoing edges and start update
            for (int i = 0; i < outEdges.size(); i++) 
            {
                this.outEdges.get(i).getTarget().updateWeights(learningRate);
            }

            this.error = null;
            this.input = null;
            this.output = null;

        }

    }

    // clear the output of all nodes before we calculate new outputs
    public void clearOutput() 
    {
        if (this.output != null) {

            this.output = null;
            
            // loop over incoming edges
            for (Edge edge : this.inEdges) 
            {
                edge.getSource().clearOutput();
            }

        }

    }

}
