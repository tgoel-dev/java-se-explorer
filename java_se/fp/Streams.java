package fp;

import java.util.ArrayList;
import java.util.stream.*;

/**
 * Streams are used to perform operations on Collections.
 * 
 * In essense, adding SQL querying functionality (filtering, grouping, sorting,
 * etc) to Collections.
 */
public class Streams {

	/*
	 * STREAM PIPELINE:
	 * 
	 * 1. Set up stream source.
	 * 
	 * 2. Lazy operations: intermediate operations used to filter data received.
	 * They return an instance of Stream.
	 * 
	 * 3. Eager operations: terminal operations, that return a ResultSet.
	 * 
	 * There exists a Stream function for each SQL operation.
	 */

	public static void stream(ArrayList<Integer> list) {

		// 1. The stream source here is the list.

		// 2.
		Stream<Integer> str = list.stream();
		Stream<Integer> pstr = list.parallelStream(); // takes advantage of concurrency.

		str = str.filter(a -> a > 100);
		pstr = pstr.distinct();

		// 3.
		str.findAny(); // relies on the filter criteria
		pstr.allMatch(a -> a % 10 == 0);

		// The complete pipeline
		list.stream().filter(a -> a > 100).findAny();
		list.parallelStream().allMatch(a -> a % 10 == 0);
	}

}
