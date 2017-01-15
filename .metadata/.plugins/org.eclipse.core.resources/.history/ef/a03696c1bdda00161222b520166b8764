import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class GermanWordParser 
{
	public static void main(String[] args) throws UnsupportedEncodingException, IOException
	{
		Random gen = new Random();
		File englishList = new File("EnglishWordList.txt");
		File germanList = new  File("GermanWordList.txt");
	    try 
	    {
	        Scanner english = new Scanner(englishList);
	        Scanner german = new Scanner(germanList);
	        File trainingInput = new  File("TrainingInput.txt");
	        File trainingOutput = new File("TrainingOutput.txt");
	        File testingInput = new File("TestingInput.txt");
	        File testingOutput = new File("TestingOutput.txt");

	        FileWriter traI = new FileWriter(trainingInput.getAbsoluteFile());
	        BufferedWriter trI = new BufferedWriter(traI);
	        FileWriter traO = new FileWriter(trainingOutput.getAbsoluteFile());
	        BufferedWriter trO = new BufferedWriter(traO);
	        FileWriter tesI = new FileWriter(testingInput.getAbsoluteFile());
	        BufferedWriter teI = new BufferedWriter(tesI);
	        FileWriter tesO = new FileWriter(testingOutput.getAbsoluteFile());
	        BufferedWriter teO = new BufferedWriter(tesO);
	        
	       	double which = 0;
	       	double training = 0;
	        while (english.hasNext() || german.hasNext()) 
	        {
	        	which = gen.nextDouble();
	        	training = gen.nextDouble();
	        	String str = "";
	        	
	        	if(training <= 0.8)
	        	{
	        		if(which >= 0.5)
	        		{
	        			if(english.hasNext())
	        			{
	        				str = english.next();
	        				System.out.println("English training");
	        				trO.write("1" + '\n');
	        				trI.write(str + '\n');	
	        			}
	        			
	        		}
		        		
		        	else
		        	{
		        		if(german.hasNext())
		        		{
		        			str = german.next();
		        			System.out.println("German training");
		        			trO.write("0" + '\n');
		        			trI.write(str + '\n');	
		        		}
		        	}
	        	}
	        	else
	        	{
	        		if(which >= 0.5)
	        		{
	        			if(english.hasNext())
	        			{
	        				str = english.next();
	        				System.out.println("English testing");
	        				teO.write("1" + '\n');
	        				teI.write(str + '\n');
	        			}
	        			
	        		}
	        		else
		        	{
		        		if(german.hasNext())
		        		{
		        			str = german.next();
		        			System.out.println("German testing");
		        			teO.write("0" + '\n');
		        			teI.write(str + '\n');
		        		}
		        	}
	        	}
	        }
	        
	        english.close();
	        german.close();
	        trI.close();
	        trO.close();
	        teI.close();
	        teO.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
}