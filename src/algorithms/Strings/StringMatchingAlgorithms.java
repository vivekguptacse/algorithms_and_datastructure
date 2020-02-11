package algorithms.Strings;

/**
 * Checking whether a pattern P is a substring of another string T (T stands for
 * text) or not. To simplify our discussion, let us assume that the length of
 * given text T is n and the length of the pattern P which we are trying to
 * match has the length m. That means, T has the characters from 0 to n – 1 (T[0
 * ...n – 1]) and P has the characters from 0 to m – 1 (P[0 ...m – 1]).
 * 
 * @author Vivek
 *
 */
public class StringMatchingAlgorithms
{
	
	public int bruteForceStringMatching(String text, String toMatch)
	{
		int n = text.length();
		int m = toMatch.length();
		
		char[] textArray = text.toCharArray();
		char[] toMatchArray = toMatch.toCharArray();
		
		for(int i=0; i< n ; i++)
		{
			int j=0;
			while(j < m && toMatchArray[j] == textArray[i+j])
			{
				j = j+1;
			}
			if(j == m)
			{
				return i;
			}
		}
		return -1;
	}
	
	

}
