package interviewbit.problems.arrays;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from
 * previous row R - 1.
 * 
 * Example:
 * 
 * Given numRows = 5,
 * 
 * Return
 * 
 * [ [1], 
 *   [1,1], 
 *   [1,2,1], 
 *   [1,3,3,1], 
 *   [1,4,6,4,1] 
 * ]
 * 
 * @author Vivek
 *
 */
public class PascalTriangle
{
	public ArrayList<ArrayList<Integer>> solve(int A)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		// An auxiliary array to store generated pascal triangle values
		int[][] arr = new int[A][A];

		// Iterate through every line and print integer(s) in it
		for (int line = 0; line < A; line++)
		{
			ArrayList<Integer> temp = new ArrayList<>();
			// Every line has number of integers equal to line number
			for (int i = 0; i <= line; i++)
			{
				// First and last values in every row are 1
				if (line == i || i == 0)
					arr[line][i] = 1;
				else // Other values are sum of values just above and left of above
					arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
				temp.add(arr[line][i]);
			}
			result.add(temp);
		}

		return result;
	}

	public static void main(String[] args)
	{
		PascalTriangle triangle = new PascalTriangle();
		System.out.println(triangle.solve(5));
	}

}
