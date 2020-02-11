package interviewbit.problems.maths;

/**
 * 
 * 
 * Given a column title as appears in an Excel sheet, return its corresponding
 * column number.
 * 
 * Example:
 * 
 * A -> 1
 * 
 * B -> 2
 * 
 * C -> 3
 * 
 * ...
 * 
 * Z -> 26
 * 
 * AA -> 27
 * 
 * AB -> 28
 * 
 * 
 * 
 * @author Vivek.g
 *
 */
public class ExcelColumnNumber
{
	public int titleToNumber(String A)
	{
		String input = A.toUpperCase();
		int aval = 'A';
		int result = 0;
		
		int len = input.length();
		result = 0;
		char[] charArray = input.toCharArray();
		for(int i = len - 1,j=0 ; i >= 0 ; i--,j++)
		{
			int diff = charArray[i] - aval;
			result+=(diff + 1) % 27 * Math.pow(26, j);
		}
		
		
		return result;
	}
	
	public static void main(String[] args)
	{
		ExcelColumnNumber num = new ExcelColumnNumber();
		System.out.println(num.titleToNumber("ZZ"));
	}

}
