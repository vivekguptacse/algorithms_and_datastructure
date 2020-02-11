package interviewbit.problems.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array A containing N integers. The special product of each
 * ith integer in this array is defined as the product of the following:
 * <ul>
 * 
 * LeftSpecialValue: For an index i, it is defined as the index j such that
 * A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the
 * LeftSpecialValue is the maximum value of j.
 * 
 * RightSpecialValue: For an index i, it is defined as the index j such that
 * A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the
 * RightSpecialValue is the minimum value of j.
 * 
 * Write a program to find the maximum special product of any integer in the
 * array.
 * 
 * Input: You will receive array of integers as argument to function.
 * 
 * Return: Maximum special product of any integer in the array modulo
 * 1000000007.
 * 
 * Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are
 * considered to be 0.
 * 
 * Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
 * 
 * ex:
 * Input : 
 * A : [ 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 ] 
 * Output : 80
 * 
 * We get our ans at index - 9 which has value 4 for 4 : 
 * left spl value = index of 5 = 8 
 * right spl value = index of 9 = 10 
 * product = 8*10 = 80
 * 
 * @author Vivek
 *
 */
public class MaxSpecialproduct
{
	public int maxSpecialProduct(List<Integer> A) {
		
		Integer[] array = A.toArray(new Integer[A.size()]);
		int leftIndex = 0;
		int rightIndex = 0;
		long specialval = 0;
		
		for(int i = array.length/2 ; i < array.length ; i++)
		{
			leftIndex = 0; 
			rightIndex = 0;
			for(int j = i-1 ; j > 0 ; j--)
			{
				if(array[j] > array[i])
				{
					leftIndex = j;
					break;
				}
			}
			for(int j = i+1 ; j < array.length ; j++)
			{
				if(array[j] > array[i])
				{
					rightIndex = j;
					break;
				}
			}
			
			if(specialval < leftIndex * rightIndex)
			{
				specialval = leftIndex *rightIndex;
			}
			
		}
		
		long result = specialval % 1000000007;
		return Math.toIntExact(result) ;
    }
	
	public static void main(String[] args)
	{
		MaxSpecialproduct max = new MaxSpecialproduct();
		System.out.println(max.maxSpecialProduct(Arrays.asList(7, 5, 7, 9, 8, 7 )));
	}

}
