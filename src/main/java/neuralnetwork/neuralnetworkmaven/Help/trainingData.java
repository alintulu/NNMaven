/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Help;

/**
 *
 * @author alintulu
 *
 * The training data has two parameters. inputVal is the input values and is an
 * array since the network can have several inputs per iteration. If the
 * function the network is learning from is 2D there is one input, if 3D two
 * inputs etc. As an example if we had a 3D function, parameter x would have
 * values at index 0 and parameter y values at index 1. trueVal is the correct
 * output and is just a double value since there is always just one output
 * value.
 *
 */
public class trainingData {

    public double[] inputVal;
    public double trueVal;

    public trainingData(double[] inputVal, double trueVal) {
        this.inputVal = inputVal;
        this.trueVal = trueVal;
    }

    public double[] getInputVal() {
        return inputVal;
    }

    public double getTrueVal() {
        return trueVal;
    }

    public void String() {
        System.out.print("\nInput value = ");
        for (double d : inputVal) {
            System.out.print(d + " ");
        }
        System.out.println("");
        System.out.println("True value " + trueVal + "\n");
    }
}
