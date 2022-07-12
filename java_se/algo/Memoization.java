package algo;

import java.util.HashMap;

/**
 * Memoization (aka Dynamic Programming) is an optimization technique which
 * utilizes caching. Typically, it is used along with recursion (esp: algorithms
 * that require complicated calculations to be repeated, ex: multiple recursion
 * calls) to improve performance.
 * 
 * Memoization stores the {input:output} pair once the calculation is performed
 * on the input once. Thus, any recursive calls to a previously calculated input
 * returns in O(1) time.
 * 
 * For functions where, M = number of recursive method calls, 
 * 
 * Time complexity = O(M^N) --is reduced to--> O(N).
 */
public class Memoization {
	
	public static HashMap<Integer, Long> cache = new HashMap<>();
	public static int totalCalculations = 0;
	
	static {
		// Populating the base cases.
		cache.put(0,0L); 
		cache.put(1,1L);
	}
	
	public static long memoizedFibonacciAt(int index) {
		
		if(cache.containsKey(index)) {
			// Retrieving {input:output} = O(1).
			return cache.get(index);
		} else {
			// Performing calculation.
			long ans = memoizedFibonacciAt(index - 1) + memoizedFibonacciAt(index - 2);
			
			totalCalculations++;
			cache.put(index, ans); // Storing {input:output}
			
			return ans;
		}
	}

	
	public static void main(String[] args) {
		System.out.println(memoizedFibonacciAt(55));
		System.out.println(cache);
		System.out.println("Total Calculations: " + totalCalculations);
	}
}
