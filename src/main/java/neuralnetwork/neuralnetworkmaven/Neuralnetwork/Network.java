/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Neuralnetwork;

import neuralnetwork.neuralnetworkmaven.Help.trainingData;
import neuralnetwork.neuralnetworkmaven.Nodes.Node;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alintulu
 * 
 * This class contains all the main methods of the network. The methods here start
 * returning the output, back propagating and updating weights. It also contains the
 * method for training and testing the network.
 * 
 */
public class Network {

    private boolean debug = false;

    // list of input nodes, can be have many you want. 1,2,3...
    public List<Node> inputNodes;
    // this network always only has one output node
    public Node outputNode;

    public Network() 
    {
        this.inputNodes = null;
        this.outputNode = null;
    }

    public void setInputNodes(List<Node> inputNodes) 
    {
        this.inputNodes = inputNodes;
    }

    public void setOutputNode(Node outputNode) 
    {
        this.outputNode = outputNode;
    }

    // get output of the network
    public double getOutput(double[] inputVal) 
    {
        // clear the former output before you get a new one
        this.outputNode.clearOutput();

        double output = this.outputNode.getOutput(inputVal);
        return output;

    }

    /* backpropagate the network to "hopefully" decrease the error of every node, starting from input nodes
    trueVal is the correct output value of the input
    */
    public void backPropagate(double trueVal, boolean printError) 
    {
        for (Node node : inputNodes)
        {
            node.getError(trueVal, printError);
        }

    }

    // update weights of nodes, starting from input nodes
    public void updateWeights(double learningRate) 
    {

        for (Node node : inputNodes) 
        {
            node.updateWeights(learningRate);
        }
    }

    // main function to train the network, trainData is list containing the training data
    public List<Double> trainNetwork(List<trainingData> trainData, int N, double learningRate, int numIterations, boolean printError) {

        
        List<Double> trainingLoss = new ArrayList<>();
        int epoch = (int) numIterations/10;
        double errorSum = 0;
        
        FileWriter fw;

        try {
            fw = new FileWriter(new File("training01.txt"));

            for (int i = 0; i < numIterations; i++) {
                
                double epochLoss = 0;

                // inputData is the input the network will learn from
                // trueVal is the correct answer of the inputData, the network will use this to caluclate error and with that update weights
                for (trainingData data : trainData) {

                    double[] inputData = data.getInputVal();
                    double trueVal = data.getTrueVal();

                    if (debug) {
                        data.String();
                    }

                    double output = getOutput(inputData);

                    if (i % epoch == 0) {
                        epochLoss += Math.pow(trueVal - output, 2);
                    }
                    
                    if (i == numIterations - 1) {
                        errorSum = Math.abs(trueVal - output);
                    }
                    
                    fw.write(String.format("%4.3f %4.3f %4.3f\n", inputData[0], output, trueVal));

                    backPropagate(trueVal, printError);
                    updateWeights(learningRate);
                }
                
                if (i % epoch == 0) {
                    trainingLoss.add(epochLoss / N);
                }

            }
            fw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        trainingLoss.add(errorSum / N);
        
        return trainingLoss;
    }

    // main function to test the network
    public double[] testNetwork(List<trainingData> trainData, int N) {

        boolean debug = false;
        double loss = 0;
        double errorSum = 0;

        FileWriter fw;

        try {
            fw = new FileWriter(new File("testing01.txt"));

            // inputData is the input the network will learn from
            // trueVal is the correct answer of the inputData, the network will use this to caluclate error and with that update weights
            for (trainingData data : trainData) {

                double[] inputData = data.getInputVal();
                double trueVal = data.getTrueVal();

                double output = getOutput(inputData);
                
                loss += Math.pow(trueVal - output, 2);
                errorSum += Math.abs(trueVal - output);
                
                fw.write(String.format("%4.3f %4.3f %4.3f\n", inputData[0], output, trueVal));

                if (debug) {
                    System.out.println("inputData: " + inputData[0] + ", trueVal: " + trueVal + ", output: " + output + "\n");
                }
            }
            fw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new double[]{loss / N, errorSum / N};
    }
}
