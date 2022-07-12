package algo.sorting;

import java.util.Arrays;

/**
 * Bubble sort is the simplest sorting algorithm. Bubble sort compares adjacent
 * elements and swaps them if they are in the wrong order.
 * 
 * Time Complexity = O(N^2), Space Complexity = O(1).
 * 
 * Bubble sort is not very efficient, and is only used for educational purposes.
 *
 */
public class BubbleSort {

	public static int[] sort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			// Iterates over n times.

			for (int j = 0; j < array.length - 1; j++) {
				// Compares adjacent elements, and swaps them.

				if (array[j] > array[j + 1]) {

					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;

				}
			}

			// System.out.println(Arrays.toString(array));
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
