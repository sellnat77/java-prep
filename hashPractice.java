import java.util.*;

public class hashPractice
{
	public void checkDupes(String line)
	{
		String hashResult;
		Hashtable<Integer, String> myHash = new Hashtable<Integer, String>();

		String[] theWords = line.split(" ");

		for(String word : theWords)
		{
			word = word.toLowerCase();
			hashResult = myHash.put(this.hash(word), word);
			if( hashResult != null )
			{
				System.out.println("Duplicate detected on word: " + word);
			}
		}
	}

	private int hash( String value )
	{
		char tempChar;
		int hashed = 0;

		for( int k = 0; k < value.length(); k++ )
		{
			tempChar = value.charAt(k);
			hashed += (int)(tempChar)*Math.pow(7, value.length()-k);
		}

		//System.out.println("I hashed " + value + " to " + hashed);

		return hashed;
	}
}