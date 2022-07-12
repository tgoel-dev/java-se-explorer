package algo.sorting;

import java.util.Arrays;

/**
 * Merge sort splits the data structure into smaller data structures, sorts each
 * data structure, and then merges them.
 * 
 * Time Complexity = O(N*log(N)), Space Complexity = O(N).
 * 
 * Merge sort is a stable algorithm, ie. if two elements are equal in terms of
 * the comparator, their relative positions in the sorted array (wrt to the
 * input array) does not change.
 * 
 */
public class MergeSort {

	public static int[] sort(int[] array) {
		// Divides the array into smaller left and right arrays.
		// Time Complexity = O(log(N)).

		if (array.length == 1) return array;

		int leftLength = (int) Math.ceil(array.length / 2.0);
		int rightLength = (int) Math.floor(array.length / 2.0);
		// Ensures both odd/even number of elements get divided properly.

		int[] leftArray = new int[leftLength];
		int[] rightArray = new int[rightLength];

		for (int i = 0, index = 0; i < array.length; i++) {

			if (i < leftLength) {
				leftArray[i] = array[i];
			} else if (i >= leftLength) {
				rightArray[index] = array[i];
				index++;
				// Only increments index when the element is added to the right array.
			}
		}

		// Recursion used to sort the left, right arrays.
		leftArray = sort(leftArray);
		rightArray = sort(rightArray);

		// Finally, merge() compares the two arrays, sorts, and combines them.
		return merge(leftArray, rightArray);

	}

	public static int[] merge(int[] array1, int[] array2) {
		// Compares and merges two given arrays.
		// Time Complexity = O(N).

		int mergedLength = array1.length + array2.length;
		int[] merged = new int[mergedLength];

		int counter1 = 0, counter2 = 0;

		for (int i = 0; i < mergedLength; i++) {

			if (!(counter1 < array1.length)) // Does not compare when counter exceeds array.length.
			{
				merged[i] = array2[counter2++];

			} else if (!(counter2 < array2.length)) {
				merged[i] = array1[counter1++];

			} // Adds the smaller element to the merged array.
			else if (array1[counter1] <= array2[counter2]) {

				merged[i] = array1[counter1++];

			} else if (array1[counter1] > array2[counter2]) {

				merged[i] = array2[counter2++];

			}
		}

		// System.out.println(Arrays.toString(array1) + " + " + Arrays.toString(array2)
		// + " = " + Arrays.toString(merged));

		return merged;
	}

	public static void print(int[] array) {

		// Method used to sort, and print the arrays.
		int[] sorted = sort(array);

		System.out.println(array.length + ": " + Arrays.toString(array));
		System.out.println(sorted.length + ": " + Arrays.toString(sorted));
	}

	public static void main(String[] args) {
		int[] array = { 12, 4, 2, 7, 8, 3, 67, 1, 86, 32, 19 };
		print(array);

		int[] array1 = { 1, 12, 122, 3, 4, 75, 7, 100, 101, 1222 };
		print(array1);

	}

}
