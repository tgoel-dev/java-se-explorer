package algo.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Quick sort selects a random pivot element, and splits the data structure into
 * smaller data structures, based on whether the elements are smaller or larger
 * than the pivot element. It then sorts each data structure, and merges them.
 * 
 * Time Complexity = O(N*log(N)) || O(N^2), Space Complexity = O(N).
 * 
 * The efficiency of Quick sort depends on the algorithm for choosing the pivot
 * element. If the pivot element divides the data structure into relatively
 * equal sub-structures, quick sort is one of the fastest sorting algorithm.
 * 
 */
public class QuickSort {

	public static ArrayList<Integer> sort(ArrayList<Integer> list) {
		
		//System.out.println(list.size() + ": " + list);
		
		if(list.size() <= 2) return SelectionSort.sort(list);
		
		int pivot = list.get(list.size() -1 ); // Choosing the last element as pivot for simplicity.
		
		ArrayList<Integer> leftArray = new ArrayList<>();
		ArrayList<Integer> rightArray = new ArrayList<>();
		ArrayList<Integer> middleArray = new ArrayList<>(); 

		// Adds elements to respective lists.
		for(int i = 0; i < list.size() ; i++) {
			if( list.get(i) < pivot) {
				leftArray.add(list.get(i));
			} else if (list.get(i) > pivot) {
				rightArray.add(list.get(i));
			} else if (list.get(i) == pivot) {
				middleArray.add(list.get(i));
			}
		}
		
		System.out.println(leftArray + "L " + middleArray + "M " + rightArray + "R");
		
		// Left and right lists get sorted.
		// Middle list does not need to be sorted.
		leftArray = sort(leftArray);
		rightArray = sort(rightArray);
		
		// Lists are combined.
		ArrayList<Integer> finalArray = new ArrayList<>();
		finalArray.addAll(leftArray);
		finalArray.addAll(middleArray);
		finalArray.addAll(rightArray);
		
		System.out.println(finalArray.size() + ": " + finalArray);
		
		return finalArray;
	}
	
	public static void main(String[] args) {
		int[] array = { 12, 4, 2, 7, 8, 3, 67, 1, 86, 32, 19 };
		int[] array1 = { 1, 12, 122, 3, 4, 75, 7, 100, 101, 50 };
		
		ArrayList<Integer> list1 = new ArrayList<>();
		
		for(int i: array) list1.add(i);
		for(int i: array1) list1.add(i);
		
		Collections.shuffle(list1);
		System.out.println("Initial: " + list1.size() + ": " + list1);
		
		sort(list1);
	}
	
}
