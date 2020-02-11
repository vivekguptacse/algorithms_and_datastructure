package algorithms.recursion;

public class TowerOfHanoi
{
	
	public static void main(String[] args)
	{
		int n = 3;
		towerOfHanoi(n,'A' , 'C' , 'B');
	}

	private static void towerOfHanoi(int n, char fromPeg, char toPeg, char auxPeg)
	{
		// base condition 
		if(n == 1)
		{
			System.out.println("Moving disk from Peg "+ fromPeg + " to Peg " + toPeg);
			return;
		}
		
		// Move n-1 disks from, fromPrg to AuxPeg using toPeg as auxillary peg
		towerOfHanoi(n-1, fromPeg, auxPeg, toPeg);
		
		System.out.println("Moving disk from Peg " + fromPeg + " to peg " + toPeg);
		
		// move n-1 pegs from, auxPeg to toPeg using frompeg as auxillary peg. 
		towerOfHanoi(n-1, auxPeg, toPeg, fromPeg);
		
	}

}
