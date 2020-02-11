package interviewbit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given an array of integers, sort the array into a wave like array and return
 * it, In other words, arrange the elements into a sequence such that a1 >= a2
 * <= a3 >= a4 <= a5.....
 * 
 * Example
 * 
 * Given [1, 2, 3, 4]
 * 
 * One possible answer : [2, 1, 4, 3] 
 * Another possible answer : [4, 1, 3, 2]
 * 
 *   
 * @author Vivek
 *
 */
public class WaveArray
{
	
	public ArrayList<Integer> wave(List<Integer> A) 
	{
		ArrayList<Integer> result = new ArrayList<>();
		Collections.sort(A);
		Integer[] array = A.toArray(new Integer[A.size()]);
		
		
		for(int i = 0 , j= 1; j < A.size() ; i+=2, j+=2)
		{
			if(array[i] <= array[j])
			{
				int temp = A.get(i);
				array[i] = array[j];
				array[j] = temp;
				result.add(array[i]);
				result.add(array[j]);
			}
		}
		if(result.size() < A.size())
		{
			result.add(array[A.size()  - 1]);
		}
		
		return result;
    }

	
	public static void main(String[] args)
	{
		List<Integer> asList = Arrays.asList(5,1,2,3,4);
		WaveArray wave = new WaveArray();
		System.out.println(wave.wave(asList));
	}
}
