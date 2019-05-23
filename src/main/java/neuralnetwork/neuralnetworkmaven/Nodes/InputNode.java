/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Nodes;

import java.util.*;

/**
 *
 * @author alintulu
 *
 * Every input node has a index associated to it. The index helps the network
 * track the input node and its input value. The index indicates a certain
 * parameter. For example, input node with index 0 always has input values of
 * parameter x while input node with index 1 always has input values of
 * parameter y.
 *
 */
public class InputNode implements Node {

    private boolean debug = false;

    // index value to keep track on the input nodes
    private int index;
    // list of outgoing edges
    public List<Edge> outEdges;
    // name of input node, used during debugging
    public String name;

    public InputNode(int index, String name) 
    {
        this.index = index;
        this.outEdges = new ArrayList<>();
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    
     public Integer getIndex() 
    {
        return index;
    }

    // return value of the input corresponding to the index
    public double getOutput(double[] inputVal) 
    {
        return inputVal[index];
    }

    // add outgoing edge
    public void addEdge(Edge edge, boolean edgeType) 
    {
        outEdges.add(edge);
    }

    /* starts propagation of network to get error for every internal node 
    for the input nodes we don't care about the error, hence why the method return 0.0 */
    public double getError(double trueVal, boolean printError) 
    {
        for (Edge edge : outEdges) {

            edge.getTarget().getError(trueVal, printError);

        }
        return 0.0;
    }

    // starts backpropagation of network to update weights
    public void updateWeights(double learningRate) 
    {
        for (Edge edge : outEdges) {

            edge.getTarget().updateWeights(learningRate);
        }
    }

    // unecessary for input node since there is no output to clear but part of the interface methods
    public void clearOutput() 
    {
    }

}
