/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import neuralnetwork.neuralnetworkmaven.Neuralnetwork.BuildNetwork;

/**
 *
 * @author alintulu
 */
public class Main extends Application {

    private List<Double> trainingLoss;
    private double[] testingLoss;

    public Main() {
        this.trainingLoss = null;
        this.testingLoss = null;
    }

    @Override
    public void start(Stage window) {

        BuildNetwork networkStructure = new BuildNetwork();

        StartScreen ss = new StartScreen();
        Plot pp = new Plot();

        // create scenes
        Scene startScreen = new Scene(ss.buildStartScreen(), 500, 400);
        Scene plot1 = new Scene(pp.buildPlot1("output/training01.txt"), 500, 400);
        Scene plot2 = new Scene(pp.buildPlot2("output/training01.txt"), 500, 400);
        Scene lossError = new Scene(pp.showLossError(), 500, 400);

        List<Label> lossErrorList = pp.getLossError();

        window.setScene(startScreen);

        // "Train and Test network" button
        ss.getaButton().setOnAction(e -> {
            Integer IN = Integer.valueOf(ss.getInputNodes().getText());
            Integer HL = Integer.valueOf(ss.getHiddenLay().getText());
            Integer LN = Integer.valueOf(ss.getNodesLay().getText());

            networkStructure.makeNetwork(IN, HL, LN); // number input nodes, number of hidden layers, number of nodes per layer

            Integer TS = Integer.valueOf(ss.getSizeData().getText());
            Double LR = Double.valueOf(ss.getLearnRate().getText());
            Integer NI = Integer.valueOf(ss.getNumIter().getText());

            Integer TEST = Integer.valueOf(ss.getTestSizeData().getText());

            // after training and testing set the loss and error labels with correct value
            trainingLoss = networkStructure.trainNetwork(TS, LR, NI, false); // dataSetSize learningrate numIter printError

            for (int i = 0; i < lossErrorList.size(); i++) {
                lossErrorList.get(i).setText(Double.toString(trainingLoss.get(i)));
            }

            testingLoss = networkStructure.testNetwork(TEST); // trainingdata dataSetSize

            pp.getTestLoss().setText(Double.toString(testingLoss[0]));
            pp.getTestError().setText(Double.toString(testingLoss[1]));

            window.setScene(plot1);

        });

        pp.getGetPlot1().setOnAction(e -> {

            window.setScene(plot1);

        });

        pp.getGetPlot2().setOnAction(e -> {

            window.setScene(plot2);

        });

        pp.getGetPlot22().setOnAction(e -> {

            window.setScene(plot2);

        });

        pp.getGetLossError().setOnAction(e -> {

            window.setScene(lossError);

        });

        pp.getCloseWindow().setOnAction(e -> {

            window.close();

        });

        window.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
