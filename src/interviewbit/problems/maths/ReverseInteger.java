package interviewbit.problems.maths;

/**
 * Reverse digits of an integer.
 * 
 * Example1:
 * 
 * x = 123,
 * 
 * return 321 Example2:
 * 
 * x = -123,
 * 
 * return -321
 * 
 * Return 0 if the result overflows and does not fit in a 32 bit signed integer
 * 
 * @author Vivek.g
 *
 */
public class ReverseInteger
{
	public int reverse(int num)
	{
		boolean isNegative = false;
		if (num < 0)
		{
			isNegative = true;
		}

		String stringnum = Integer.toString(num);
		if (isNegative)
		{
			stringnum = stringnum.substring(1);
		}

		char[] charArray = stringnum.toCharArray();

		StringBuilder sb = new StringBuilder();

		for (int i = charArray.length - 1; i >= 0; i--)
		{
			sb.append(charArray[i]);
		}

		String result = sb.toString();

		if (isNegative)
		{
			result = "-" + result;
		}

		long longVal = Long.parseLong(result);

		if (longVal < Integer.MIN_VALUE || longVal > Integer.MAX_VALUE)
		{
			return 0;
		}

		return Integer.parseInt(result);
	}

	public static void main(String[] args)
	{

		ReverseInteger num = new ReverseInteger();
		System.out.println(num.reverse(-1342355412));
	}
}
