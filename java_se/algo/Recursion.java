package algo;

/**
 * Recursion refers to an method which calls itself. It is extremely useful for
 * traversing trees, and for specific sorting algorithms.
 * 
 * Rule: if it can be done via recursion, it can be done via iteration; no
 * exceptions. Though, recursion might be a better option.
 */
public class Recursion {
	
	public static int totalCalculations = 0;

	public static int factorial(int num) {

		int ans = 1; // Base case: reuqired to end the recursion.
		if (num > 1) {
			ans = num * factorial(num - 1);
		}
		return ans;

		// Time complexity = O(N).
	}

	public static int fibonacciAt(int index) {
		// Returns the number at a particular index of the Fibonacci sequence.

		if (index == 0) {
			return 0; // Base case (1).
		} else if (index == 1) {
			return 1; // Base case (2).
		} // Simpler base case: if(index < 2) { return n; }
		else {
			totalCalculations++;
			return fibonacciAt(index - 1) + fibonacciAt(index - 2);
		}

		/*
		 * For functions where, M = number of recursive method calls, 
		 * Time complexity = O(M^N), aka exponential.
		 * 
		 * Time Complexity can be improved using Memoization.
		 */

	}

	public static void main(String[] args) {

		System.out.println(fibonacciAt(19));
		System.out.println("Total Calculations: " + totalCalculations);

	}

}
