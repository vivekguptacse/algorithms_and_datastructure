package algorithms.linkedlist.problems;

import algorithms.linkedlist.LinkedList;
import algorithms.linkedlist.LinkedListNode;
import algorithms.linkedlist.Main;

/**
 * Check whether the given linked list is either NULL-terminated or ends in a
 * cycle (cyclic)
 * 
 * @author Vivek
 *
 */
public class LoopExistsInList
{
	/**
	 * <p>
	 * This solution uses Floyds algorithm to find if a cycle Exist in the
	 * LinkedList.
	 * </p>
	 * <p>
	 * In this algorithms we will use 2 pointers, 1 pointer will move with the
	 * normal speed while the other will move with double speed, if they match at
	 * any time then there is cylce or if any pointer reach NULL, then it doesn't
	 * contains cycle.
	 * </p>
	 * 
	 * @param node
	 * @return
	 */
	public boolean isCycleExist(LinkedList node)
	{
		LinkedListNode fastPointer = node.getHead();
		LinkedListNode slowPointer = node.getHead();
		
		while(fastPointer != null && fastPointer.getNext() != null)
		{
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(slowPointer == fastPointer)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public LinkedListNode findBeginOfLoop(LinkedList node)
	{
		boolean loopExist = false;
		
		LinkedListNode fastPointer = node.getHead();
		LinkedListNode slowPointer = node.getHead();
		
		while(fastPointer != null && fastPointer.getNext() != null)
		{
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(slowPointer == fastPointer)
			{
				loopExist = true;
				break;
			}
		}
		
		if(loopExist)
		{
			slowPointer = node.getHead();
			while(slowPointer != fastPointer)
			{
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext();
			}
			return fastPointer;
		}
		
		return null;
	}
	
	public int lengthOfLoop(LinkedList node)
	{

		boolean loopExist = false;
		
		LinkedListNode fastPointer = node.getHead();
		LinkedListNode slowPointer = node.getHead();
		
		while(fastPointer != null && fastPointer.getNext() != null)
		{
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(slowPointer == fastPointer)
			{
				loopExist = true;
				break;
			}
		}
		
		int length = 0;
		if(loopExist)
		{
			slowPointer = slowPointer.getNext();
			length++;
			while(slowPointer != fastPointer)
			{
				slowPointer = slowPointer.getNext();
				length++;
			}
		}
		
		return length;
		
	}
	
	public static void main(String[] args)
	{
		LinkedList createLinkedList = Main.createLinkedList();
		LoopExistsInList cyclicList = new LoopExistsInList();
		
		System.out.println(createLinkedList);
		
		System.out.println(cyclicList.isCycleExist(createLinkedList));
		
		// create cycle 
		LinkedListNode node = createLinkedList.getHead().getNext();
		
		createLinkedList.insertAtEnd(node);
		
		System.out.println(cyclicList.isCycleExist(createLinkedList));
		
		// find the starting of the circle. 
		System.out.println(cyclicList.findBeginOfLoop(createLinkedList).getData());
		
		// find the length of the cycle
		System.out.println(cyclicList.lengthOfLoop(createLinkedList));
		
		
	}
	
}
