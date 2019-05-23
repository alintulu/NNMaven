# Understanding the Output

The network will return two sets of outputs. One for training and one for validation. Training a model simply means finding good values for all the weights and the biases from labeled examples. However due to over-fitting, only relying on the training example is not enough to make an accurate conclusion. Hence we use a set of fresh data for validation.

These two sets, training and validation, will further contain two different metrics used to evaluate the network, loss and error. The goal of training a model is to find a set of weights and biases that have low loss, on average, and error across all examples. 

# Loss

In supervised learning, a machine learning algorithm builds a model by examining many examples and attempting to find a model that minimizes the loss. This process is called empirical risk minimization.

Loss is the penalty for a bad prediction. In general, the lower the loss the better a model (unless the model has over-fitted to the training data). The loss is calculated on training and validation and its interperation is how well the model is doing for these two sets. It is a cumulative sum of the errors made for each data point. 

A popular loss function, and the one used in this network is the Mean Square Error, MSE. It is the averaged squared loss per data point over the whole dataset. MSE is calculated by summing up the squared losses for individual data points and dividing it by the number of points.

![MSE](https://github.com/alintulu/NeuralNetwork/blob/master/documentation/images/mse.png)

Where 

  * x is the label or true value of the input
  * o is the predicted value of the input
  * N is the size of the data set

# Error

The error is a nice metric when evaluating how closely the predicted points equals the true values. Luckily due to backpropagating the network requiring knowledge of the error for every individual node, we can easily calculate the total error of the network. You can read more about backpropagation [here](https://github.com/alintulu/NNMaven/blob/master/documentation/UnderstandingTheNetwork.md). 

The total error is simply the weighted sum over the errors of all the nodes, where the weights are the weights of the edges. The error of each node is updated at every iteration of the network, and is backpropagated from the output node. The first error is calculated by comparing the true value of the output to the predicted value and then propagated back to the input nodes, multiplied by every weight edge it passes. 

![Error](https://github.com/alintulu/NeuralNetwork/blob/master/documentation/images/err.png)

Where 

  * x is the label or true value of the input
  * o is the predicted value of the input
  * N is the size of the data set

