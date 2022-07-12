package algo.sorting;

import java.util.ArrayList;

/**
 * Selection sort iterates over the collection, finds the first item, and places
 * it at the smallest available index. This process is then repeated until the
 * collection is sorted.
 * 
 * Time Complexity = O(N^2), Space Complexity = O(1).
 * 
 * Selection sort, like Bubble Sort, is only used for educational purposes.
 */
public class SelectionSort {

	public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {

		for (int i = 0; i < numbers.size(); i++) {

			// Find the min value from index i to numbers.size()-1
			int minValue = Integer.MAX_VALUE;
			int indexOfMinValue = -1;

			for (int j = i; j < numbers.size(); j++) {
				int currentValue = numbers.get(j);

				if (currentValue < minValue) {
					minValue = currentValue;
					indexOfMinValue = j;
				}

			}
			/*
			 * Swap the values in i and indexOfMinValue, bringing the smallest Integer to
			 * the front.
			 */
			numbers.set(indexOfMinValue, numbers.get(i));
			numbers.set(i, minValue);
		}

		return numbers;
	}

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(12);
		numbers.add(132);
		numbers.add(1);
		numbers.add(13);
		numbers.add(124);
		numbers.add(48);

		System.out.println(sort(numbers));
	}

}
