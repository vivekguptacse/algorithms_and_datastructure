package algorithms.linkedlist.problems;

import algorithms.linkedlist.LinkedList;
import algorithms.linkedlist.LinkedListNode;
import algorithms.linkedlist.Main;

/**
 * Reverse the linked list in pairs. If you have a linked list that holds 1
 * →2→3→4→X, then after the function has been called the linked list would hold
 * 2→ 1→4 →3→X.
 * 
 * @author Vivek
 *
 */
public class SwapLinkedListNodes
{
	public LinkedListNode reversePairrecursive(LinkedListNode node)
	{
		LinkedListNode temp = null;
		if(node == null || node.getNext() == null)
		{
			return null;
		}
		else
		{
			temp = node.getNext();
			node.setNext(temp.getNext());
			temp.setNext(node);
			node = temp;
			
			node.getNext().setNext(reversePairrecursive(node.getNext().getNext()));
		}
		
		return node;
	}
	
	public LinkedListNode reverseKPairrecursive(LinkedListNode node, int k)
	{
		LinkedListNode current = node;
		LinkedListNode prevtail = null;
		LinkedListNode prevCurrent = node;
		
		while(current != null)
		{
			// loop for reversing K nodes
			int count = k;
			LinkedListNode tail = null;
			while(current != null && count > 0)
			{
				LinkedListNode next = current.getNext();
				current.setNext(tail);
				tail = current;
				current = next;
				count--;
			}
			// reversed K nodes
			if(prevtail != null) 
			{
				// Link this set and previous set
				prevtail.setNext(tail);
			}
			else
			{
				// we just reversed first set of K nodes , update head point to the Kth node
				node = tail;
			}
			
			// Save the last node after reverse since we need to connect  to the next set
			prevtail = prevCurrent;
			// Save the current node, which will become the last node after reverse
			prevCurrent = current;
		}
		
		return node;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SwapLinkedListNodes swap = new SwapLinkedListNodes();
		
		LinkedList linkedList = Main.createLinkedList();
//		System.out.println(linkedList);
		
		LinkedListNode reversePairrecursive = swap.reversePairrecursive(linkedList.getHead());
		System.out.println(reversePairrecursive);
		
		linkedList = Main.createLinkedList();
		
		System.out.println(swap.reverseKPairrecursive(linkedList.getHead(), 3));
	}

}
