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
	public void train(String trainingInput,
			double desiredOutput)
	{
		activate(trainingInput);
		findError(desiredOutput);
		adjustWeights();
		System.out.println();
	}
	public double activate(String newInput)
	{
		input = newInput;
		System.out.print("Input: ");
		for(int i = 0; i < numInput; i++)
			System.out.print((input.charAt(i) - 48) + " ");
		System.out.println();
		output = 0;
		for(int i = 0; i < numInput; i++)
			output += (input.charAt(i) - 48) * weights[i];
		output = 1 / (1 + Math.pow(Math.E, -output));
		System.out.println("Output: " + df.format(output));
		//return output;
		
		return output;
	}
	public void findError(double desiredOutput)
	{
		error = desiredOutput - output;
		System.out.println("Desired Output: " + df.format(desiredOutput));
		System.out.println("Error: " + df.format(error));
	}
	public void adjustWeights()
	{
		System.out.print("New Weights: ");
		for(int i = 0; i < numInput; i++)
		{
			weights[i] += error * (input.charAt(i) - 48) * output * (1 - output);
			System.out.print(df.format(weights[i]) + " ");
		}
		System.out.println();
			
	}
}