package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sets are used when the values stored must be UNIQUE. They represent
 * mathematical sets.
 * 
 * Sets: HashSet, LinkedHashSet, TreeSet.
 */
public class Sets {

	/*
	 * A Set<E> is simply a Map<E, Object>, where each Key is unique, and each Value
	 * is an empty Object.
	 */
	
	/*
	 * To maintain the uniqueness of an <Object> set, overriding the hashCode() and 
	 * equals() method is required.
	 * 
	 * (::) Auto-generate the hashCode(). 
	 */

	public static void hashSet() {

		Set<Integer> nums = new HashSet<>();
		/*
		 * Utilizes a Hash algo to store keys in storage.
		 * 
		 * HashSet does not maintain the order of the elements added.
		 */

		nums.add(15);
		Integer[] array = { 13, 144, 13, 24, 553, 32, 1, 1 };
		nums.addAll(Arrays.asList(array));

		System.out.println("HashSet: " + nums);
	}

	public static void linkedHashSet() {
		Set<Integer> nums = new LinkedHashSet<>();
		/*
		 * LinkedHashSet maintains the order of the elements added.
		 */

		nums.add(15);
		Integer[] array = { 13, 144, 13, 24, 553, 32, 1, 1 };
		nums.addAll(Arrays.asList(array));

		System.out.println("LinkedHashSet: " + nums);
	}

	public static void treeSet() {
		Set<Integer> nums = new TreeSet<>();
		/*
		 * TreeSet uses a balanced tree to store a sorted Set.
		 */

		nums.add(15);
		Integer[] array = { 13, 144, 13, 24, 553, 32, 1, 1 };
		nums.addAll(Arrays.asList(array));

		System.out.println("TreeSet: " + nums);
	}

	public static void main(String[] args) {
		hashSet();
		linkedHashSet();
		treeSet();
	}
}
