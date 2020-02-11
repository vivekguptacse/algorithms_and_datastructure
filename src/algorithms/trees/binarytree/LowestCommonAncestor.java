package algorithms.trees.binarytree;

public class LowestCommonAncestor
{
	
	public Node<Integer> lowestCommonAnsestor(Node<Integer> root, Node<Integer> node1, Node<Integer> node2)
	{
		if(node1.getData() == root.getData() || node2.getData() == root.getData())
		{
			return root;
			
		}
		else if(node1.getData() <= root.getData() && node2.getData() > root.getData() || node2.getData() <= root.getData() && node1.getData() > root.getData())
		{
			return root;
		}
		else if(root.getData() > Math.max(node1.getData(), node2.getData()))
		{
			return lowestCommonAnsestor(root.getLeft(), node1, node2);
		}
		else
		{
			return lowestCommonAnsestor(root.getRight(), node1, node2);
		}
	}

}
