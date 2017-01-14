import java.util.Random;
import java.lang.Math;

public class Neuron 
{
	int numInput;
	double learnRate;
	double[] weights;
	double[] input;
	double outputSum;
	double output;
	double[] error;
	
	public Neuron(int numInputs, double learningRate)
	{
		numInput = numInputs;
		weights = new double[numInput];
		Random gen = new Random();
		for(int i = 0; i < numInput; i++)
			weights[i] = gen.nextDouble();
		error = new double[numInput];
	}
	
	public void learn()
	{
		
	}
	public double activate(double[] newInput)
	{
		input = newInput;
		for(int i = 0; i < numInput; i++)
			outputSum += input[i] * weights[i];
		
		
		return 1 / (1 + Math.pow(Math.E, -outputSum));
	}
	public void findError(double[] desiredOutput)
	{
		for(int i = 0; i < numInput; i++)
			error[i] = desiredOutput[i] - output[i];
	}
	public void adjustWeights()
	{
		for(int i = 0; i < numInput; i++)
			weights[i] += learnRate * error[i] * input[i];
	}
}