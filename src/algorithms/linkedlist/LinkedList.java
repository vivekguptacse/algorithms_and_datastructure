package algorithms.linkedlist;

/**
 * 
 * @author Vivek
 *
 */
public class LinkedList
{
	private LinkedListNode head;
	
	private int length = 0;
	
	public LinkedList()
	{
		this.length = 0;
	}

	/**
	 * Insert the node at the beginning.
	 * 
	 * @param node
	 */
	public void insertAtBeginning(LinkedListNode node)
	{
		if(head == null)
		{
			head = node;
			length++;
			return;
		}
		
		node.setNext(head);
		head = node;
		length++;
		
	}
	
	/**
	 * Insert the node at the end of the list. 
	 * 
	 * @param node
	 */
	public void insertAtEnd(LinkedListNode node)
	{
		if(head == null)
		{
			head = node;
		}
		else
		{
			LinkedListNode currentnode = head;
			
			while(currentnode.getNext() != null)
			{
				currentnode = currentnode.getNext();
			}
			
			currentnode.setNext(node);
		}
		length++;
	}
	
	/**
	 * Insert the data at the specified position. 
	 * 
	 * @param data
	 * @param position
	 */
	public void insert(int data, int position)
	{
		LinkedListNode node = new LinkedListNode(data);
		if(head == null)
		{
			head = new LinkedListNode(data);
			length++;
			return;
		}
		if(position > length)
		{
			position = length;
		}
		if(position < 0)
		{
			position = 0;
			
			if(null != head)
			{
				node.setNext(head.getNext());
				head = node;
				length++;
				return;
			}
		}

		LinkedListNode currentNode = head;
		int nodePos =0;
		while(nodePos < position)
		{
			currentNode = currentNode.getNext();
			nodePos++;
		}
		node.setNext(currentNode.getNext());
		currentNode.setNext(node);
		length++;
	}
	
	/**
	 * Removes the element from the beginning of the list. 
	 * @return
	 */
	public LinkedListNode removefrombegin()
	{
		
		if(null == head)
		{
			return null;
		}
		LinkedListNode result = head;
		head = result.getNext();
		result.setNext(null);
		length--;
		
		return result;
	}
	
	/**
	 * Removes the last node of the list
	 * @return
	 */
	public LinkedListNode removefromLast()
	{
		if(null == head)
		{
			return null;
		}
		
		LinkedListNode current = head;
		LinkedListNode prev = null;
		
		while(null != current.getNext())
		{
			prev = current;
			current = current.getNext();
		}
		
		prev.setNext(null);
		length--;
		
		return current;
	}
	
	/**
	 * Removes the Node which matched the data of the passed node.  
	 * @param node
	 */
	public void removeMatched(LinkedListNode node)
	{
		if(null == head)
		{
			return;
		}
		
		LinkedListNode current = head;
		LinkedListNode prev = null;
		
		while(null != current.getNext())
		{
			// Check if current data is equal to node data
			if(current.getData() == node.getData())
			{
				prev.setNext(current.getNext());
				current.setNext(null);
				length--;
				return;
			}
			prev = current;
			current = current.getNext();
		}
		
		prev.setNext(null);
		length--;
		
	
		
	}
	
	/**
	 * Removes the element at the position 
	 * 
	 * @param position
	 */
	public void remove(int position)
	{
		if(head == null)
		{
			return;
		}
		if(position > length)
		{
			position = length;
		}
		if(position < 0)
		{
			position = 0;
			
			if(null != head)
			{
				LinkedListNode current = head;
				current = head.getNext();
				head.setNext(null);
				head = current;
				length--;
				return;
			}
		}

		LinkedListNode currentNode = head;
		int nodePos =0;
		while(nodePos < position)
		{
			currentNode = currentNode.getNext();
			nodePos++;
		}
		if(currentNode.getNext() != null)
		{
			currentNode.setNext(currentNode.getNext().getNext());
			length--;
		}
		else
		{
			currentNode.setNext(null);
			length--;
		}
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		String result = "[ ";
		LinkedListNode current = head;
		
		while(current.getNext() != null)
		{
			result = result+ current.getData() + " --> ";
			current = current.getNext();
		}
		result = result + current.getData();
		result = result + "]";
		
		return result;
	}
	
	/**
	 * Return the length of the List.
	 * 
	 *  Adding 1 as  the lenth 
	 * @return
	 */
	public int getlength()
	{
		return length ;
	}
	
	/**
	 * Return the position of the node which has the data passed as argument. 
	 * 
	 * @param data
	 * @return -1 if linked list is empty or data not found.
	 * 
	 */
	public int getPosition(int data)
	{
		int position = -1;
		LinkedListNode node = new LinkedListNode(data);
		if(null == head)
		{
			return -1;
		}
		
		LinkedListNode current = head;

		while(null != current.getNext())
		{
			// Check if current data is equal to node data
			if(current.getData() == node.getData())
			{
				return position;
			}
			current = current.getNext();
			position++;
		}
		
		return position;
	}
	
	/**
	 * Clear the list/ remove everything from the linked List.
	 */
	public void clearList()
	{
		head = null;
		length = 0;
		
	}
	
	/**
	 * Return the node at the specified Element 
	 * 
	 * @param index
	 * @return
	 */
	public int getNodeData(int index)
	{
		if (index >= length || index < 0)
		{
			System.out.println("List doesnot contains " + index + " elements or index is less then Zero ");
			return -1;
		}
		LinkedListNode curr = head;
		int pos = 0;
		while (curr.getNext() != null && pos < index)
		{
			curr = curr.getNext();
			pos++;
		}

		return curr.getData();
	}

	/** 
	 * Find the length of the list through iterating the nodes of the list. 
	 * 
	 * @param linkedListNode
	 * @return
	 */
	public int listLength(LinkedListNode linkedListNode)
	{
		int length = 0;
		LinkedListNode head= linkedListNode;
		
		while(head != null)
		{
			length++;
			head= head.getNext();
		}
		return length;
	}

	public LinkedListNode getHead()
	{
		return head;
	}
}
