/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Nodes;

import neuralnetwork.neuralnetworkmaven.Nodes.Edge;
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
public class InputNodeTest {

    InputNode input;

    public InputNodeTest() {
        input = new InputNode(0, "test");
    }
    /**
     * Test of getName method, of class InputNode.
     */
    @Test
    public void testGetName() {
        System.out.println("Testing getName..");
        assertEquals("test", input.getName());
    }

    /**
     * Test of getIndex method, of class InputNode.
     */
    @Test
    public void testGetIndex() {
        System.out.println("Testing getIndex..");
        assertEquals(0, input.getIndex(), 0.0);
    }

    /**
     * Test of getOutput method, of class InputNode.
     */
    @Test
    public void testGetOutput() {
        System.out.println("Testin getOutput..");
        double[] inputVal = {1, 2, 3};
        double expResult = inputVal[input.getIndex()];
        assertEquals(expResult, input.getOutput(inputVal), 0.0);
    }

    /**
     * Test of addEdge method, of class InputNode.
     */
    @Test
    public void testAddEdge() {
        System.out.println("Testin addEdge..");
        assertEquals(0, input.outEdges.size());
        input.addEdge(new Edge(input, input), true);
        assertEquals(3, input.outEdges.size());
    }

    /**
     * Test of getError method, of class InputNode.
     */
    @Test
    public void testGetError() {
        System.out.println("Testin getError..");
        assertEquals(0.0, input.getError(0, false), 0.0);
    }

}
