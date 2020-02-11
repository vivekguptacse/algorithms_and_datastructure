package algorithms.stack.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.stack.ArrayBasedStackImplementation;

/**
 * Stacks can be used to check whether the given expression has balanced
 * symbols. This algorithm is very useful in compilers. Each time the parser
 * reads one character at a time. If the character is an opening delimiter such
 * as (, {, or [- then it is written to the stack. When a closing delimiter is
 * encountered like ), }, or ]- the stack is popped. The opening and closing
 * delimiters are then compared. If they match, the parsing of the string
 * continues. If they do not match, the parser indicates that there is an error
 * on the line. A linear-time O(n) algorithm based on stack can be given as
 * 
 * @author Vivek
 *
 */
public class BalancingParanthesis
{
	private static final List<Character> startingBraces = Arrays.asList('(','{','[');
	
	private static final List<Character> closingBraces = Arrays.asList(')','}',']');
	
	private static final Map<Character, Character> closingBracesMap = new HashMap<>();

	static
	{
		closingBracesMap.put(')', '(');
		closingBracesMap.put('}', '{');
		closingBracesMap.put(']', '[');
		
	}
	public boolean isvalidSymbolPattern(String symbols) throws Exception
	{
		char[] charArray = symbols.toCharArray();
		
		ArrayBasedStackImplementation<Character> stack = new ArrayBasedStackImplementation<>(charArray.length);
		
		for(char ch : charArray)
		{
			if(startingBraces.contains(ch))
			{
				stack.push(ch);
			}
			else if(closingBraces.contains(ch))
			{
				Character top = stack.top();
				if(top.equals(closingBracesMap.get(ch)))
				{
					stack.pop();
				}
				else
				{
					stack.push(ch);
				}
			}
			
		}
		
		
		return stack.isEmpty() ? true : false;
		
		
	}
	
	public static void main(String[] args) throws Exception
	{
		String symbol = "() (() [()])";
		BalancingParanthesis balacing = new BalancingParanthesis();
		System.out.println(
				balacing.isvalidSymbolPattern(symbol));
		
	}
	

}
