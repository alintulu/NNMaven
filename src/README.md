# Neural Network

Main function to build the neural network and train as well as validate it is done in the file [Neuralnetwork/Main.java](https://github.com/alintulu/NNMaven/tree/master/src/main/java/neuralnetwork/neuralnetworkmaven/Neuralnetwork/Main.java).
If you wish to change the number of internal nodes or number of hidden layers, do it [here](https://github.com/alintulu/NNMaven/tree/master/src/main/java/neuralnetwork/neuralnetworkmaven/Neuralnetwork/Main.java#L109). For more information of how to use the code check out
[Instructions](https://github.com/alintulu/NNMaven/blob/master/documentation/Instructions.md).

## Structure of the code

The folder [Nodes](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Nodes) contains the source code of the different nodes employed by the network. There is 

  * [InputNode.java](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Nodes/InputNode.java)
  * [InternalOrOutputNode.java](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Nodes/InternalOrOutputNode.java)
  * [BiasNode.java](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Nodes/BiasNode.java) 
  
that follows the interface [Node.java](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Nodes/Node.java). In the same folder you'll find [Edge.java](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Nodes/Edge.java) that creates edges between the above mentioned nodes.

The folder [Neuralnetwork](https://github.com/alintulu/NNMaven/tree/master/src/main/java/neuralnetwork/neuralnetworkmaven/Neuralnetwork) contains the code for creating the network and generating the training data as well as training and validating the netwrok. The folder [Help](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Help) contains the help functions used by the network, such as [WriteFile.java](https://github.com/alintulu/NNMaven/blob/master/src/main/java/neuralnetwork/neuralnetworkmaven/Help/WriteFile.java) that writes out the generated and predicted data into a .txt file to be used for plotting.

## Performance

With the settings of 1 input node, 3 hidden layers and 10 nodes in each layer and the network being trained on 100 data points with learning rate 0.01 and epochs 1000, the final loss and error is 

  * loss : 0.0967266283863907
  * error : 0.0018227473748430889

Validated on 50 data points the loss and error is

  * loss : 0.07236535558734761
  * error : 0.0926871532752804
  
I.e. the network performs quite well. The loss is decreasing steadily at each epoch and the validation error lands at 9%.

## Settings

```
makeNetwork(1, 3, 10)
network.trainNetwork(sineTest(100), 100, 0.01, 1000, false)
network.testNetwork(sineTest(50), 50)
```

### Training loss and error

Each loss is calculated with 100 iterations between values (i.e. first after 100 iterations, second after 200 iterations etc)

```
Loss :
Epoch 1: 0.3921109844995156
      2 : 0.2899933924911887
      3 : 0.104467802199427214
      4 : 0.09998987395211105
      5 : 0.09864322148964241
      6 : 0.09821383290194213
      7 : 0.09801403624897569
      8 : 0.0978916881507303
      9 : 0.09779691174910184
      10 : 0.0967266283863907
      
Error : 0.0018227473748430889
```

### Validation loss and error

```
Loss : 0.07236535558734761
Error : 0.2268715327528046
```

### Plot of validation

![Validation plot](https://github.com/alintulu/NNMaven/blob/master/documentation/images/training_output.png)
