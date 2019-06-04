/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author alintulu
 */
public class StartScreen {

    private Button aButton;
    private TextField inputNodes;
    private TextField hiddenLay;
    private TextField nodesLay;
    private TextField sizeData;
    private TextField learnRate;
    private TextField numIter;
    private TextField testSizeData;

    public StartScreen() {
        this.aButton = new Button("Train and Test network");
        this.inputNodes = new TextField("1");
        this.hiddenLay = new TextField("3");
        this.nodesLay = new TextField("10");
        this.sizeData = new TextField("1000");
        this.learnRate = new TextField("0.3");
        this.numIter = new TextField("100");
        this.testSizeData = new TextField("50");
    }

    // start screen where you can insert the differenet options
    public GridPane buildStartScreen() {

        GridPane rootNode = new GridPane();

        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);
        
        // options for  building the network
        Label buildNet = new Label("Building the Network");
        rootNode.add(buildNet, 1, 0);
        GridPane.setHalignment(buildNet, HPos.CENTER);
        rootNode.add(new Label("Number of input nodes:"), 0, 1);
        inputNodes.setEditable(false);
        rootNode.add(inputNodes, 1, 1);
        rootNode.add(new Label("Number of hidden layers:"), 0, 2);
        rootNode.add(hiddenLay, 1, 2);
        rootNode.add(new Label("Number in each layers:"), 0, 3);
        rootNode.add(nodesLay, 1, 3);

        // options for training the network
        Label trainNet = new Label("Training the Network");
        rootNode.add(trainNet, 1, 4);
        GridPane.setHalignment(trainNet, HPos.CENTER);
        rootNode.add(new Label("Size of training data:"), 0, 5);
        rootNode.add(sizeData, 1, 5);
        rootNode.add(new Label("Learning rate:"), 0, 6);
        rootNode.add(learnRate, 1, 6);
        rootNode.add(new Label("Number of iterations:"), 0, 7);
        rootNode.add(numIter, 1, 7);

        // options for testing the network
        Label testNet = new Label("Testing the Network");
        rootNode.add(testNet, 1, 8);
        GridPane.setHalignment(testNet, HPos.CENTER);
        rootNode.add(new Label("Size of testing data:"), 0, 9);
        rootNode.add(testSizeData, 1, 9);

        rootNode.add(aButton, 1, 10);
        GridPane.setHalignment(aButton, HPos.LEFT);

        return rootNode;
    }

    public TextField getTestSizeData() {
        return testSizeData;
    }

    public Button getaButton() {
        return aButton;
    }

    public TextField getInputNodes() {
        return inputNodes;
    }

    public TextField getHiddenLay() {
        return hiddenLay;
    }

    public TextField getNodesLay() {
        return nodesLay;
    }

    public TextField getSizeData() {
        return sizeData;
    }

    public TextField getLearnRate() {
        return learnRate;
    }

    public TextField getNumIter() {
        return numIter;
    }

}
