package algorithms.linkedlist.problems;

import algorithms.linkedlist.LinkedList;
import algorithms.linkedlist.LinkedListNode;

/**
 * Implement Stack using Linked List
 * 
 * @author Vivek
 *
 */
public class StackUsingLinkedList
{
	private LinkedList head;
	
	private int size;
	
	public StackUsingLinkedList(int size)
	{
		this.size = size;
		head = new LinkedList();
	}
	
	public void push(int data)
	{
		if(head.getlength() >= size)
		{
			System.out.println("Cannot add more elements as the Stack is FULL.");
		}
		else
		{
			head.insertAtBeginning(new LinkedListNode(data));
		}
	}
	
	public int pop()
	{
		int result = -1;
		if(head.getlength() <= 0 )
		{
			System.out.println("Cannot remove elements as the Stack is EMPTY. ");
		}
		else
		{
			LinkedListNode removefrombegin = head.removefrombegin();
			result = removefrombegin.getData();
		}
		return result;
	}
	
	public int top()
	{
		int result = -1;
		if (head.getlength() <= 0)
		{
			System.out.println("Cannot get the elements as the Stack is EMPTY. ");
		} else
		{
			result = head.getNodeData(0);
		}

		return result;
	}
	
	public void displayStack() 
	{
		System.out.println(head);
	}
	
	public static void main(String[] args)
	{
		StackUsingLinkedList stack = new StackUsingLinkedList(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.top());
		stack.push(6);
		stack.displayStack();
		System.out.println(stack.pop());
		System.err.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(7);
		System.out.println(stack.pop());
		System.err.println(stack.top());
		
		
	}
	
	

}
