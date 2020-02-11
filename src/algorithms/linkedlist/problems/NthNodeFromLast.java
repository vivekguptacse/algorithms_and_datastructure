package algorithms.linkedlist.problems;

import algorithms.linkedlist.LinkedList;
import algorithms.linkedlist.LinkedListNode;
import algorithms.linkedlist.Main;

/**
 * Finds the Nth node from the End recursively. 
 * 
 * @author Vivek
 *
 */
public class NthNodeFromLast
{
	private int counter ; 
	
	private LinkedListNode result = null;
	
	public LinkedListNode nthNodeFormEnd(LinkedListNode head, int nth)
	{
		if(head != null)
		{
			nthNodeFormEnd(head.getNext(),nth);
			counter++;
			
			if(nth == counter)
			{
				result = head;
			}
		}
		
		return result != null ? result :null;
	}
	
	
	
	public static void main(String[] args)
	{
		LinkedList linkedList = Main.createLinkedList();
		System.out.println(linkedList);
		
		NthNodeFromLast nthNode = new NthNodeFromLast();
		
		LinkedListNode nthNodeFormEnd = nthNode.nthNodeFormEnd(linkedList.getHead(), 3);
		
		System.out.println(nthNodeFormEnd.getData());
		
		
	}

}
