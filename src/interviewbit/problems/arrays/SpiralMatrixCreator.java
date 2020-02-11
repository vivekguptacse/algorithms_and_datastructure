package interviewbit.problems.arrays;

import java.util.ArrayList;

/**
 * Given an integer A, generate a square matrix filled with elements from 1 to
 * A2 in spiral order.
 * 
 * 
 * 
 * Input Format:
 * 
 * The first and the only argument contains an integer, A. Output Format:
 * 
 * Return a 2-d matrix of size A x A satisfying the spiral order. Constraints:
 * 
 * 1 <= A <= 1000 Examples:
 * 
 * Input 1: A = 3
 * 
 * Output 1: 
 * [ [ 1, 2, 3 ], 
 *   [ 8, 9, 4 ], 
 *   [ 7, 6, 5 ] ]
 * 
 * Input 2: 4
 * 
 * Output 2: 
 * [ [1, 2, 3, 4], 
 *   [12, 13, 14, 5], 
 *   [11, 16, 15, 6], 
 *   [10, 9, 8, 7] ]
 * 
 * @author Vivek
 *
 */
public class SpiralMatrixCreator
{
	public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		
		int row = A; 
		int column = A;
		
		int top = 0; 
		int bottom = row -1;
		int left = 0;
		int right = column - 1;
		int dir = 0;
		
		int [][] matrix = new int[row][column];
		
		int num = 1;
		while(top <= bottom && left <= right)
		{
			if(dir == 0)
			{
				for(int i=left ; i<= right ; i++)
				{
					matrix[top][i]=num++;
				}
				top++;
			}
			 else if (dir == 1)
			{
				for (int i = top; i <= bottom; i++)
				{
					matrix[i][right] = num++;
				}
				right--;
			} else if (dir == 2)
			{
				for (int i = right; i >= left; i--)
				{
					matrix[bottom][i]=num++;
				}
				bottom--;
			} else if (dir == 3)
			{
				for (int i = bottom; i >= top; i--)
				{
					matrix[i][left]=num++;
				}
				left++;
			}

			dir = (dir + 1) % 4;
		
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i < row ; i++)
		{
			list = new ArrayList<>();
			for(int j=0 ; j < column ; j++)
			{
				list.add(matrix[i][j]);
			}
			result.add(list);
		}
		
		return result;
    }
	
	public static void main(String[] args)
	{
		SpiralMatrixCreator spiral = new SpiralMatrixCreator();
		System.out.println(spiral.generateMatrix(4));
	}

}
