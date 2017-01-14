import java.util.Random;
import java.lang.Math;

public class Neuron 
{
	int numInput;
	double[] weights;
	double[] initWeights;
	double[] input;
	double output;
	double error;
	
	public Neuron(int numInputs)
	{
		numInput = numInputs;
		weights = new double[numInput];
		Random gen = new Random();
		System.out.print("Initial weights: ");
		for(int i = 0; i < numInput; i++)
		{
			double newWeight = gen.nextDouble();
			weights[i] = newWeight;
			System.out.print(newWeight + " ");
		}
		System.out.println();
		initWeights = weights;
	}
	
	public void train(double[] newInput, double desiredOutput)
	{
		activate(newInput);
		findError(desiredOutput);
		adjustWeights();
		System.out.println();
	}
	public double activate(double[] newInput)
	{
		input = newInput;
		System.out.print("Input: ");
		for(int i = 0; i < numInput; i++)
			System.out.print(input[i] + " ");
		System.out.println();
		output = 0;
		for(int i = 0; i < numInput; i++)
			output += input[i] * weights[i];
		System.out.println("Output: " + output);
		return output;
		
		//return 1 / (1 + Math.pow(Math.E, -output));
	}
	public void findError(double desiredOutput)
	{
		error = desiredOutput - output;
		System.out.println("Desired Output: " + desiredOutput);
		System.out.println("Error: " + error);
	}
	public void adjustWeights()
	{
		System.out.print("New Weights: ");
		for(int i = 0; i < numInput; i++)
		{
			weights[i] += error * input[i] * output * (1 - output);
			System.out.print(weights[i] + " ");
		}
		System.out.println();
			
	}
}