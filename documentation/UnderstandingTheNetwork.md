# Understanding the network

A neural network contains layers of interconnected nodes. The first layer is a input layer containing a node for each dimension of the input data. The input layer is connected to the first hidden layer. Each node takes its input and feeds it into an activation function, a function crucial for learning the model. The final layer is an output layer that in this case has one node. The weights of the edges connecting all the nodes are fine-tuned until the neural network's margin of error is minimzed.

![Neural Network](https://github.com/alintulu/NeuralNetwork/blob/master/documentation/images/network_structure.png)

## Activation function

There are a number of possible functions however a suitable function needs to satisfy the following properties

  * Have a first derivative
  * The value of the derivated function of x is greater or equal to zero for every x
  * Have horizontal asymptotes at x equal both 0 and 1
  * Both the function and its derivative is computable

For a simple network like this the sigmoid function is an appropriate choice. However it should be noted that for more complex data its often not a good choice due to the flatness of the function when it approaches 0 and 1. The gradient of the function is responisble for learning. Therefore if the function is flat (gradient close to zero) the network will be worse at learning values in that interval. This is demonstrated in this network by output values close to the amplitude (close to 0 and 1) not being predicted as well as the rest of the values.

## Bias

Bias is an additional parameter in the network which is used to adjust the output along with the weighted sum of the inputs to the node. It allows the activation function to be shifted left or right. Changing the weights of a network essentially changes the steepness of the activation function. To shift the entire curve a bias is necessary. The bias is a constant which helps the model in a way that it can fit best to the given data.

In this network the bias is incorporated as an additonal node with an output fixed to 1. The weight of the edge connecting a node and its bias will work as the value of the bias, and be updated iteratively among with the rest of the edge weights.

## Backpropagation

The goal of a neural network is to minimze the error (difference of predicted and actual true value of the output) of each node. The common way to compute the error is by the sum of the squared deviations from the true value of the output. Since we strive to minimize the error we are looking for a global minimum. By computing the gradient, which points in the direction of steepest ascent, of the error function with respect to the weight and subtracting it from the current weight value we will get closer to a minimum of the error function. When backpropagating the updating of the weighst is done by

where eta is a fixed parameter denoted as the learning rate. It adjusts the rate of learning and should be chosen suffficiently small to guarantee enough time to find a good local minimum.

Backpropagation is necessery since the error can't be computed until we reach the last output node. There the error is computed as the difference of the predicted and actual true value of the output. And propagated backwards to update the weights and errors of the rest of the network.

## Complete process

In the end, the process of a neural network is quite simple.

  1. Start of by initializing the weights of all the edges to a random number between 0 and 1 (including the biases).
  2. Evaluate an input X by feeding it forward through the network and at each internal node record the output value.
  3. When reaching the end, record the final output and compute the error for that value.
  4. Backpropagate the error to each of the nodes by feeding it into the output node, and update the weights for the output node using the update rule.
  5.  Repeat the error propagation followed by a weight update for each of the nodes connected to the output node in the same way. Compute the updates for the nodes connected to those nodes and so on, until the weights of the entire network are updated.
  6. Repeat it all over again with a new input X.
  7. Stop when some criteria is achieved or when number of iterations are done.











