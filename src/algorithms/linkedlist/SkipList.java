package algorithms.linkedlist;

import java.util.Random;

/**
 * Skip list is a data structure that can be used as an alternative to balanced
 * binary trees . As compared to a binary tree, skip lists allow quick search,
 * insertion and deletion of elements. This is achieved by using probabilistic
 * balancing rather than strictly enforce balancing. 
 * It is basically a linked list with additional pointers such that intermediate
 * nodes can be skipped. It uses a random number generator to make some
 * decisions. In an ordinary sorted linked list, search, insert, and delete are
 * in O(n) because the list must be scanned node-by-node from the head to find
 * the relevant node. If somehow we could scan down the list in bigger steps
 * (skip down, as it were), we would reduce the cost of scanning. This is the
 * fundamental idea behind Skip Lists.
 * 
 * @author Vivek
 *
 */
public class SkipList<T extends Comparable<T>,U>
{
	/**
	 * Internal node 
	 * 
	 */
	private class Node
	{
		/**
		 * Key
		 */
		public T key;
		/**
		 * value
		 */
		public U value;
		/**
		 * level 
		 */
		public long level;
		/**
		 * Next Node
		 */
		public Node next;
		/**
		 * Down Node
		 */
		public Node down;
		
		public Node(T key, U value, long level, Node next , Node down)
		{
			this.key = key;
			this.value = value;
			this.level = level;
			this.next = next;
			this.down = down;
		}

		@Override
		public String toString()
		{
			return "Node [key=" + key + ", value=" + value + ", level=" + level + ", next=" + next + ", down=" + down
					+ "]";
		}
	}
	
	/**
	 * Head of the list
	 */
	private Node head;
	/**
	 * Random number generator for inserting values.
	 */
	private Random random;
	/**
	 * Size if the list
	 */
	private long size;
	/**
	 * probability. 
	 */
	private double p;
	
	/**
	 * Get the level. 
	 * 
	 * @return
	 */
	private long level()
	{
		long level = 0;
		while(level <= size && random.nextDouble() < p)
		{
			level++;
		}
		
		return level;
	}
	
	/**
	 * Constructor
	 */
	public SkipList()
	{
		this.head = new Node(null, null, 0, null, null);
		random = new Random();
		size = 0;
		p = 0.5;
	}
	
	/**
	 * Add the key and value in the Skip List 
	 * 
	 * @param key
	 * @param value
	 */
	public void add(T key, U value)
	{
		long level = level();
		if(level > head.level)
		{
			head = new Node(null, null, level, null, head);
		}
		
		Node curr = head;
		Node last = null;
		
		while(curr != null)
		{
			if(curr.next == null || curr.next.key.compareTo(key) > 0)
			{
				if(level >= curr.level)
				{
					Node node = new Node(key, value, curr.level, curr.next, null);
					if(last != null)
					{
						last.down = node;
					}
					curr.next = node;
					last = node;
				}
				curr = curr.down;
				continue;
			} else if(curr.next.key.equals(key))
			{
				curr.next.value = value;
				return;
			}
			curr = curr.next;
		}
		size++;
	}
	
	/**
	 * Check whether the List contains the key 
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(T key)
	{
		return get(key) != null;
	}
	
	/**
	 * Remove the element from the Skip List. 
	 * 
	 * @param key
	 * @return
	 */
	public U remove(T key)
	{
		U value = null;
		Node curr = head;
		while(curr != null)
		{
			if(curr.next == null || curr.next.key.compareTo(key) >= 0)
			{
				if(curr.next != null && curr.next.key.equals(key))
				{
					value = curr.next.value;
					curr.next = curr.next.next;
				}
				curr = curr.next;
				continue;
			}
			curr = curr.next;
		}
		size--;
		return value;
	}
	
	/**
	 * Search or find the element. 
	 * 
	 * @param key
	 * @return
	 */
	public U get(T key)
	{
		Node curr = head;
		while(curr != null)
		{
			if(curr.next == null || curr.next.key.compareTo(key) > 0)
			{
				curr = curr.down;
				continue;
			}else if(curr.next.key.equals(key))
			{
				return curr.next.value;
			}
			curr = curr.next;
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		SkipList<Integer,Integer> s = new SkipList<>();
		s.add(1, 100);
		s.add(2, 200);
		s.add(3, 300);
		s.add(4, 400);
		s.add(5, 500);
		System.out.println(s.head);
		System.out.println(s.get(1));
		System.out.println(s.get(5));
	}
	
}
