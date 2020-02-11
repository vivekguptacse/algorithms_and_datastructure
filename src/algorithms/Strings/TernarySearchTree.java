package algorithms.Strings;

public class TernarySearchTree
{
	private TernarySearchTreeNode root;
	
	public void insertAtTST(String word)
	{
		word = word.toLowerCase();
		root= insertAtTST(this.root, word);
		
	}

	public TernarySearchTreeNode insertAtTST(TernarySearchTreeNode root, String word)
	{
		if(word.length() <= 0 )
		{
			root.setIs_End_Of_String(true);
			return root;
		}
		
		if(root == null)
		{
			root = new TernarySearchTreeNode();
			root.setData(word.charAt(0));
			root.setLeft(null);
			root.setEqual(null);
			root.setRight(null);
			
			root = insertAtTST(root, word.substring(1));
		}else if(root.getData() == word.charAt(0))
		{
			root.setEqual(insertAtTST(root.getEqual(), word));
		}
		else if(word.charAt(0) < root.getData())
		{
			root.setLeft(insertAtTST(root.getLeft(), word));
		}
		else if(word.charAt(0) > root.getData())
		{
			root.setRight(insertAtTST(root.getRight(),word));
		}
		
		return root;
	}
	
	public static void main(String[] args)
	{
		TernarySearchTree tree = new TernarySearchTree();
		
		tree.insertAtTST("Vivek");
		tree.insertAtTST("vikas");
		tree.insertAtTST("vivekanand");
	}

}
