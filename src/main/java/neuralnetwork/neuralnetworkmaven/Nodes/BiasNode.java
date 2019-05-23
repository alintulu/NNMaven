package neuralnetwork.neuralnetworkmaven.Nodes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alintulu
 * 
 * The bias is used to translate the separating hyperplane so that the 
 * function doesn't need to pass through the origin. 
 * The bias node is added to every non-input node and has a default output value
 * of 1.0. This way when the method getOutput() is called the bias node will
 * contribute with the value edge.weight * 1.0, i.e. the weight of the edge between
 * the non-input node and its associated bias node. This way the network does not
 * need a separate method to update the bias value, the value is automatically
 * updated when the method updateWeights() is called.
 * 
 */
public class BiasNode implements Node {

    private boolean debug = false;

    // list of outgoing edges
    public List<Edge> outEdges;
    // name of bias node, used during debugging
    public String name;

    public BiasNode(String name) 
    {
        this.outEdges = new ArrayList<>();
        this.name = name;
    }

    public String getName() 
    {
        return this.name;
    }

    // always return 1.0
    public double getOutput(double[] inputVal) 
    {
        return 1.0;
    }

    // add outgoing edge
    public void addEdge(Edge edge, boolean edgeType) 
    {
        this.outEdges.add(edge);
    }

    /*
    The three following methods are unecessary since they are never called for bias nodes,
    however I need them present to be able to implement the Node interface
    */
   
    public double getError(double trueVal, boolean printError) {
        return 0.0;
    }

   
    public void updateWeights(double learningRate) {
    }

    
    public void clearOutput() {
    }

}
