package algorithms.linkedlist;

public class DoublyLinkedList
{
	private DoublyLinkedListNode head;
	
	private DoublyLinkedListNode tail ;
	
	private int length;
	
	public DoublyLinkedList()
	{
		head = new DoublyLinkedListNode(Integer.MIN_VALUE, null, null);
		tail = new DoublyLinkedListNode(Integer.MIN_VALUE,head, null);
		head.setNext(tail);
		length = 0;
	}
	
	public void insertAtBeginning(DoublyLinkedListNode node)
	{

		if(head == null || head.getData() == Integer.MIN_VALUE)
		{
			head = node;
			tail = node;
			length++;
			return;
		}
//		if(head.getNext() != null)
//		{
			
			head.setPrev(node);
			node.setNext(head);
			head = node;
//		}
//		else
//		{
//			head.setPrev(node);
//			node.setNext(head);
//			head = node;
//		}
		length++;
	}
	
	public void insertAtEnd(DoublyLinkedListNode node)
	{
		if (tail == null)
		{
			tail = node;
			head = node;
		}
		else
		{
			DoublyLinkedListNode currentnode = tail;

			currentnode.setNext(node);
			node.setPrev(currentnode);
			tail = node;
		}
		length++;
	}
	
	public void insert(int data, int position)
	{

		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		if(head == null)
		{
			head = new DoublyLinkedListNode(data);
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
				node.setNext(head);
				head = node;
				length++;
				return;
			}
		}

		DoublyLinkedListNode currentNode = head;
		int nodePos =0;
		while(nodePos < position)
		{
			currentNode = currentNode.getNext();
			nodePos++;
		
		}
		
		node.setNext(currentNode.getNext());
		currentNode.getNext().setPrev(node);
		node.setPrev(currentNode);
		currentNode.setNext(node);
		length++;
	}

	public DoublyLinkedListNode removeFromBegin()
	{
		if(null == head)
		{
			return null;
		}
		 DoublyLinkedListNode current = head;
		head = head.getNext();
		current.setNext(null);
		length--;
		return current;
	}
	
	public DoublyLinkedListNode removeFromLast()
	{
		if(null == tail)
		{
			return null;
		}
		 DoublyLinkedListNode current = tail;
		 tail.getPrev().setNext(null);
		 tail = tail.getPrev();
		 current.setPrev(null);
		 current.setNext(null);
		 length--;
		 return current;
	}
	
	public void removeMatched(DoublyLinkedListNode node)
	{

		if(null == head)
		{
			return;
		}
		
		DoublyLinkedListNode current = head;
		
		while(null != current.getNext())
		{
			// Check if current data is equal to node data
			if(current.getData() == node.getData())
			{
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
				current.setNext(null);
				length--;
				return;
			}
			current = current.getNext();
		}
		
		length--;
	}
	
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
				DoublyLinkedListNode current = head;
				head = head.getNext();
				current.setNext(null);
				length--;
				return;
			}
		}

		DoublyLinkedListNode currentNode = head;
		int nodePos =0;
		while(nodePos < position)
		{
			currentNode = currentNode.getNext();
			nodePos++;
		}
		if(currentNode.getNext() != null)
		{
			currentNode.getNext().setPrev(currentNode.getPrev());
			currentNode.getPrev().setNext(currentNode.getNext());
			length--;
		}
		else
		{
			currentNode.getPrev().setNext(null);
			tail = currentNode.getPrev();
			currentNode.setPrev(null);
			length--;
		}
	}
	
	public String toString()
	{
		String result = "[ ";
		DoublyLinkedListNode current = head;
		
		while(current.getNext() != null)
		{
			result = result + /*"[" +*/ current.getData() /*+ " , next:"
					+ (current.getNext() != null ? current.getNext().getData()
							: null)
					+ " prev : " + (current.getPrev() != null
							? current.getPrev().getData() : null)+ " ]"*/
					+ " --> ";
			current = current.getNext();
		}
		result = result + current.getData();
		result = result + "]";
		
		return result;
	}
	
	public int getlength()
	{
		return length;
	}
	
	public int getPosition(int data)
	{

		int position = -1;
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		if(null == head)
		{
			return -1;
		}
		
		DoublyLinkedListNode current = head;

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
}
