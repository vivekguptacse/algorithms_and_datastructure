package algorithms.Strings;

public class Main
{
	public static void main(String[] args)
	{
		bruteForceStringMatcherTester();

		triesDataSturctureTester();

	}

	private static void triesDataSturctureTester()
	{
		Tries tries = new Tries();

		tries.insertInTries("Vivek");
		tries.insertInTries("Vikas");

		System.out.println(tries.searchInTries("VIVEK"));
		System.out.println(tries.searchInTries("Viv"));
	}

	private static void bruteForceStringMatcherTester()
	{
		// Checking the String matching with Brute force Algorithm
		StringMatchingAlgorithms stringMatcher = new StringMatchingAlgorithms();

		System.out.println(stringMatcher.bruteForceStringMatching("Gupta Vivek Kumar", "Vivek"));
	}

}
