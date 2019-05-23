/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Nodes;

import neuralnetwork.neuralnetworkmaven.Nodes.Node;

/**
 *
 * @author alintulu
 * 
 * When initialised every edge is assigned a random weight value between [0,1].
 * In addition the target and source node get connected through the edge. 
 * 
 */

public class Edge {

    private boolean debug = false;

    public double weight;
    public Node source;
    public Node target;

    public Edge(Node source, Node target) {
        
        // assign random weight value between [0,1]
        weight = Math.random();
        this.source = source;
        this.target = target;

        /* add edge to the target and source node's list of edges 
        true if outgoing edge, false if incoming edge */
        source.addEdge(this, true);
        target.addEdge(this, false);

    }

    public String toString() {
        return "Edge between " + source.getName() + " and " + target.getName();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public void setTarget(Node target) {
        this.target = target;
    }

    public Node getSource() {
        return this.source;
    }

    public Node getTarget() {
        return this.target;
    }

    public double getWeight() {
        return this.weight;
    }

}
