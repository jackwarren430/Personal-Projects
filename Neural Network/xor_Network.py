import numpy, random, os  
lr = 1  # learning rate
bias = 1  # value of bias
weights = [random.random(),random.random(),random.random()] 
# weights generated in a list (3 weights in total for 2 neurons and the bias) 

def Perceptron(input1, input2, output):
	outputP = (input1 * weights[0]) + (input2 * weights[1]) + (bias * weights[2])
	#outputP = 1/(1+numpy.exp(-outputP)) #sigmoid function
	if outputP > 0 :
		outputP = 1  
	else :
		outputP = 0
	error = output - outputP
	weights[0] += error * input1 * lr
	weights[1] += error * input2 * lr
	weights[2] += error * bias * lr  

for i in range(1000):
	Perceptron(1, 1, 0)
	Perceptron(1, 0, 1)
	Perceptron(0, 1, 1)
	Perceptron(0, 0, 0)

x = int(input())
y = int(input())
outputP = x*weights[0] + y*weights[1] + bias*weights[2]
#outputP = 1/(1+numpy.exp(-outputP)) #sigmoid function
if outputP > 0 : #activation function
	outputP = 1
else :
	outputP = 0
print(x, "xor", y, "is : ", outputP)