import java.util.Random;

public class Neuron 
{
	double[] weights;
	
	public Neuron(int numInputs)
	{
		weights = new double[numInputs];
		Random gen = new Random();
		for(int i = 0; i < numInputs; i++)
			weights[i] = gen.nextDouble();
	}
	
}