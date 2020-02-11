package algorithms.linkedlist.problems;

import algorithms.linkedlist.LinkedListNode;

/**
 * N people have decided to elect a leader by arranging themselves in a circle
 * and eliminating every Mth person around the circle, closing ranks as each
 * person drops out. Find which person will be the last one remaining (with rank
 * 1).
 * 
 * @author Vivek
 *
 */
public class JosephusCircleProblem
{
	
	public void getJosephusPosition(int numNode, int removeAtPosition)
	{
		LinkedListNode head, tail ;
		// Create circular list containing all the players
		head = new LinkedListNode(1);
		tail = head;
		
		for(int i = 2 ; i < numNode ; i++)
		{
			head.setNext(new LinkedListNode(i));
			head = head.getNext();
		}
		
		head.setNext(tail);  
		
		for(int count = numNode ; count > 1 ; --count)
		{
			for(int i = 0 ; i < removeAtPosition -1 ; i++)
			{
				head = head.getNext();
			}
			head.setNext(head.getNext().getNext());
		}
		
		System.out.println("Last Player left standing (Josephus position) is " + head.getData());
	}
	
	public static void main(String[] args)
	{
		JosephusCircleProblem circularProblem = new JosephusCircleProblem();
		circularProblem.getJosephusPosition(15, 5);
		
		
	}

}
