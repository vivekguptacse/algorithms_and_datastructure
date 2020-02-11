package interviewbit.problems.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{
	public static void main(String[] args)
	{
//		Test tes = new Test();
//		System.out.println(tes.squareSum(25));
//		 List<Character> charList = Arrays.asList('a','b','c');
//		   getShortCode(charList, 2);
		
//		base62_encode(334539992);
//		printLetter();
//		
		regexGene();
		
	}
//	public ArrayList<ArrayList<Integer>> squareSum(int A)
//	{
//		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
//
//		for (int a = 1; a * a <= A; a++)
//		{
//			for (int b = 1; b * b <= A; b++)
//			{
//				if (a * a + b * b == A)
//				{
//					if(a <= b)
//					{
//						ArrayList<Integer> newEntry = new ArrayList<Integer>();
//						newEntry.add(a);
//						newEntry.add(b);
//						ans.add(newEntry);
//					}
//				}
//			}
//		}
//		return ans;
//	}
	
	public static void getShortCode(List<Character> character, int lengthOf)
	{
		Character[] charArray = character.toArray(new Character[character.size()]);
		
		List<String> result = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < lengthOf; i++)
		{

			int j = 0;

			char[] toRoate = toRotate(charArray, i);

			while (j < charArray.length - 1)
			{
				sb.append(charArray[i]);
				toRoate = rotate(toRoate);
				sb.append(toRoate);

				if (!result.contains(sb.toString()))
				{
					result.add(sb.toString());
				}
				sb.delete(0, sb.length());
				j++;
			}

			sb.append(charArray[i]);
			sb.append(toRotate(charArray, i));
			if (!result.contains(sb.toString()))
			{
				result.add(sb.toString());
			}

			sb.delete(0, sb.length());
		}

		System.out.println(result);

	}
	
	private static char[] rotate(char[] toRoate)
	{
		if(toRoate.length <= 1)
		{
			return  toRoate;
		}
		
		char temp = toRoate[0];
		
		for(int i=0; i < toRoate.length - 1 ; i++)
		{
			toRoate[i] = toRoate[i+1];
		}
		
		toRoate[toRoate.length - 1] = temp;
		
		return toRoate;
	}
	
	private static char [] toRotate(Character[] charArray, int toSkip)
	{
		char [] result = new char[charArray.length - 1];
		for(int i = 0,count=0 ; i < charArray.length ; i++)
		{
			if(i != toSkip)
			{
				result[count++] = charArray[i];
			}
		}
		return result;
	}
	
	
	public static void base62_encode(long value)
	{
		String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result ="";
		while(value > 0)
		{
			result = result + s.charAt((int)value % 62) ;
			value /=62;
		}
		
		System.out.println(result);
	}
	
	
	public static void printLetter()
	{
		for(char i = 'A' ; i <= 'Z' ; i++ )
		{
			for(char j = 'A' ; j <= 'Z' ; j++ )
			{
				for(char k = 'A' ; k <= 'Z' ; k++)
				{
					System.out.print("" + i + j + k + " ");
				}
				System.out.println();
			}
		}
	}
	
	public static void regexGene()
	{
		String txt="15:54:00,038 DEBUG [com.avaya.sal.core.alarm.service.impl.BpAlarmingSchedulerService 106] (EJB default - 2) Marking Expired Alarms";

	    String re1=".*?";	// Non-greedy match on filler
	    String re2="(5)";	// Any Single Character 1

	    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(txt);
	    if (m.find())
	    {
	        String c1=m.group(1);
	        System.out.print("("+c1.toString()+")"+"\n");
	    }
	}
}
	
	
