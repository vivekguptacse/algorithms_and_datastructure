package interviewbit.problems.maths;

/**
 * 
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * 
 * @author Vivek.g
 *
 */
public class ExcelColumnTitle
{
	public String convertToTitle(int A)
	{
		int aval = 'A';
		int divisor = 26;
		int dividend = A;
		int remainder = 0;
		StringBuilder sb = new StringBuilder();
		
		while(dividend > 0)
		{
			remainder = dividend % 27;
			dividend /= divisor;
			int ch = 0;
			if(remainder == 0)
			{
//				remainder = 1;
				ch = Math.abs(aval + remainder);
				char c = (char)ch;
				sb.append(c);
			}
			else
			{
//				dividend /= divisor;
				ch = Math.abs(aval + remainder)-1;
				char c = (char)ch;
				sb.append(c);
			}
		}
	
		return sb.reverse().toString();
	}
	
	public static void main(String[] args)
	{
		ExcelColumnTitle ec = new ExcelColumnTitle();
		System.out.println(ec.convertToTitle(701));
	}
}
