package interviewbit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example:
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 * 
 * Make sure the returned intervals are sorted.
 * 
 * @author Vivek
 *
 */
public class MergeOverlappingIntervals
{
	public ArrayList<Interval> merge(ArrayList<Interval> intervals)
	{

		ArrayList<Interval> results = new ArrayList<>();
		
		Collections.sort(intervals, (o1,o2) -> o1.start - o2.start);

		if (intervals.isEmpty())
		{
			return results;
		}

		Interval current = intervals.get(0);

		Stack<Integer> stack = new Stack<>();

		stack.push(current.start);
		stack.push(current.end);
		for (int i = 1; i < intervals.size(); i++)
		{
			Interval temp = intervals.get(i);

			if (stack.peek() < temp.start)
			{
				stack.push(temp.start);
				stack.push(temp.end);
			} else if (stack.peek() < temp.end)
			{
				stack.pop();
				stack.push(temp.end);
			}
		}
		while (!stack.isEmpty())
		{
			int a = stack.pop();
			int b = stack.pop();
			results.add(new Interval(b, a));
		}
		Collections.reverse(results);
		return results;

	}

	public static void main(String[] args)
	{
		ArrayList<Interval> createinput = createinput();

		MergeOverlappingIntervals merge = new MergeOverlappingIntervals();
		System.out.println(merge.merge(createinput));
	}

	private static ArrayList<Interval> createinput()
	{
		List<Integer> asList = Arrays.asList(1, 6, 2, 3, 4,5,7,8);

		ArrayList<Interval> input = new ArrayList<>();

		for (int i = 0; i < asList.size(); i++)
		{
			Interval interval = new Interval(asList.get(i++), asList.get(i));
			input.add(interval);
		}

		return input;
	}

}

