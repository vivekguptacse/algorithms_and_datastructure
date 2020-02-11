package java8.feature.stringjoiner;

import java.util.StringJoiner;

/**
 * Java added a new final class StringJoiner in java.util package. It is used to
 * construct a sequence of characters separated by a delimiter. Now, you can
 * create string by passing delimiters like comma(,), hyphen(-) etc. You can
 * also pass prefix and suffix to the char sequence.
 * 
 * @author Vivek.g
 *
 */
public class StringJoinerExample
{
	public static void main(String[] args)
	{
		System.out.println("****************** Example 1 *******************");
		// Example 1 : String joiner with only delimeter
		joinStringWithDelimeter();
		System.out.println("****************** Example 2 *******************");
		// Example 2 : adding prefix and suffix
		joinWithPrefixSuffix();
		System.out.println("****************** Example 3 *******************");
		// Example 3 : Merge Two StringJoiner
		mergeJoiners();
		
	}

	private static void mergeJoiners()
	{
		StringJoiner joiner1 = new StringJoiner(",");
		
		joiner1 = addElements(joiner1);
		
		StringJoiner joiner2 = new StringJoiner(":", "[", "]");
		
		joiner2 = addElements(joiner2);
		
		StringJoiner merge1 = joiner1.merge(joiner2);
		
		System.out.println(merge1);
		
		StringJoiner merge2 = joiner2.merge(joiner1);
		
		System.out.println(merge2);
		
		
		
	}

	private static void joinWithPrefixSuffix()
	{
		StringJoiner joiner = new StringJoiner(",", "[", "]");
		
		System.out.println(addElements(joiner));
	}

	/**
	 * Join Elements with only delimiter
	 */
	private static void joinStringWithDelimeter()
	{
		StringJoiner joiner = new StringJoiner("-->");
		
		System.out.println(addElements(joiner));
	}
	
	private static StringJoiner addElements(StringJoiner joiner)
	{
		joiner.add("Rahul");
		joiner.add("Rohit");
		joiner.add("Raj");
		joiner.add("Rahane");
		
		return joiner;
	}

}
