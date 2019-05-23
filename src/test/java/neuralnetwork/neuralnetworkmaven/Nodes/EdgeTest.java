/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Nodes;

import neuralnetwork.neuralnetworkmaven.Nodes.Edge;
import neuralnetwork.neuralnetworkmaven.Nodes.InternalOrOutputNode;
import neuralnetwork.neuralnetworkmaven.Nodes.Node;
import neuralnetwork.neuralnetworkmaven.Nodes.InputNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alintulu
 */
public class EdgeTest {

    Edge edge;
    Node input;
    Node output;

    public EdgeTest() {
        input = new InputNode(0, "in");
        output = new InternalOrOutputNode("out");
        edge = new Edge(input, output);
    }

    /**
     * Test of setWeight method, of class Edge.
     */
    @Test
    public void testSetWeight() {
        System.out.println("Testing setWeight..");
        double weight = 0.0;
        edge.setWeight(weight);
        assertEquals(0.0, edge.weight, 0);
    }

    /**
     * Test of setSource method, of class Edge.
     */
    @Test
    public void testSetSource() {
        System.out.println("Testing setSource..");
        Node source = new InputNode(1, "test");
        edge.setSource(source);
        assertEquals("test", edge.source.getName());
    }

    /**
     * Test of setTarget method, of class Edge.
     */
    @Test
    public void testSetTarget() {
        System.out.println("Testing setTarget..");
        Node target = new InternalOrOutputNode("test");
        edge.setTarget(target);
        assertEquals("test", edge.target.getName());
    }

    /**
     * Test of getSource method, of class Edge.
     */
    @Test
    public void testGetSource() {
        System.out.println("Testing getSource..");
        edge.setSource(new InputNode(1, "test"));
        assertEquals("test", edge.getSource().getName());
    }

    /**
     * Test of getTarget method, of class Edge.
     */
    @Test
    public void testGetTarget() {
        System.out.println("Testin getTarget..");
        edge.setTarget(new InternalOrOutputNode("test"));
        assertEquals("test", edge.getTarget().getName());
    }

    /**
     * Test of getWeight method, of class Edge.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        edge.setWeight(0.5);
        assertEquals(0.5, edge.getWeight(), 0);
    }

}
