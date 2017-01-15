import java.util.Random;
import java.lang.Math;
import java.text.DecimalFormat;

public class Neuron 
{
	int numInput;
	double[] weights;
	double[] initWeights;
	String input;
	double output;
	double error;
	DecimalFormat df;
	
	public Neuron(int numInputs)
	{
		df = new DecimalFormat("0.000");
		numInput = numInputs;
		weights = new double[numInput];
		Random gen = new Random();
		System.out.print("Initial weights: ");
		for(int i = 0; i < numInput; i++)
		{
			double newWeight = gen.nextDouble();
			weights[i] = newWeight;
			System.out.print(df.format(newWeight) + " ");
		}
		System.out.println();
		initWeights = weights;
	}
	
	public void test(String newInput, double desiredOutput)
	{
		activate(newInput);
		findError(desiredOutput);
		System.out.println();
	}
	public void train(String trainingInput, double desiredOutput)
	{
		activate(trainingInput);
		findError(desiredOutput);
		adjustWeights();
		System.out.println();
	}
	public double activate(String newInput)
	{
		input = newInput;
		System.out.println("Input: " + input);
		output = 0;
		for(int i = 0; i < numInput; i++)
			output += (input.charAt(i) - 97) * weights[i];
		output /= 50;
		System.out.println("Output: " + df.format(output));
		output = 1 / (1 + Math.pow(Math.E, -output));
		System.out.println("Output: " + df.format(output));
		return output;
	}
	public double findError(double desiredOutput)
	{
		error = 0.5 * Math.pow(desiredOutput - output, 2);
		System.out.println("Desired Output: " + df.format(desiredOutput));
		System.out.println("Error: " + df.format(error));
		return error;
	}
	public void adjustWeights()
	{
		System.out.print("New Weights: ");
		for(int i = 0; i < numInput; i++)
		{
			weights[i] += error * (input.charAt(i) - 97) * output * (1 - output);
			System.out.print(df.format(weights[i]) + " ");
		}
		System.out.println();
			
	}
}