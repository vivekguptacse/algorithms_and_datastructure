package interviewbit.problems.maths;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * A palindrome integer is an integer x for which reverse(x) = x where
 * reverse(x) is x with its digit reversed. Negative numbers are not
 * palindromic.
 * 
 * Example :
 * 
 * Input : 12121 Output : true
 * 
 * Input : 123 Output : false
 * 
 * 
 * @author Vivek.g
 *
 */
public class PalindromInteger
{
	
	public static void main(String[] args)
	{
		PalindromInteger test = new PalindromInteger();
		
		System.out.println(test.isPalindrom(12213));
	}
	
	public boolean isPalindrom(int num)
	{
		if(num < 0)
		{
			return false;
		}
		
		String numString = ""+num;
		char[] charArray = numString.toCharArray();
		int low = 0;
		int high = charArray.length-1;
		while(low < high)
		{
			if(charArray[low++] == charArray[high--])
			{
				continue;
			}
			else
			{
				return false;
			}
			
		}
		return true;
	}

}
