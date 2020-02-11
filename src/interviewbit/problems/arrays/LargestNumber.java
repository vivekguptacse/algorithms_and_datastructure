package interviewbit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example:
 * 
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author Vivek
 *
 */
public class LargestNumber
{
	
	public String largestNumber(final List<Integer> A)
	{
		boolean isAllZero = true;
		for(int i = 0 ; i <A.size() ; i++)
		{
			if(A.get(i) > 0)
			{
				isAllZero = false;
				break;
			}
		}
		if(isAllZero)
		{
			return "0";
		}
		
		List<String> stringList = new ArrayList<>(A.size());
		
		A.forEach((num) -> stringList.add(""+num));
		
		stringList.sort((o1,o2) -> {
			
			String o1o2 = o1+o2;
			String o2o1 = o2+o1;
			
			if(o1o2.compareTo(o2o1) > 0)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		
		});

		StringBuilder sb = new StringBuilder();
		
		stringList.forEach((num) -> sb.append(num));
		
		
		
		
		
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
//		List<Integer> asList = Arrays.asList(3, 30, 34, 5, 9);
		List<Integer> asList = Arrays.asList(99,98,9,5,89);
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(asList));
	}

}
