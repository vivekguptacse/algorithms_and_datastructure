package algorithms.linkedlist;

public class DoublyLinkedListNode
{
	
	private int data;
	
	private DoublyLinkedListNode next;
	
	private DoublyLinkedListNode prev;
	
	public DoublyLinkedListNode(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public DoublyLinkedListNode(int data, DoublyLinkedListNode prev, DoublyLinkedListNode next)
	{
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public DoublyLinkedListNode getNext()
	{
		return next;
	}

	public void setNext(DoublyLinkedListNode next)
	{
		this.next = next;
	}

	public DoublyLinkedListNode getPrev()
	{
		return prev;
	}

	public void setPrev(DoublyLinkedListNode prev)
	{
		this.prev = prev;
	}

	@Override
	public String toString()
	{
		return "DoublyLinkedListNode [data=" + data + ", next=" + next
				+ ", prev=" + prev + "]";
	}

}
