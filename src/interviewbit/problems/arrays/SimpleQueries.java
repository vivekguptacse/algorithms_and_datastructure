package interviewbit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array A having N integers.

You have to perform the following steps in a given order.

generate all subarrays of A.
take the maximum element from each subarray of A and insert it into a new array G.
replace every element of G with the product of their divisors mod 1e9 + 7.
sort G in descending order
perform Q queries
In each query, you are given an integer K, where you have to find the Kth element in G.

Note: Your solution will run on multiple test cases so do clear global variables after using them.


Input Format

The first argument given is an Array A, having N integers.
The second argument given is an Array B, where B[i] is the ith query.
Output Format

Return an Array X, where X[i] will have the answer for the ith query.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e5
1 <= Q <= 1e5
1 <= k <= (N * (N + 1))/2 
For Example

Input:
    A = [1, 2, 4]
    B = [1, 2, 3, 4, 5, 6]
Output:
    X = [8, 8, 8, 2, 2, 1]
   
Explanation:
    subarrays of A	  maximum element
    ------------------------------------
    1. [1]							1
    2. [1, 2]						2
    3. [1, 2, 4]					4
    4. [2]							2
    5. [2, 4]						4
    6. [4]							4

	original
	G = [1, 2, 4, 2, 4, 4]
	
	after changing every element of G with product of their divisors
	G = [1, 2, 8, 2, 8, 8]
	
	after sorting G in descending order
	G = [8, 8, 8, 2, 2, 1]
	
 * @author Vivek
 *
 */
public class SimpleQueries
{
	
	public ArrayList<Integer> solve(List<Integer> A, List<Integer> B) 
	{
		Integer[] array = A.toArray(new Integer[A.size()]);
		ArrayList<Integer> G = new ArrayList<>();
		
		for(int i =0; i < array.length ; i++)
		{
			int k = i ; 
			
			for(int j = i ; j < array.length ; j++, k = i)
			{
				int max = -1;
				while(k <= j)
				{
					if(array[k] > max)
					{
						max = array[k++];
					}
				}
				G.add(max);
			}
			
		}
		
		
		System.out.println(G);
		return null;
    }
	
	public static void main(String[] args)
	{
		SimpleQueries sim = new SimpleQueries();
		sim.solve(Arrays.asList(1,2,4), Arrays.asList(1,2,3,4,5,6));
	}

}
