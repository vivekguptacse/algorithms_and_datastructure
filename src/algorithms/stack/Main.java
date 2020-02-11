package algorithms.stack;

public class Main
{
	
	public static void main(String[] args) throws Exception
	{
		ArrayBasedStackImplementation stack = new ArrayBasedStackImplementation(5);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
//		stack.push(6);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(6);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop());
	}

}
