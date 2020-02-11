package interviewbit.problems.maths;

import java.math.BigInteger;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Example :
 * 
 * n = 5 n! = 120 Number of trailing zeros = 1 So, return 1
 * 
 * 
 * 
 * @author Vivek.g
 *
 */
public class TrailingZerosInFactorial
{

	public int mytrailingZeroesMethod(int num) {
		
		BigInteger factResult = factorial(BigInteger.valueOf(num));
		
		int result = 0;
		while(factResult.compareTo(BigInteger.ZERO) > 0)
		{
			if(factResult.mod(BigInteger.valueOf(1000000000)).compareTo(BigInteger.ZERO) == 0)
			{
				result+=9;
				factResult = factResult.divide(BigInteger.valueOf(1000000000));
			}
			else if(factResult.mod(BigInteger.valueOf(100000000)).compareTo(BigInteger.ZERO) == 0)
			{
				result+=8;
				factResult = factResult.divide(BigInteger.valueOf(100000000));
			}
			else if(factResult.mod(BigInteger.valueOf(10000000)).compareTo(BigInteger.ZERO) == 0)
			{
				result+=7;
				factResult = factResult.divide(BigInteger.valueOf(10000000));
			}
			else if(factResult.mod(BigInteger.valueOf(1000000)).compareTo(BigInteger.ZERO) == 0)
			{
				result+=6;
				factResult = factResult.divide(BigInteger.valueOf(1000000));
			}
			else if(factResult.mod(BigInteger.valueOf(10000)).compareTo(BigInteger.ZERO) == 0)
			{
				result+=4;
				factResult = factResult.divide(BigInteger.valueOf(10000));
			}
			else if(factResult.mod(BigInteger.valueOf(1000)).compareTo(BigInteger.ZERO) == 0)
			{
				result+=3;
				factResult = factResult.divide(BigInteger.valueOf(1000));
			}
			else if(factResult.mod(BigInteger.valueOf(100)).compareTo(BigInteger.ZERO) == 0)
			{
				result+=2;
				factResult = factResult.divide(BigInteger.valueOf(100));
			}
			else if(factResult.mod(BigInteger.TEN).compareTo(BigInteger.ZERO) == 0)
			{
				result++;
				factResult = factResult.divide(BigInteger.TEN);
			}
			else
			{
				break;
			}
		}
		
		return result;
    }
	
	public int trailingZeroes(int num) 
	{
		double factors = 5;
		double initial = 5;
		int pow = 1;
		factors = Math.pow(factors, pow++);
		int result = 0;
		while(num/factors > 0 )
		{
			result += num/factors;
			
			factors = Math.pow(initial, pow++);
		}

		return result;
	}
	private BigInteger factorial(BigInteger num)
	{
		if(num.intValue() == 0)
		{
			return BigInteger.valueOf(1);
		}

		return num.multiply(factorial(num.subtract(BigInteger.valueOf(1))));
	}
	
	public static void main(String[] args)
	{
		TrailingZerosInFactorial trailing = new TrailingZerosInFactorial();
//		for(int i = 0 ; i < 100 ; i++)
//		{
//			System.out.println(trailing.trailingZeroes(i) + " : " + i);
//		}
		System.out.println(trailing.trailingZeroes(4617));
	}
}
