package algorithms.Strings;

public class TernarySearchTreeNode
{
	
	private char data;
	
	private boolean is_End_Of_String;
	
	private TernarySearchTreeNode left;
	
	private TernarySearchTreeNode equal;
	
	private TernarySearchTreeNode right;

	public char getData()
	{
		return data;
	}

	public void setData(char data)
	{
		this.data = data;
	}

	public boolean isIs_End_Of_String()
	{
		return is_End_Of_String;
	}

	public void setIs_End_Of_String(boolean is_End_Of_String)
	{
		this.is_End_Of_String = is_End_Of_String;
	}

	public TernarySearchTreeNode getLeft()
	{
		return left;
	}

	public void setLeft(TernarySearchTreeNode left)
	{
		this.left = left;
	}

	public TernarySearchTreeNode getEqual()
	{
		return equal;
	}

	public void setEqual(TernarySearchTreeNode equal)
	{
		this.equal = equal;
	}

	public TernarySearchTreeNode getRight()
	{
		return right;
	}

	public void setRight(TernarySearchTreeNode right)
	{
		this.right = right;
	}

}
