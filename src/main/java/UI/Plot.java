/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import neuralnetwork.neuralnetworkmaven.Help.WriteFile;
import neuralnetwork.neuralnetworkmaven.Neuralnetwork.BuildNetwork;

/**
 *
 * @author alintulu
 */
public class Plot {

    private Button getPlot1;
    private Button getPlot2;
    private Button getPlot22;
    private Button closeWindow;
    private Button getlossError;
    private List<Label> trainLossError;
    private Label testLoss;
    private Label testError;

    public Plot() {
        this.getPlot2 = new Button("Go to second plot");
        this.getPlot22 = new Button("Go back to second plot");
        this.getPlot1 = new Button("Go back to first plot");
        this.closeWindow = new Button("Close window");
        this.getlossError = new Button("Show loss and error");
        this.trainLossError = new ArrayList<>();
        this.testLoss = new Label();
        this.testError = new Label();
    }

    // Create plot from first iteration of randomnized data points
    public Pane buildPlot1(String path) {

        //Defining the axes               
        NumberAxis xAxis = new NumberAxis(0, 5, 3);
        xAxis.setLabel("X");

        NumberAxis yAxis = new NumberAxis(0, 1, 4);
        yAxis.setLabel("Y");

        //Creating the Scatter chart 
        ScatterChart<String, Number> scatterChart = new ScatterChart(xAxis, yAxis);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        //Prepare XYChart.Series objects by setting data 
        XYChart.Series seriesC = new XYChart.Series();
        XYChart.Series seriesL = new XYChart.Series();

        seriesC.setName("Data points");

        WriteFile read = new WriteFile(path);

        List<Double> values = read.readFromFile();


        for (int i = 0; i < Integer.valueOf(values.size() / 2 - 2); i = i + 3) {
            seriesC.getData().add(new XYChart.Data(values.get(i), values.get(i + 1)));
            seriesL.getData().add(new XYChart.Data(values.get(i), values.get(i + 2)));
        }

        //Setting the data to scatter chart        
        scatterChart.getData().addAll(seriesC);
        lineChart.getData().addAll(seriesL);

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        Label title = new Label("First iteration, randomnized data points");
        pane.add(title, 0, 0);
        GridPane.setHalignment(title, HPos.CENTER);

        pane.add(scatterChart, 0, 1);
        pane.add(lineChart, 0, 1);

        pane.add(getPlot2, 0, 2);
        GridPane.setHalignment(getPlot2, HPos.CENTER);

        lineChart.setOpacity(0.5);
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);

        return pane;
    }

    // create second plot from last iteration, with trained data points
    public GridPane buildPlot2(String path) {


        //Defining the axes               
        NumberAxis xAxis = new NumberAxis(0, 5, 3);
        xAxis.setLabel("X");

        NumberAxis yAxis = new NumberAxis(0, 1, 4);
        yAxis.setLabel("Y");

        //Creating the Scatter chart 
        ScatterChart<String, Number> scatterChart = new ScatterChart(xAxis, yAxis);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        //Prepare XYChart.Series objects by setting data 
        XYChart.Series seriesC = new XYChart.Series();
        XYChart.Series seriesL = new XYChart.Series();

        seriesC.setName("Data points");

        WriteFile read = new WriteFile(path);

        List<Double> values = read.readFromFile();


        for (int i = Integer.valueOf(values.size() / 2); i < Integer.valueOf(values.size() - 2); i = i + 3) {
            seriesC.getData().add(new XYChart.Data(values.get(i), values.get(i + 1)));
            seriesL.getData().add(new XYChart.Data(values.get(i), values.get(i + 2)));
        }

        //Setting the data to scatter chart        
        scatterChart.getData().addAll(seriesC);
        lineChart.getData().addAll(seriesL);

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        Label title = new Label("Last iteration, trained data points");
        pane.add(title, 0, 0);
        GridPane.setHalignment(title, HPos.CENTER);

        pane.add(scatterChart, 0, 1);
        pane.add(lineChart, 0, 1);

        pane.add(getPlot1, 0, 2);
        GridPane.setHalignment(getPlot1, HPos.CENTER);
        pane.add(getlossError, 0, 3);
        GridPane.setHalignment(getlossError, HPos.CENTER);
        pane.add(closeWindow, 0, 4);
        GridPane.setHalignment(closeWindow, HPos.CENTER);

        lineChart.setOpacity(0.5);
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);

        return pane;
    }

    // show training and testing loss and errors
    public GridPane showLossError() {

        GridPane rootNode = new GridPane();

        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Label title1 = new Label("Training loss:");
        rootNode.add(title1, 0, 0);
        GridPane.setHalignment(title1, HPos.CENTER);

        for (int i = 1; i < 11; i++) {
            Label label = new Label();
            trainLossError.add(label);
            rootNode.add(label, 1, i);
            GridPane.setHalignment(label, HPos.RIGHT);
        }

        Label title2 = new Label("Testing loss:");
        rootNode.add(title2, 0, 11);
        GridPane.setHalignment(title1, HPos.CENTER);
        rootNode.add(testLoss, 1, 12);
        GridPane.setHalignment(testLoss, HPos.RIGHT);

        Label title3 = new Label("Testing error:");
        rootNode.add(title3, 0, 13);
        GridPane.setHalignment(title1, HPos.CENTER);
        rootNode.add(testError, 1, 14);
        GridPane.setHalignment(testError, HPos.RIGHT);

        rootNode.add(getPlot22, 1, 17);
        GridPane.setHalignment(getPlot22, HPos.LEFT);

        return rootNode;
    }

    public Button getGetlossError() {
        return getlossError;
    }

    public Label getTestLoss() {
        return testLoss;
    }

    public Label getTestError() {
        return testError;
    }

    public Button getGetPlot1() {
        return getPlot1;
    }

    public Button getGetPlot2() {
        return getPlot2;
    }

    public Button getCloseWindow() {
        return closeWindow;
    }

    public Button getGetLossError() {
        return getlossError;
    }

    public List<Label> getLossError() {
        return trainLossError;
    }
    
    public Button getGetPlot22() {
        return getPlot22;
    }
}
