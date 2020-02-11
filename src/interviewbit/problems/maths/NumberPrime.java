package interviewbit.problems.maths;

/**
 * Given a number N, verify if N is prime or not.
 * 
 * Return 1 if N is prime, else return 0.
 * 
 * Example :
 * 
 * Input : 7 Output : True
 * 
 * 
 * @author Vivek.g
 *
 */
public class NumberPrime
{
	public int isPrime(int num)
	{
		for(int i = 2 ; i < Math.sqrt(num) ; i++)
		{
			if( num % i  == 0)
			{
				return 0;
			}
		}
		return 1;
	}

}
