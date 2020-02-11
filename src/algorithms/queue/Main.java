package algorithms.queue;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		FixedSizeArrayQueue queue = new FixedSizeArrayQueue(5);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.size());
		System.out.println(queue);
//		queue.enqueue(1);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
		System.out.println(queue.size());
		System.out.println(queue);
	}

}
