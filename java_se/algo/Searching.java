package algo;

/**
 * Searching/Traversal refers to iterating through a data structure to find a
 * particular element.
 */
public class Searching {

	/*
	 * Linear Search iterates through each element in the data structure
	 * sequentially, until the element is found.
	 * 
	 * Time Complexity = O(N).
	 * 
	 * Linear search is useful for unsorted data structures.
	 */
	public static int linearSearch(int[] array, int elem) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == elem) {
				return i;
			}
		}

		return -1;
	}

	/*
	 * For a sorted data structure, Binary Search can be used. Binary search splits
	 * the data structure (recursively), and decides whether the elem is on the left
	 * or the right.
	 * 
	 * Time Complexity = O(log(N)).
	 */
	public static int binarySearch(int[] array, int elem) {

		int lowerIndex = 0;
		int higherIndex = array.length - 1;

		if (array[lowerIndex] == elem) {
			return lowerIndex;
		} else if (array[higherIndex] == elem) {
			return higherIndex;
		}

		loop: while (lowerIndex < higherIndex) {
			int i = (int) Math.floor((higherIndex + lowerIndex) / 2);
			// System.out.println(i);

			if (array[i] == elem) {
				return i;
			} else if (array[i] > elem) {
				higherIndex = i;
			} else if (array[i] < elem) {
				lowerIndex = i;
			}

			if (i == (int) Math.floor((higherIndex + lowerIndex) / 2)) {
				break loop;
			}
		}

		return -1;
	}

	@SuppressWarnings("unused")
	public static void traversal() {
		// Traversal: examining every node in a tree.

		// There exists a wide variety of variation among BFS/DFS.
		BreadthFirstSearch: {
			/*
			 * Checks a tree level-by-level. Typically used to find the shortest paths
			 * between two nodes (ex: finding the shortest route on a map).
			 * 
			 * (+) Low time complexity for finding shortest paths.
			 * (-) Keeps track of the children nodes of each level, increasing memory
			 * requirements. Also, high time complexity for wide trees.
			 */
			
			// Weighted BFS algos: Bellman-Ford, Dijkstra.
		}

		DepthFirstSearch: {
			/*
			 * Checks a tree depth by depth. Typically used to check if a path between 
			 * two nodes exists (ex: solving a maze).
			 * 
			 * (+) Lower memory requirements.
			 * (-) High time complexity for deep trees.
			 */
			
			// DFS is implemented in different orders.
		}
	}

	public static void print(int[] array, int toFind) {
		System.out.println("Found " + toFind + " at index: " + binarySearch(array, toFind));
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 7, 8, 12, 19, 32, 67, 86 };

		print(array, 67);
		print(array, 38);
	}
}
