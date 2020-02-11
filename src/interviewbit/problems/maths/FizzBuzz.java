package interviewbit.problems.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer A, return an array of strings with all the integers
 * from 1 to N. But for multiples of 3 the array should have “Fizz” instead of
 * the number. For the multiples of 5, the array should have “Buzz” instead of
 * the number. For numbers which are multiple of 3 and 5 both, the array should
 * have “FizzBuzz” instead of the number.
 * 
 * Look at the example for more details.
 * 
 * Example
 * 
 * A = 5 Return: [1 2 Fizz 4 Buzz]
 * 
 * 
 * @author Vivek.g
 *
 */
public class FizzBuzz
{

	public static void main(String[] args)
	{
		FizzBuzz fizz = new FizzBuzz();
		System.out.println(fizz.fizzBuzz(5));
	}

	public List<String> fizzBuzz(int num)
	{
		ArrayList<String> result = new ArrayList<>();
		for(int i=1; i<= num ;i++)
		{
			if(i % 15 == 0)
			{
				result.add("FizzBuzz");
			}
			else if (i % 3 == 0)
			{
				result.add("Fizz");
			}
			else if(i % 5 == 0)
			{
				result.add("Buzz");
			}
			else
			{
				result.add(""+i);
			}
		}
		return result;
	}
}
