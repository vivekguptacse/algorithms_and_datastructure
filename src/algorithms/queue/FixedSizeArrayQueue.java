package algorithms.queue;

/**
 * Fized Sized Array based Queue Implementation. 
 * 
 * @author Vivek
 *
 */
public class FixedSizeArrayQueue
{

	private int size , front , rear ;
	
	private int [] queue; 
	
	// length of the array to implement queue
	private static int CAPACITY = 16; // default size
	
	public FixedSizeArrayQueue()
	{
		queue = new int[CAPACITY];
		size = 0;
		front = 0; 
		rear = 0;
	}
	
	public FixedSizeArrayQueue(int capacity)
	{
		CAPACITY = capacity;
		queue = new int[CAPACITY];
		size = 0;
		front = 0; 
		rear = 0;
	}
	
	/**
	 * Is Queue is Empty. 
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/** 
	 * Is Queue is Full 
	 * @return
	 */
	public boolean isFull()
	{
		return size == CAPACITY ;
	}
	
	/** 
	 * Adding Element to the queue. 
	 * 
	 * @param data
	 * @throws Exception
	 */
	public void enqueue(int data) throws Exception
	{
		if(isFull())
		{
			System.out.println("Throw Some error as queue is FULL");
			throw new Exception("Queue FULL Exception. ");
		}
		else
		{
			size++;
			queue[rear % CAPACITY] = data ;
			rear = (rear + 1) % CAPACITY;
		}
		
	}
	
	/**
	 * Removing Elements from Queue. 
	 * 
	 * @return
 	 * @throws Exception
	 */
	public int dequeue() throws Exception
	{
		int result = -1;
		if(isEmpty())
		{
			System.out.println("Throw Some error as queue is Empty");
			throw new Exception("Queue Empty Exception. ");
		}
		else
		{
			size--;
			result = queue[front % CAPACITY];
			queue[front % CAPACITY] = Integer.MIN_VALUE;
			front = (front+1) % CAPACITY;
		}
		
		return result;
	}
	
	/**
	 * Size of the Queue 
	 * @return
	 */
	public int size()
	{
		return size;
	}
	
	@Override
	public String toString()
	{
		String result = "[";
		for(int i=0; i<size; i++)
		{
			result += Integer.toString(queue[(front + i) % CAPACITY ]);
			if( i <size - 1)
			{
				result += " , ";
			}
			
		}
		
		result += ']';
		
		return result;
	}
}
