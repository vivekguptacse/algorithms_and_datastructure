package algorithms.Strings;

/**
 * Array Based implementation of tries. 
 * 
 * @author Vivek
 *
 */
public class Tries
{

	/** Root Node **/
	private TrieNode root;
	
	/** Constructor **/
	public Tries()
	{
		root = new TrieNode();
	}
	
	/**
	 * Method to insert the data into the Tries data structure. 
	 * 
	 * @param data
	 */
	public void insertInTries(String data)
	{
		data = data.toLowerCase();
		TrieNode current = root;
		
		for(int i = 0 ; i < data.length() ; i++)
		{
			char ch = data.charAt(i);
			int index = ch - 'a';
			if(current.child[index] == null)
			{
				TrieNode temp = new TrieNode();
				current.child[index] = temp;
				current = temp;
			}
			else
			{
				current = current.child[index];
			}
		}
		
		current.setIs_End_Of_String(true);
		
	}
	
	/**
	 * Searching the Tries data Structure. 
	 * 
	 * @param data
	 * @return
	 */
	public boolean searchInTries(String data)
	{
		data= data.toLowerCase();
		
		TrieNode current = root;
		
		for(int i = 0 ; i < data.length() ; i++)
		{
			char ch = data.charAt(i);
			int index = ch - 'a';
			if(current.child[index] == null)
			{
				return false;
			}
			else
			{
				current = current.child[index];
			}
			
		}
		if(current.is_End_Of_String)
		{
			return true;
		}
		
		return false;
	}
	
}
