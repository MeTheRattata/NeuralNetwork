import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver 
{
	public static void main(String[] args) 
	{
		String[] trainingInput = {"00", "01", "10"};
		double[] trainingOutput = {0, 1, 0};
		String testingInput = "11";
		double testingOutput = 1;
		
		
		/*
		//Creates a new neuron with 9 inputs
		Neuron neuron = new Neuron(9);
		//Initializes the training input / output readers
		File trainingIn = new File("TrainingInput.txt");
		File trainingOut = new File("TrainingOutput.txt");
		Scanner trainingInput = new Scanner(trainingIn);
		Scanner trainingOutput = new Scanner(trainingOut);
		
		//Trains the neuron on the training input
		while(trainingInput.hasNext())
			neuron.train(trainingInput.next().toLowerCase(), trainingOutput.nextDouble());
		trainingInput.close();
		trainingOutput.close();
			
		//Tests the neuron's abilities on the test input
		File testingIn = new File("TestingInput.txt");
		File testingOut = new File("TestingOutput.txt");
		Scanner testingInput = new Scanner(testingIn);
		Scanner testingOutput = new Scanner(testingOut);
		while(testingInput.hasNext())
			neuron.test(testingInput.next().toLowerCase(), testingOutput.nextDouble());
		testingInput.close();
		testingOutput.close();
		*/
	}
}