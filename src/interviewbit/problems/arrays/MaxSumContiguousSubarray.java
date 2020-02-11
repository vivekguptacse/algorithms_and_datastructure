package interviewbit.problems.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous subarray within an array, A of length N which has the
 * largest sum.
 * 
 * Input Format:
 * 
 * The first and the only argument contains an integer array, A. Output Format:
 * 
 * Return an integer representing the maximum possible sum of the contiguous
 * subarray. Constraints:
 * 
 * 1 <= N <= 1e6 -1000 <= A[i] <= 1000 For example:
 * 
 * Input 1: A = [1, 2, 3, 4, -10]
 * 
 * Output 1: 10
 * 
 * Explanation 1: The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * 
 * Input 2: A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * 
 * Output 2: 6
 * 
 * Explanation 2: The subarray [4,-1,2,1] has the maximum possible sum of 6.
 * 
 * @author Vivek
 *
 */
public class MaxSumContiguousSubarray
{

	/**
	 *  This method solves the problem with Brute force with O(n^2) 
	 * @param A
	 * @return
	 */
	public int maxSubArray(final List<Integer> A) 
	{	
		Integer[] array = A.toArray(new Integer[A.size()]);
		
		int result = array[0]; 
		for(int i = 0; i < array.length; i++)
		{
			int temp = 0; 
			for(int j = i ; j < array.length ; j++)
			{
				temp = temp + array[j];
				
				if(temp > result)
				{
					result = temp;
				}
			}
		}	
		return result;
    }
	
	public int maxSubArrayKadaneAlgo(final List<Integer> A) 
	{	
		Integer[] array = A.toArray(new Integer[A.size()]);
		
		int result = array[0];
		int current_max = array[0];
		
		for(int i =1 ; i <  array.length ; i++)
		{
			current_max = Math.max(array[i], current_max + array[i]);
			result = Math.max(result, current_max);
		}
		
		return result;
    }
	
	
	public static void main(String[] args)
	{
		MaxSumContiguousSubarray arr = new MaxSumContiguousSubarray();
		System.out.println(arr.maxSubArray(Arrays.asList(1, 2, 3, 4, -10)));
		System.out.println(arr.maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
		
		System.out.println(arr.maxSubArrayKadaneAlgo(Arrays.asList(1, 2, 3, 4, -10)));
		System.out.println(arr.maxSubArrayKadaneAlgo(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
	}
	
	
}
