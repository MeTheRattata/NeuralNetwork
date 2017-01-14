import java.util.Random;
import java.lang.Math;

public class Neuron 
{
	int numInput;
	double[] weights;
	double[] input;
	double output;
	double error;
	
	public Neuron(int numInputs)
	{
		numInput = numInputs;
		weights = new double[numInput];
		Random gen = new Random();
		for(int i = 0; i < numInput; i++)
			weights[i] = gen.nextDouble();
	}
	
	public void learn(double[] newInput, double desiredOutput)
	{
		activate(newInput);
		findError(desiredOutput);
		adjustWeights();
	}
	public double activate(double[] newInput)
	{
		input = newInput;
		output = 0;
		for(int i = 0; i < numInput; i++)
			output += input[i] * weights[i];
		
		return 1 / (1 + Math.pow(Math.E, -output));
	}
	public void findError(double desiredOutput)
	{
		error = desiredOutput - output;
	}
	public void adjustWeights()
	{
		for(int i = 0; i < numInput; i++)
			weights[i] += error * input[i] * output * (1 - output);
	}
}