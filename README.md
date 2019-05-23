# Neural Network

This repository contains a neural network built in Java for the course of OhjelmistoTekniikan Menetelmä 
(OTM) at the University of Helsinki. The network works on poly-dimensional input data however it comes with a 
ready built method to train and validate it on one-dimensional inpu data of a cosine curve.

The network uses the activation function of the sigmoid curve and the optimizer of gradient descent.
It performs well on one-dimensional input data however the performance declines quickly as the dimensions increase.
The current performance can be seen [here](https://github.com/alintulu/NNMaven/blob/master/src/README.md).

The source code 
is located in the folder [src](https://github.com/alintulu/NNMaven/tree/master/src). Instructions how
to employ the network and basic knowledge of the network and output is located in the folder 
[documentation](https://github.com/alintulu/NNMaven/tree/master/documentation).

## Documentation

  1. [Instructions](https://github.com/alintulu/NNMaven/blob/master/documentation/Instructions.md)
  2. [Basic knowledge of a neural network](https://github.com/alintulu/NNMaven/blob/master/documentation/UnderstandingTheNetwork.md)
  2. [Understanding the output of the network](https://github.com/alintulu/NNMaven/blob/master/documentation/UnderstandingTheOutput.md)
  
## Running 

To compile and run the code, in the root directory (current) perform the following command

```
mvn compile exec:java -Dexec.mainClass=neuralnetwork.neuralnetworkmaven.Neuralnetwork.Main
```

## Testing

The test code is located in the folder [test](https://github.com/alintulu/NNMaven/tree/master/src/test/java/neuralnetwork/neuralnetworkmaven)
For testing the program, the following command can be performed in the root directory

```
mvn test
```
