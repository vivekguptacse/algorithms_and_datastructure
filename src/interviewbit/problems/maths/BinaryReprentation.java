package interviewbit.problems.maths;

/**
 * Given a number N >= 0, find its representation in binary.
 * 
 * Example:
 * 
 * if N = 6,
 * 
 * binary form = 110
 * 
 * @author Vivek.g
 *
 */
public class BinaryReprentation
{

	public static void main(String[] args)
	{
		BinaryReprentation repres = new BinaryReprentation();
		for(int i= 0; i <= 10 ; i++)
		{
			System.out.println(repres.findDigitsInBinary(i));
		}
		
	}
	
	
	public String findDigitsInBinary(int A)
	{
		if (A == 0)
		{
			return "0";
		}
		StringBuilder builder = new StringBuilder();
		int rem = 0; 
		int divisor = A; 
		
		while(divisor > 0)
		{
			rem = divisor % 2;
			divisor = divisor / 2;
			builder.append(rem);
		}
		
		builder.reverse();
		
		return builder.toString();
	}

}
