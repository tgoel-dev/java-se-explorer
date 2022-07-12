package algo.sorting;

import java.util.Arrays;

/**
 * Insertion sort compares an element to all preceding elements to find its
 * relative position, and inserts the element at the correct index.
 * 
 * Time Complexity = O(N^2)*, Space Complexity = O(1).
 * 
 * Insertion sort is extremely useful for when the data structure is nearly
 * sorted. In such a scenario, its *time complexity = O(N), is the fastest
 * possible.
 * 
 */
public class InsertionSort {

	public static int[] sort(int[] array) {

		// Iterates over the array.
		for (int i = 0; i < array.length; i++) {

			// System.out.println("Current element: " + array[i]);
			int current = array[i]; // Maintains current element, and index.
			int currentIndex = i;

			/*
			 * Compares current element to all previous elements and find its relative
			 * position.
			 */
			comparison: for (int j = i - 1; j >= 0; j--) {
				if (current < array[j]) {
					// Swap elements if current element < previous element.

					System.out.println(current + " < " + array[j]); // Logs the current comparison.

					array[currentIndex] = array[j];
					array[j] = current;
					currentIndex = j; // Update the index of the current element.

				} else if (current >= array[j]) {
					break comparison;
					// Optimize the loop to break when the current element >= previous element.
				}
			}

			// System.out.println(Arrays.toString(array));
			// Shows the array after each iteration.
		}

		return array;

	}

	public static void print(int[] array) {

		// Method used to sort, and print the arrays.
		System.out.println(array.length + ": " + Arrays.toString(array));
		int[] sorted = sort(array);

		System.out.println(sorted.length + ": " + Arrays.toString(sorted) + "\n");
	}

	public static void main(String[] args) {
		int[] array = { 12, 4, 2, 7, 8, 3, 67, 1, 86, 32, 19 };
		print(array);

		int[] array1 = { 1, 12, 122, 3, 4, 75, 7, 100, 101, 1222 };
		print(array1);

		int[] array2 = { 1222, 122, 102, 89, 54, 53, 43, 13, 10, 1 };
		print(array2);

	}

}
