/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Neuralnetwork;

import java.util.ArrayList;
import java.util.List;
import neuralnetwork.neuralnetworkmaven.Help.trainingData;
import neuralnetwork.neuralnetworkmaven.Nodes.InternalOrOutputNode;
import neuralnetwork.neuralnetworkmaven.Nodes.Node;
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
public class NetworkTest {

    Network nn;

    public NetworkTest() {
        nn = new Network();
    }

    /**
     * Test of setInputNodes method, of class Network.
     */
    @Test
    public void testSetInputNodes() {
        System.out.println("Testing setInputNodes..");
        assertEquals(null, nn.inputNodes);
        nn.setInputNodes(new ArrayList<>());
        assertNotEquals(null, nn.inputNodes);
    }

    /**
     * Test of setOutputNode method, of class Network.
     */
    @Test
    public void testSetOutputNode() {
        System.out.println("Testing setOutputNode..");
        assertEquals(null, nn.outputNode);
        nn.setOutputNode(new InternalOrOutputNode("test"));
        assertNotEquals(null, nn.outputNode);
    }

}
