/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Help;

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
public class trainingDataTest {
    
    trainingData data;
    
    public trainingDataTest() {
        data = new trainingData(new double[]{0.0, 1.0}, 0.5);
    }
    
    /**
     * Test of getInputVal method, of class trainingData.
     */
    @Test
    public void testGetInputVal() {
        System.out.println("Testing getInputVal..");
        assertEquals(0.0, data.getInputVal()[0], 0.0);
    }

    /**
     * Test of getTrueVal method, of class trainingData.
     */
    @Test
    public void testGetTrueVal() {
        System.out.println("Testing getTrueVal..");
        assertEquals(0.5, data.getTrueVal(), 0.0);
    }
    
}