/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Nodes;

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
public class BiasNodeTest {

    BiasNode bias;

    public BiasNodeTest() {
        bias = new BiasNode("test");
    }

    /**
     * Test of getName method, of class BiasNode.
     */
    @Test
    public void testGetName() {
        System.out.println("Testing getName..");
        assertEquals("test", bias.getName());
    }

    /**
     * Test of getOutput method, of class BiasNode.
     */
    @Test
    public void testGetOutput() {
        System.out.println("Testing getOutput..");
        double[] inputVal = null;
        assertEquals(1.0, bias.getOutput(inputVal), 0.0);
    }

    /**
     * Test of addEdge method, of class BiasNode.
     */
    @Test
    public void testAddEdge() {
        System.out.println("Testing addEdge..");
        assertEquals(0, bias.outEdges.size());
        bias.addEdge(new Edge(bias, bias), true);
        assertEquals(3, bias.outEdges.size());
    }

    /**
     * Test of getError method, of class BiasNode.
     */
    @Test
    public void testGetError() {
        System.out.println("Testing getError..");
        assertEquals(0.0, bias.getError(0, true), 0);
    }

}
