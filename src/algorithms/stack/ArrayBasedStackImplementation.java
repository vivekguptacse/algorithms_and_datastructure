package algorithms.stack;

/**
 * Array Based stack implementation
 * 
 * @author Vivek
 *
 */
public class ArrayBasedStackImplementation<T>
{
	// Stack capacity 
	private int capacity;
	
	// deafult stack capacity 
	private static final int CAPACITY = 10;
	
	// Array used to implement stack 
	private Object[] arrayData ;
	
	// Index of top element in stack
	private int top = -1;
	
	public ArrayBasedStackImplementation()
	{
		this(CAPACITY);
	}

	public ArrayBasedStackImplementation(int capacity2)
	{
		this.capacity = capacity2;
		arrayData = new Object[this.capacity];
	}
 
	public int size()
	{
		return top+1;
	}
	
	public boolean isEmpty()
	{
		return top < 0;
	}
	
	public boolean isFull()
	{
		return size() >= capacity;
	}
	
	public void push(T data) throws Exception
	{
		if(isFull())
		{
			throw new Exception("Stack is full.");
		}
		arrayData[++top] = data;
	}
	
	public T pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is Empty.");
		}
		Object data = arrayData[top];
		arrayData[top--] = Integer.MIN_VALUE;
		return (T)data;
	}
	
	
	public T top() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is Empty.");
		}
		return (T)arrayData[top];
	}
	
	@Override
	public String toString()
	{
		String s;
		s= "[";
		if(size() > 0)
		{
			s += arrayData[0];
		}
		if(size() > 1)
		{
			for (int i = 1; i < size() ; i++ )
			{
				s += " , " + arrayData[i];
			}
		}
		
		return s+ "]";
	}
}
