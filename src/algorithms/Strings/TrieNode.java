package algorithms.Strings;

/**
 * Trie Node to store trie node data. 
 * 
 * @author Vivek
 *
 */
public class TrieNode
{
	boolean is_End_Of_String;
	
	TrieNode []child;
	
	public TrieNode()
	{
		this.child = new TrieNode[26];
		is_End_Of_String = false;
	}
	
	public TrieNode subNode(char character)
	{
		if(child != null)
		{
			int charindex = (character - 'a');
			if(child[charindex] != null)
			{
				return child[charindex];
			}
		}
		return null;
	}

	public boolean isIs_End_Of_String()
	{
		return is_End_Of_String;
	}

	public void setIs_End_Of_String(boolean is_End_Of_String)
	{
		this.is_End_Of_String = is_End_Of_String;
	}

}
