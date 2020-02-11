package interviewbit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a matrix of m * n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example:
 * 
 * Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], 
 *   [ 4, 5, 6 ], 
 *   [ 7, 8, 9 ] ] 
 *   
 *   You should return
 * 
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * 
 * @author Vivek
 *
 */
public class SpiralTraversal
{
	
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> arr) {
		int rowNum = arr.size();
		int colNum = arr.get(0).size();
		ArrayList<Integer> result = new ArrayList<>();
		
		int top = 0;
		int bottom = rowNum -1;
		int left = 0;
		int right = colNum -1;
		int dir = 0;
		
		while(top <= bottom && left <= right)
		{
			if (dir == 0)
			{
				for (int i = left; i <= right; i++)
				{
					result.add(arr.get(top).get(i));
				}
				top++;
			} else if (dir == 1)
			{
				for (int i = top; i <= bottom; i++)
				{
					result.add(arr.get(i).get(right));
				}
				right--;
			} else if (dir == 2)
			{
				for (int i = right; i >= left; i--)
				{
					result.add(arr.get(bottom).get(i));
				}
				bottom--;
			} else if (dir == 3)
			{
				for (int i = bottom; i >= top; i--)
				{
					result.add(arr.get(i).get(left));
				}
				left++;
			}

			dir = (dir + 1) % 4;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		List<ArrayList<Integer>> array = new ArrayList<>();
		ArrayList<Integer> val= new ArrayList<>();
		val.addAll(Arrays.asList(1,2,3,4,5));
		array.add(val);
		val= new ArrayList<>();
		val.addAll(Arrays.asList(6,7,8,9,10));
		array.add(val);
		val= new ArrayList<>();
		val.addAll(Arrays.asList(11,12,13,14,15));
		array.add(val);
		val= new ArrayList<>();
		val.addAll(Arrays.asList(16,17,18,19,20));
		array.add(val);
		val= new ArrayList<>();
		val.addAll(Arrays.asList(21,22,23,24,25));
		array.add(val);
		
		SpiralTraversal spiral = new SpiralTraversal();
		
		System.out.println(spiral.spiralOrder(array));
		
	}

}
