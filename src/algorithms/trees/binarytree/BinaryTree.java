package algorithms.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree
{
	private Node<Integer> root;

	public void insertdata(Integer val)
	{
		// Insert data recursively
		root = insert(root, new Node<Integer>(val));
	}

	public Node<Integer> getRoot()
	{
		return root;
	}

	public void setRoot(Node<Integer> root)
	{
		this.root = root;
	}

	/**
	 * Insert Node in the Ninary Search Tree.
	 * 
	 * @param root
	 * @param val
	 * @return
	 */
	public Node<Integer> insert(Node<Integer> root, Node<Integer> val)
	{
		if (root == null)
		{
			root = val;
			return root;
		} else
		{
			if (root.getData() < val.getData())
			{
				root.setRight(insert(root.getRight(), val));
			} else if (root.getData() > val.getData())
			{
				root.setLeft(insert(root.getLeft(), val));
			}
		}
		return root;
	}

	/**
	 * This method deletes the nodes from the Binary Tree. Node will be delete based
	 * on the below cases :
	 * 
	 * Case 1: Node to be deleted is the leaf node. Case 2: Node to be deleted has
	 * one child. Case 3: Node to be deleted has both children.
	 * 
	 * @param root
	 * @param val
	 */
	public Node<Integer> deleteNode(Node<Integer> root, int val)
	{
		if (root == null)
		{
			return root;
		} else if (root.getData() > val)
		{
			root.setLeft(deleteNode(root.getLeft(), val));
		} else if (root.getData() < val)
		{
			root.setRight(deleteNode(root.getRight(), val));
		} else
		{
			// Case 1
			if (root.getLeft() == null && root.getRight() == null)
			{
				root = null;
			}
			// Case 2
			else if (root.getLeft() == null)
			{
				root.setData(root.getRight().getData());
				root.setRight(null);
			}
			// Case 2
			else if (root.getRight() == null)
			{
				root.setData(root.getLeft().getData());
				root.setLeft(null);
			} else
			{
				Node<Integer> temp = root.getRight();

				while (temp.getLeft() != null)
				{
					temp = temp.getLeft();
				}

				root.setData(temp.getData());
				root.setRight(deleteNode(root.getRight(), temp.getData()));
			}
		}

		return root;

	}
	
	/**
	 * Level Order Traversal
	 * 
	 * @param root
	 */
	public void levelOrderTraversal(Node<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			Node<Integer> current= queue.poll();
			System.out.print(current.getData()+ " ");
	
			if(current.getLeft() != null)
			{
				queue.add(current.getLeft());
			}
			if(current.getRight() != null)
			{
				queue.add(current.getRight());
			}
			
		}
	}

	/**
	 * In order Traversal implementation
	 * 
	 * @param root
	 */
	public void inorderTraversal(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}

		inorderTraversal(root.getLeft());
		System.out.print(root.getData() + "-->");
		inorderTraversal(root.getRight());
	}

	public void preOrderTraversal(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}

		System.out.print(root.getData() + " -->");
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}

	public void postOrderTraversal(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}

		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		System.out.print(root.getData() + " -->");

	}

	// @Override
	// public String toString()
	// {
	// displayTree(root , 5);
	// return super.toString();
	// }

//	public void displayTree(Node<Integer> root2, int depth)
//	{
//		// while(root2 != null)
//		// {
//		if (root2 == null)
//		{
//			return;
//		} else
//		{
//
//			for (int i = depth; i <= 5; i++)
//			{
//				System.out.println();
//			}
//			String str = addSpace(depth);
//			System.out.print(str + root2.getData());
//
//			// System.out.println();
//			if (root2.getLeft() != null)
//			{
//				displayTree(root2.getLeft(), depth - 1);
//
//			}
//
//			if (root2.getRight() != null)
//			{
//				displayTree(root2.getRight(), depth + 1);
//			}
//
//		}
//
//		// }
//	}

	// private String addSpace(int depth)
	// {
	// String str = "";
	// for (int i = 0; i <= depth; i++)
	// {
	// str += " ";
	// }
	// return str;
	// }

}
