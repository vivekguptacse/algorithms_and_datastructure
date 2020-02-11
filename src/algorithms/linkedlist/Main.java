package algorithms.linkedlist;

public class Main
{
	
	public static void main(String[] args)
	{
		linkedListTest();
		
		System.out.println( "**************************************************************");
		
		doublyLinledListTest();
	}

	private static void doublyLinledListTest()
	{

		DoublyLinkedList linkedList = createDoublyLinkedList();
		
		System.out.println("1"+linkedList);
		System.out.println("2"+linkedList.getlength());
		
		System.out.println(linkedList.removeFromBegin());
		System.out.println(linkedList.removeFromLast());
		System.out.println(linkedList.getlength());
		System.out.println("3"+linkedList);
		linkedList.removeMatched(new DoublyLinkedListNode(4));
		System.out.println("4"+linkedList);
		linkedList = createDoublyLinkedList();
		linkedList.remove(4);
		
		System.out.println("5"+linkedList);
		
		System.out.println(linkedList.getPosition(7));
		linkedList.remove(5);
		System.out.println("6"+linkedList);
	
		
	}

	private static void linkedListTest()
	{
		LinkedList linkedList = createLinkedList();
		
		
		System.out.println("1"+linkedList);
		System.out.println("2"+linkedList.getlength());
		
		System.out.println(linkedList.removefrombegin());
		System.out.println(linkedList.removefromLast());
		System.out.println(linkedList.getlength());
		System.out.println("3"+linkedList);
		linkedList.removeMatched(new LinkedListNode(4));
		System.out.println("4"+linkedList);
		linkedList = createLinkedList();
		linkedList.remove(4);
		
		System.out.println("5"+linkedList);
		
		System.out.println(linkedList.getPosition(7));
		linkedList.remove(5);
		System.out.println("6"+linkedList);
		
		System.out.println(linkedList.getNodeData(2));
		System.out.println(linkedList.getNodeData(0));
		System.out.println(linkedList.getNodeData(8));
	}

	public static LinkedList createLinkedList()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBeginning(new LinkedListNode(4));
		linkedList.insertAtBeginning(new LinkedListNode(3));
		linkedList.insertAtBeginning(new LinkedListNode(2));
		linkedList.insertAtBeginning(new LinkedListNode(1));
		linkedList.insertAtEnd(new LinkedListNode(5));
		linkedList.insertAtEnd(new LinkedListNode(7));
		linkedList.insertAtEnd(new LinkedListNode(8));
		linkedList.insert(6, 4);
		linkedList.insertAtEnd(new LinkedListNode(9));
		linkedList.insertAtEnd(new LinkedListNode(10));
		linkedList.insertAtEnd(new LinkedListNode(11));
		return linkedList;
	}
	
	private static DoublyLinkedList createDoublyLinkedList()
	{
		DoublyLinkedList linkedList = new DoublyLinkedList();
		linkedList.insertAtBeginning(new DoublyLinkedListNode(4));
		linkedList.insertAtBeginning(new DoublyLinkedListNode(3));
		linkedList.insertAtBeginning(new DoublyLinkedListNode(2));
		linkedList.insertAtBeginning(new DoublyLinkedListNode(1));
		linkedList.insertAtEnd(new DoublyLinkedListNode(5));
		linkedList.insertAtEnd(new DoublyLinkedListNode(7));
		linkedList.insertAtEnd(new DoublyLinkedListNode(8));
		linkedList.insert(6, 4);
		linkedList.insertAtEnd(new DoublyLinkedListNode(9));
		linkedList.insertAtEnd(new DoublyLinkedListNode(10));
		linkedList.insertAtEnd(new DoublyLinkedListNode(11));
		return linkedList;
	}

}
