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
			outputFile = new File("smout.txt");
			read = new BufferedReader(new FileReader(inputFile));
			write = new PrintWriter(outputFile);

			//Skip first line
			read.readLine();
			while((line = read.readLine()) != null)
			{
				System.out.println("Checking file");
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
			lineStack.push(word + " ");
		}

		int stackSize = lineStack.size();

		for(int k = 0; k < stackSize; k++)
		{
			reversed += lineStack.pop();
		}

		return reversed;
	}
}