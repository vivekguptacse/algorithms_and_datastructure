package algorithms.recursion;

/**
 * Given an array, check whether the array is in sorted order with recursion.
 * 
 * @author Vivek
 *
 */
public class CheckSortedArray
{
	
	public static void main(String[] args)
	{
		int [] array = {1,2,3,4,5,6};
		
		System.out.println("Is array sorted " + isArraySorted(array,array.length));
		
	}

	private static boolean isArraySorted(int[] array, int length)
	{
		// base condition 
		if(length == 1)
		{
			return true;
		}
		// check if the element in the last index is less then second last index, then return false , otherwise call recurcively. 
		return (array[length-1] < array[length-2] ? false : isArraySorted(array, length-1));
	}
}
