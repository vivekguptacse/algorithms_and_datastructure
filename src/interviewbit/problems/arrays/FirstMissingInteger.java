package interviewbit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * Example:
 * 
 * Given [1,2,0] return 3,
 * 
 * [3,4,-1,1] return 2,
 * 
 * [-8, -7, -6] returns 1
 * 
 * Your algorithm should run in O(n) time and use constant space.
 * 
 * @author Vivek
 *
 */
public class FirstMissingInteger
{
	public int firstMissingPositive(List<Integer> A) {
		Set<Integer> set = new TreeSet<>();
		A.forEach((val) ->
		{
			if (val > 0)
			{
				set.add(val);
			}
		});
		
		if(set.isEmpty())
		{
			return 1;
		}
		int count = 1;
		for(Integer num : set)
		{
				if(count++ != num)
				{
					return count-1;
				}
		}
		
		
		return count;
    }

	
	public static void main(String[] args)
	{
		List<Integer> asList = Arrays.asList(1,2,0);
		FirstMissingInteger first = new FirstMissingInteger();
		System.out.println(first.firstMissingPositive(asList));
	}
}
