package interviewbit.problems.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum
 * will be equal to given number.
 * 
 * NOTE A solution will always exist. read Goldbach’s conjecture
 * 
 * Example:
 * 
 * 
 * Input : 4 Output: 2 + 2 = 4
 * 
 * 
 * @author Vivek.g
 *
 */
public class PrimeSum
{
	public ArrayList<Integer> primesum(int num) 
	{
	
		List<Integer> primeNumbers = findPrimNumberTill(num);
		
		ArrayList<Integer> pair = findPrimeNumberPair(primeNumbers, num);
		return pair;
    }

	private ArrayList<Integer> findPrimeNumberPair(List<Integer> primeNumbers,
			int num)
	{
		for(int i = 0 ; i < primeNumbers.size() ; i++)
		{
			for(int j = 0 ; j < primeNumbers.size(); j++)
			{
				if(primeNumbers.get(i) + primeNumbers.get(j) == num)
				{
					ArrayList<Integer> result = new ArrayList<>();
					result.add(primeNumbers.get(i));
					result.add(primeNumbers.get(j));
					return result;
				}
			}
		}
		return new ArrayList<>();
	}

	private List<Integer> findPrimNumberTill(int num)
	{
		List<Integer> result = new ArrayList<>();
		int []primes = new int[num];
		
		primes[0] = -1;
		for(int i = 2 ; i <= Math.sqrt(num) ; i++)
		{
			if(isPrime(i))
			{
				for(int j = 2 ; i * j <= num ; j++)
				{
					primes[i*j-1] = -1;
				}
			}
		}
		
		int count = 0;
		for(int val : primes)
		{
			if(val != -1)
			{
				result.add(count+1);
			}
			count++;
		}
		
		
		
		return result;
	}

	private boolean isPrime(int num)
	{

		for(int i = 2 ; i <= Math.sqrt(num) ; i++)
		{
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
	}


    
    public static void main(String[] args)
	{
		PrimeSum sum = new PrimeSum();
		System.out.println(sum.primesum(10));
	}
}
