import java.util.Scanner;
import java.io.File;

public class NeuralNetwork 
{
	public static void main(String[] args) 
	{
		//File trainingInput = new File("TrainintInput.txt");
		//File trainingOutput = new File("TrainingOutput.txt");
		//Teaching a single neuron how to tell if the first digit of a three number sequence is a 1 or a 0
		String[] trainingInput = {"000", "001", "010", "011", "110", "111"};
		double[] trainingOutput = {0, 0, 0, 0, 1, 1};
		String testInput = "100";
		double testOutput = 1;
		
		//Creates a new neuron with 3 inputs
		Neuron neuron = new Neuron(3);
		
		//Trains the neuron on the training input
		for(int j = 0; j < 1000; j++)
			for(int i = 0; i < trainingInput.length; i++)
				neuron.train(trainingInput[i], trainingOutput[i]);
		
		//Tests the neuron's abilities on the test input
		neuron.test(testInput, testOutput);
	}
}