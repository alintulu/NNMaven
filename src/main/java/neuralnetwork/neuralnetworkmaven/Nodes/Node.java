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
 */
public interface Node {
   
    // return name of node
    public String getName();
    
    // return output of node
    public double getOutput(double[] inputVal);
    
    // add edge to node
    public void addEdge(Edge edge, boolean edgeType);

    // get error of node
    public double getError(double trueVal, boolean printError);

    // update weights of incoming edges
    public void updateWeights(double learningRate);
    
    // clear output of node
    public void clearOutput();
    
}
