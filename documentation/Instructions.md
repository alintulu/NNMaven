# Instructions

If you want to know more about all the parameters mentioned here, check out [UnderstandingTheNetwork](https://github.com/alintulu/NeuralNetwork/blob/master/documentation/UnderstandingTheNetwork.md)

## Building the network

Building the network is done in the file [Main.java](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Main.java). The method to do so is called `makeNetwork()` and is called from the main function.

The method takes three inputs.

```
  numInputNodes 
    - number of input nodes
  numHiddenLayers 
    - number of hidden layers
  numInEachLayer
    - number of nodes in each layer
```
  
As default the number of input nodes is 1, number of hidden layers 3 and number of nodes in each layer 10. You can change all mentioned values [here](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Main.java#L109), however keep in mind that the default training data is two-dimensional and requires therefore `numInputNodes` to equal 1. 

## Training the network

Training the network is done in the file [Network.java](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Network.java). The method to do so is called `trainNetwork()` and is called from the main function.

The method takes three inputs.

```
  traingData
    - List of training data, by default data of a sine curve
  N
    - batch size of the training data
  learningRate
    - Rate of which the network will learn
  numIterations
    - Number of times the network should iterate through the given training data
  printError
    - boolean for printing statistics
```

By default the training data is an array of size 100 containing x and y values of a dosine curve. The learning rate is set to 0.01 and number of iterations to 1000. You can change all the mentioned values [here](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Main.java#L111).

## Testing the network

Testing the network is done in the file [Network.java](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Network.java). The method to do so is called `testNetwork()` and is called from the main function.

The method takes two inputs.

```
  trainData
    - List of training data, by default data of a sine curve
  N
    - batch size of the training data
```

By default the training data is an array of size 50 containing x and y values of a cosine curve. You can change all the mentioned values [here](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Main.java#L117).

## Result 

The script will create two .txt files

  1. `training01.txt`
  2. `testing01.txt`
  
 Which each has three rows containing data in the following fashion.
 
```
  input  output  true_value
```

Where input is the input given to the network, output is the predicted value of the network and true_value is the label or true value of the input.

The creating of the files happens [here](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Network.java#L121) for training and [here](https://github.com/alintulu/NeuralNetwork/blob/master/src/Neuralnetwork/Network.java#L167) for testing/validating. The script will also print the loss and error of training and testing. If you want to read more about the metrics of evaluting the model, read [UnderstandingTheOutput](https://github.com/alintulu/NeuralNetwork/blob/master/documentation/UnderstandingTheOutput.md)  
