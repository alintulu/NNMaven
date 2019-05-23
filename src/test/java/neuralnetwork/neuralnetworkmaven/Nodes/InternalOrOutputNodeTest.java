/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Nodes;

import neuralnetwork.neuralnetworkmaven.Nodes.Edge;
import neuralnetwork.neuralnetworkmaven.Nodes.InternalOrOutputNode;
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
public class InternalOrOutputNodeTest {

    InternalOrOutputNode node;

    public InternalOrOutputNodeTest() {
        node = new InternalOrOutputNode("test");
    }

    /**
     * Test of getName method, of class InternalOrOutputNode.
     */
    @Test
    public void testGetName() {
        System.out.println("Testing getName..");
        assertEquals("test", node.getName());
    }

    /**
     * Test of weightFunc method, of class InternalOrOutputNode.
     */
    @Test
    public void testWeightFunc() {
        System.out.println("Testing weightFunc..");
        double learningRate = 0.0;
        double output = 0.0;
        double error = 0.0;
        double input = 0.0;
        double result = node.weightFunc(learningRate, output, error, input);
        assertEquals(0.0, result, 0.0);
    }

    /**
     * Test of getOutput method, of class InternalOrOutputNode.
     */
    @Test
    public void testGetOutput() {
        System.out.println("Testing getOutput..");
        node.output = 0.5;
        assertEquals(0.5, node.getOutput(null), 0.0);
    }

    /**
     * Test of addBias method, of class InternalOrOutputNode.
     */
    @Test
    public void testAddBias() {
        System.out.println("Testing addBias..");
        assertEquals(1, node.inEdges.size(), 0.0);
        node.addBias();
        assertEquals(2, node.inEdges.size(), 0.0);
    }

    /**
     * Test of addEdge method, of class InternalOrOutputNode.
     */
    @Test
    public void testAddEdge() {
        System.out.println("Testing addEdge..");
        assertEquals(0, node.outEdges.size(), 0.0);
        node.addEdge(new Edge(node, new InternalOrOutputNode("temp")), true);
        assertEquals(2, node.outEdges.size(), 0.0);
    }

    /**
     * Test of getError method, of class InternalOrOutputNode.
     */
    @Test
    public void testGetError() {
        System.out.println("getError");
        node.error = 0.5;
        assertEquals(0.5, node.getError(0.0, true), 0.0);
    }

    /**
     * Test of updateWeights method, of class InternalOrOutputNode.
     */
    @Test
    public void testUpdateWeights() {
        System.out.println("Testing updateWeights..");
        assertEquals(node.error, null);
        assertEquals(node.input, null);
        assertEquals(node.output, null);
    }

    /**
     * Test of clearOutput method, of class InternalOrOutputNode.
     */
    @Test
    public void testClearOutput() {
        System.out.println("Testing clearOutput..");
        node.clearOutput();
        assertEquals(null, node.output);
    }

}
