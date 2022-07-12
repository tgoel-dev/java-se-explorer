package collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Queues are FIFO data structures, ie. the element that is added first is
 * served first.
 * 
 * Deques (or Double-ended Queues) are FIFO + LIFO structures. Typically used
 * for when the first and the last element require accessing.
 * 
 * Queues --> Deques: ArrayDeque, LinkedList.
 */
public class Queues {

	public static void arrayDeque() {

		Deque<Integer> nums = new ArrayDeque<>();
		/*
		 * ArrayDeque is the array implementation of queue/deque, and is most widely
		 * used. Prefer ArrayDeques over LinkedList; as ArrayDeques are 3x faster and
		 * show intent.
		 * 
		 * ArrayDeque allows for duplicates, not nulls.
		 */

		Integer[] array = { 13, 144, 13, 24, 553, 32, 1, 1 };
		nums.addAll(Arrays.asList(array));

		// Tail-end methods:
		nums.add(18);
		nums.removeLast(); // Returns element removed.
		nums.getLast();

		// Head-end methods:
		nums.remove();
		nums.element(); // Simply returns first element.
		nums.addFirst(14);
		nums.getFirst();

		/*
		 * Above-mentioned methods all throw exceptions in case the method fails.
		 * ArrayDeque also has an entire different set of methods that returns null when
		 * the method fails.
		 * 
		 * add --> offer; remove --> poll; element/get --> peek;
		 */

		// Also supports stack methods (discouraged):
		nums.push(156); // Adds to the top of the queue.
		nums.pop();

		System.out.println("ArrayDeque: " + nums);
	}

	public static void linkedList() {
		/*
		 * LinkedList also implements the List interface (since a lot of code uses List
		 * variables, it can be very useful), and is more efficient than ArrayDeque when
		 * removing elements during the current iteration.
		 * 
		 * LinkedList allows for duplicates, and nulls.
		 */

		// LinkedList also supports all the methods mentioned in ArrayDeque.
		Deque<Integer> nums = new LinkedList<>();

		Integer[] array = { 13, 144, 13, 24, 553, 32, 1, 1 };
		nums.addAll(Arrays.asList(array));

		// Tail-end methods:
		nums.add(18);
		nums.removeLast();
		nums.getLast();

		// Head-end methods:
		nums.remove();
		nums.element();
		nums.addFirst(14);
		nums.getFirst();

		/*
		 * LinkedList also supports the offer/poll/peek methods. However, since
		 * LinkedList allows for nulls, it is recommended to use the above-mentioned
		 * methods (which all throw exceptions).
		 */
	}

	public static void main(String[] args) {
		arrayDeque();
	}
}
