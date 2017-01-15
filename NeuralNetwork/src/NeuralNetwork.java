public class NeuralNetwork 
{
	Neuron[] hidden;
	Neuron output;
	double[] hiddenInput;
	double[] outputInput;
	double finalOutput;
	
	public NeuralNetwork(int numInput, int numHidden, int numOutput)
	{
		hidden = new Neuron[numHidden];
		for(int i = 0; i < hidden.length; i++)
			hidden[i] = new Neuron(numInput);
		output = new Neuron(numHidden);
		outputInput = new double[numHidden];
	}
	
	public void learn(String newInput, double desiredInput)
	{
		forwardPropagate(newInput, desiredInput);
		backwardPropagate();
	}
	public double forwardPropagate(String newInput, double desiredInput)
	{
		hiddenInput = strToDoubleArray(newInput);
		for(int i = 0; i < hidden.length; i++)
			outputInput[i] = hidden[i].activate(hiddenInput, desiredInput);
		finalOutput = output.activate(outputInput, desiredInput);
		return finalOutput;
	}
	private void backwardPropagate()
	{
		for(int i = 0; i < hidden.length; i++)
			hidden[i].adjustWeightsHidden(finalOutput);
		output.adjustWeightsOutput();
	}
	
	public double[] strToDoubleArray(String str)
	{
		double[] nums = new double[str.length()];
		for(int i = 0; i < str.length(); i++)
		{
			nums[i] = (double) str.charAt(i);
			System.out.println(nums[i] + " ");
		}
			
		return nums;
	}
}