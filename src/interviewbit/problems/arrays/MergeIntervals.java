package interviewbit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in
 * [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result
 * in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 * 
 * @author Vivek
 *
 */
public class MergeIntervals
{
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
	{

		ArrayList<Interval> result = new ArrayList<>();
		if (newInterval.start > newInterval.end)
		{
			int temp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = temp;
		}
		if (intervals.isEmpty())
		{
			result.add(newInterval);
			return result;

		}
		if (newInterval.start <= (intervals.get(0).start)
				&& newInterval.end >= (intervals.get(intervals.size() - 1).end))
		{
			result.add(newInterval);
			return result;
		}
		int startIntervalPoition = findInterval(intervals, newInterval.start);

		int endIntervalPoition = findInterval(intervals, newInterval.end);
		if (startIntervalPoition == -1 && endIntervalPoition == -1)
		{
			if (newInterval.start > newInterval.end)
			{
				int temp = newInterval.start;
				newInterval.start = newInterval.end;
				newInterval.end = temp;
			}

			if (newInterval.end < intervals.get(0).start)
			{
				intervals.add(0, newInterval);
			} else
			{
				intervals.add(newInterval);
			}

			return intervals;
		} else if (startIntervalPoition == endIntervalPoition)
		{
			if (startIntervalPoition == intervals.size())
			{
				intervals.add(newInterval);
				return intervals;
			}
			if (newInterval.end > intervals.get(startIntervalPoition).start)
			{
				intervals.get(startIntervalPoition).start = newInterval.start;
				return intervals;
			} else
			{
				intervals.add(startIntervalPoition, newInterval);
				return intervals;
			}
		} else if (endIntervalPoition == intervals.size())
		{
			intervals.get(startIntervalPoition).end = newInterval.end;
			if (intervals.get(startIntervalPoition).start > newInterval.start)
			{
				intervals.get(startIntervalPoition).start = newInterval.start;
			}

			Iterator<Interval> iterator = intervals.iterator();
			int i = 0;
			while (iterator.hasNext())
			{
				if (i <= startIntervalPoition)
				{
					// System.out.println(iterator.next());
					iterator.next();
					i++;
				} else
				{
					iterator.next();
					iterator.remove();
				}

			}

			return intervals;

		}
		Interval starModified = intervals.get(startIntervalPoition);
		if (starModified.start > newInterval.start)
		{
			intervals.get(startIntervalPoition).start = newInterval.start;

		}
		if (endIntervalPoition == -1)
		{
			starModified.end = newInterval.end;
		} else
		{
			Interval endModified = intervals.get(endIntervalPoition);
			if (endModified.start > newInterval.end)
			{
				starModified.end = newInterval.end;
				endIntervalPoition--;
			} else
			{
				starModified.end = endModified.end;
			}
		}

		int i = 0;
		while (i < startIntervalPoition)
		{
			result.add(intervals.get(i++));
		}

		result.add(starModified);

		if (endIntervalPoition != -1)
		{
			i = endIntervalPoition + 1;
		} else
		{
			i++;
		}
		while (i < intervals.size())
		{
			result.add(intervals.get(i++));
		}
		return result;

	}

	private int findInterval(ArrayList<Interval> intervals, int start)
	{
		int low = 0;
		int high = intervals.size() - 1;
		int mid = (low + high) / 2;

		while (low <= high)
		{
			mid = (low + high) / 2;
			Interval interval = intervals.get(mid);
			if (start >= interval.start && start <= interval.end)
			{
				return mid;
			} else if (start < interval.start)
			{
				high = mid - 1;
			} else if (start > interval.end)
			{
				low = mid + 1;
			}
		}

		return low;
	}

	public static void main(String[] args)
	{
		// Interval interval = new Interval(1, 2);
		// Interval interval1 = new Interval(31935139, 38366404);
		// Interval interval1 = new Interval(3, 6);
		// Interval interval2 = new Interval(7, 8);
		// Interval interval3 = new Interval(54099301, 76986474);
		// Interval interval3 = new Interval(3, 4);
		// Interval interval4 = new Interval(87248431, 94675146);
		// Interval interval5 = new Interval(4, 9);
		// Interval interval1 = new Interval(56110630, 56331932);
		// Interval interval2 = new Interval(56989072, 57519608);
		// Interval interval3 = new Interval(57694731, 57715971);
		// Interval interval4 = new Interval(58052278, 58933241);
		// Interval interval5 = new Interval(67024730, 70150161);
		// Interval interval6 = new Interval(70318456, 70340388);
		// Interval interval7 = new Interval(71984531, 72430821);
		// Interval interval8 = new Interval(73082931, 73382670);

		// (), (), (), (), (), (), (),()

		ArrayList<Interval> input = createinput();

		// Interval newInterval = new Interval(36210193, 61984219);
		// Interval newInterval = new Interval(16338702, 96742429);
		// Interval newInterval = new Interval(108785977, 16197462);
		Interval newInterval = new Interval(104389575, 78104302);

		// (7992707, 8945780), (13205169, 13286380), (13478080, 14361199), (), (), (),
		// ()

		// Interval interval = new Interval(1, 3);
		// ArrayList<Interval> input = new ArrayList<>();
		//// input.add(interval);
		// input.add(interval1);
		// input.add(interval2);
		// input.add(interval3);
		// input.add(interval4);
		// input.add(interval5);
		// input.add(interval6);
		// input.add(interval7);
		// input.add(interval8);
		//// input.add(interval3);
		// input.add(interval4);

		MergeIntervals merge = new MergeIntervals();
		System.out.println(merge.insert(input, newInterval));
	}

	private static ArrayList<Interval> createinput()
	{
		// List<Integer> asList = Arrays.asList(6037774, 6198243, 6726550, 7004541,
		// 8842554, 10866536, 11027721, 11341296,
		// 11972532, 14746848, 16374805, 16706396, 17557262, 20518214, 22139780,
		// 22379559, 27212352, 28404611,
		// 28921768, 29621583, 29823256, 32060921, 33950165, 36418956, 37225039,
		// 37785557, 40087908, 41184444,
		// 41922814, 45297414, 48142402, 48244133, 48622983, 50443163, 50898369,
		// 55612831, 57030757, 58120901,
		// 59772759, 59943999, 61141939, 64859907, 65277782, 65296274, 67497842,
		// 68386607, 70414085, 73339545,
		// 73896106, 75605861, 79672668, 84539434, 84821550, 86558001, 91116470,
		// 92198054, 96147808, 98979097);

		// List<Integer> asList = Arrays.asList(2503984, 6044502, 8299441, 16663259,
		// 16793501, 19614603, 19728782,
		// 20375958, 25968417, 28010146, 30254350, 33374607, 33743564, 34552113,
		// 34895961, 37161555, 37636639,
		// 43342869, 44647063, 44992642, 49293038, 51523422, 53305202, 55498385,
		// 59045828, 59565709, 61864653,
		// 62763559, 65368847, 67301301, 68261707, 69696418, 71761861, 74222143,
		// 76440643, 76882070, 81206484,
		// 82877369, 83619110, 89235740, 89986065, 89994469, 94674386, 95801093,
		// 96983158, 98983423, 99682953,
		// 99956221);

		// List<Integer> asList = Arrays.asList(137207, 1734370, 5057723, 5365773,
		// 6997657, 7282669, 7992707, 8945780,
		// 13205169, 13286380, 13478080, 14361199, 14648047, 16875188, 17296166,
		// 19089625, 20424412, 20617334,
		// 21947854, 23077086, 24901000, 26346402, 26650724, 27196856, 28896156,
		// 29975691, 30071726, 31373629,
		// 32397799, 33159528, 33305337, 35470848, 35720431, 37452993, 39147629,
		// 40818780, 40930468, 41652526,
		// 41938404, 44430212, 48114813, 48611161, 50335149, 51023917, 51878891,
		// 52987379, 53902725, 54359910,
		// 56661881, 58671175, 59326619, 61927945, 63215257, 63817507, 64968095,
		// 65653303, 66634969, 67941460,
		// 69980615, 71436951, 71564309, 74681566, 75530199, 76592769, 76988511,
		// 77454928, 77665838, 78087358,
		// 78229841, 79535243, 81250676, 82624050, 83142364, 84255671, 84379892,
		// 84668384, 84954893, 85392199,
		// 87804458, 90457067, 90760520, 91607160, 92361716, 92692045, 95399553,
		// 97983139, 99776803, 99818745);
		//
		List<Integer> asList = Arrays.asList(242769, 298578, 1485821, 3549159, 3601003, 3781492, 3918406, 4233355,
				4859263, 6371214, 6524141, 6876393, 11134739, 12804010, 13308849, 14330671, 14577529, 15007662,
				15458500, 16738297, 18468996, 23667578, 25476991, 25797327, 26147944, 28198553, 28272397, 29024013,
				29403740, 30131864, 31627582, 32418203, 33266069, 33752547, 34495644, 34871446, 35550469, 36108659,
				36926556, 37261232, 38583039, 39006804, 39509631, 41893216, 42374004, 42931714, 44269968, 44369083,
				45143617, 45563132, 47682511, 51195515, 51927143, 54183020, 58277563, 58496820, 59191747, 62019729,
				63220700, 64115749, 64510556, 65776930, 66171734, 67878747, 70757042, 76924935, 77187481, 77197369,
				77698059, 77933160, 78173032, 78658045, 80964341, 85215059, 85715400, 87324172, 88079827, 90407584,
				90761708, 91759576, 93179322, 94449428, 95477202, 95486054, 96068708, 98287029);

		ArrayList<Interval> input = new ArrayList<>();

		for (int i = 0; i < asList.size(); i++)
		{
			Interval interval = new Interval(asList.get(i++), asList.get(i));
			input.add(interval);
		}

		return input;
	}

}


/**
 * Definition for an interval.
 * 
 */
class Interval
{
	int start;
	int end;

	Interval()
	{
		start = 0;
		end = 0;
	}

	Interval(int s, int e)
	{
		start = s;
		end = e;
	}

	@Override
	public String toString()
	{
		return "Interval [start=" + start + ", end=" + end + "]";
	}
}