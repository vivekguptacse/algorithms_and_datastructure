package algorithms.stack;

public class AdvanceMinStack
{
	private ArrayBasedStackImplementation<Integer> stack;
	
	private ArrayBasedStackImplementation<Integer> minStack; 

	// deafult stack capacity 
	private static final int CAPACITY = 10;
	
	public AdvanceMinStack()
	{
		this(CAPACITY);
	}

	public AdvanceMinStack(int capacity)
	{
		stack = new ArrayBasedStackImplementation<>(capacity);
		minStack = new ArrayBasedStackImplementation<>(capacity);
	}
 
	public int size()
	{
		return stack.size();
	}
	
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
	public boolean isFull()
	{
		return stack.isFull();
	}
	
	public void push(int data) throws Exception
	{
		stack.push(data);
		if(minStack.isEmpty() || minStack.top() > data)
		{
			minStack.push(data);
		}
//		else
//		{
//			minStack.push(minStack.top());
//		}
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is Empty.");
		}
		if(minStack.top() == stack.top())
		{
			minStack.pop();
		}
		return stack.pop();
	}
	
	
	public int top() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is Empty.");
		}
		return stack.top();
	}
	
	public int getMinimum() throws Exception
	{

		if(isEmpty())
		{
			throw new Exception("Stack is Empty.");
		}
		return minStack.top();
	
	}
	
	@Override
	public String toString()
	{
		String s;
		s= "[ Stack ";
		if(size() > 0)
		{
			try
			{
				s += "Min Stack : " + getMinimum();
				s += "Stack : " + stack.top();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(size() > 1)
		{
			for (int i = 1; i < size() ; i++ )
			{
				try
				{
					s += "Min Stack " + getMinimum();
					s += " Stack : " + stack.top();
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return s+ "]";
	}
	
	public static void main(String[] args) throws Exception
	{
		AdvanceMinStack stack = new AdvanceMinStack(5);
		
		stack.push(2);
		stack.push(6);
		stack.push(4);
		System.out.println(stack.getMinimum());
		stack.push(1);
		stack.push(5);
		System.out.println(stack.getMinimum());
		stack.pop();
		stack.pop();
		System.out.println(stack.getMinimum());
		stack.pop();
		System.out.println(stack.getMinimum());
	}


}
