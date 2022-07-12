package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Lists are used when resizing, and sequencing are required.
 * 
 * Lists: ArrayList, Linked List
 */
public class Lists {

	public static void arrayLists(Collection<Integer> input) {

		ArrayList<Integer> numbers = new ArrayList<>();
		/*
		 * ArrayList is simply a resizable array. It is the most commonly used data
		 * structure in the Collections framework.
		 */

		numbers.add(177);
		numbers.addAll(input);

		int index = 1;
		numbers.get(index);
		numbers.remove(index);

		for (int i = 0; i < numbers.size() - 1; i++) {
			numbers.set(i, numbers.get(i) * 2);
		}
		numbers.removeAll(input);
		System.out.println(numbers);

	}

	public static void linkedLists(Collection<Integer> input) {
		LinkedList<Integer> numbers = new LinkedList<>();
		/*
		 * Collection Framework's linked list implementation is a doubly linked list,
		 * where the head is connected to the tail. Also, note: The head is always
		 * empty, and points to the value at index 0, and the tail.
		 * 
		 * Linked list also implements the Deque interface.
		 */

		numbers.add(137);

		System.out.println(numbers);
	}

	public static void main(String[] args) {

		Integer[] array = new Integer[] { 14, 15, 12, 34, 4, 54, 55 };

		ArrayList<Integer> num = new ArrayList<>(Arrays.asList(array));
		num.add(null);

		arrayLists(num);
		linkedLists(num);

	}
}
