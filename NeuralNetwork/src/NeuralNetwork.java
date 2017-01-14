
public class NeuralNetwork 
{
	public static void main(String[] args) 
	{
		//Teaching a single neuron how to tell if the first digit of a three number sequence is a 1 or a 0
		double[][] trainingInput = {{0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 1, 0}, {1, 1, 1}};
		double[] trainingOutput = {0, 0, 0, 0, 1, 1};
		double[] testInput = {1, 0, 0};
		double testOutput = 1;
		
		//Creates a new neuron with 3 inputs
		Neuron neuron = new Neuron(3);
		
		//Trains the neuron on the training input
		for(int j = 0; j < 100; j++)
			for(int i = 0; i < trainingInput.length; i++)
				neuron.train(trainingInput[i], trainingOutput[i]);
		
		//Tests the neuron's abilities on the test input
		System.out.print("Test input: ");
		for(int i = 0; i < testInput.length; i++)
			System.out.print(testInput[i]);
		System.out.println();
		System.out.println("Output: " + neuron.activate(testInput));
		System.out.println("Desired output: " + testOutput);
		
	}
}