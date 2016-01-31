import java.io.*;
import java.util.*;
public class lineReverse
{
	private String file;

	lineReverse(){}
	lineReverse(String inFile)
	{
		file = inFile;
	}

	//Open the file

	//Read each line in

	//Based on space delimeter put each word into a stack

	//print case # and pop an element off the stack

	public void processFile(String inFile)
	{
		File inputFile = null;
		File outputFile = null;
		BufferedReader read = null;
		PrintWriter write = null;
		String line = null;
		int k = 0;

		try
		{
			inputFile = new File(inFile);
			outputFile = new File("out.txt");
			read = new BufferedReader(new FileReader(inputFile));
			write = new PrintWriter(new FileWriter(outputFile));

			//Skip first line
			read.readLine();
			while((line = read.readLine()) != null)
			{
				k++;
				write.print("Case #" + k+ ": ");
				write.println(this.reverseLine(line));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public String reverseLine(String inputLine)
	{
		String reversed = "";
		Stack<String> lineStack = new Stack<String>();
		String elements[] = inputLine.split(" ");

		for (String word : elements)
		{
			System.out.println("Pushing " + word);
			lineStack.push(word + " ");
		}

		for(int k = 0; k < lineStack.size(); k++)
		{
			reversed += lineStack.pop();
		}

		return reversed;
	}
}