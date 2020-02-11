package interviewbit.problems.maths;

import java.util.ArrayList;

public class PrimeNumberWithSieveOfErotosthenes
{

	public ArrayList<Integer> allPrimeWithSieve(int num)
	{
		int[] nums = new int[num];

		nums[0] = -1;

		for (int i = 2; i <= Math.sqrt(num); i++)
		{
			if (isPrime(i))
			{
				for (int j = 2; i * j <= num; j++)
				{
					nums[i * j - 1] = -1;
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i <= num - 1; i++)
		{
			if (nums[i] != -1)
			{
				result.add(i + 1);

			}
		}
		return result;
	}

	private boolean isPrime(int n)
	{
		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			if (n % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		PrimeNumberWithSieveOfErotosthenes primeFinder = new PrimeNumberWithSieveOfErotosthenes();
		System.out.println(primeFinder.allPrimeWithSieve(5));
	}

}
