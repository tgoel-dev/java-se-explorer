package collections.mixins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * To be able to compare two objects, the class must use a Comparator object, or
 * implement the Comparable interface (and implement the compareTo method).
 */
public class Comparing {

	private static class Example implements Comparable<Example> {

		/*
		 * The Comparable interface is especially useful when there is only a clear way
		 * of comparing two objects, which also refers to its natural ordering. Ex: The
		 * natural ordering of numbers is ascending.
		 * 
		 * Similarly, if an object needs to only be compared based on a single property
		 * or state, then implementing the Comparable interface is highly efficient.
		 */

		private String name;
		private String category;
		public String getCategory() { return category; }
		
		Example(String name, String category) {
			this.name = name;
			this.category = category;
		}
		
		@Override
		public String toString() {
			return name;
		}
		
		@Override
		public int compareTo(Example arg0) {
			/*
			 * a.compareTo(b) method returns an int. 
			 * b > a = -ve int;
			 * b == a = 0;
			 * b < a = +ve int; 
			 */

			return this.getCategory().compareTo(arg0.getCategory());
			// Calls the String's compareTo method.
		}

	}
	
	public static void usingComparator(List<Example> list) {
		/*
		 * The Comparator interface is especially useful when there are multiple ways of
		 * comparing two Objects. Ex: Fruits can be compared based on size, sweetness,
		 * color, region, consumption stats, etc.
		 * 
		 * In such cases, Comparators are used. Each Comparator can define one way of
		 * comparing two objects.
		 * 
		 * Typically, Comparators are created as nested anonymous classes but can also
		 * be extended as a Top-level class, esp. if the same comparison is to be done
		 * consistently.
		 */
		
		Collections.sort(list, new Comparator<Example>() {

			@Override
			public int compare(Example arg0, Example arg1) {
				// compare(a, b) also returns (-int || 0 || +int).
				return arg0.toString().compareTo(arg1.toString());
			}
			
		});
		
		System.out.println(list);
		

	}
	
	public static void main(String[] args) {
		Example ex0 = new Example("Paris", "City");
		Example ex1 = new Example("Hungary", "Country");
		Example ex2 = new Example("India", "Country");
		Example ex3 = new Example("Delhi", "District");
		Example ex4 = new Example("America", "Country");
		
		ArrayList<Example> list = new ArrayList<>();
		list.add(ex0);
		list.add(ex1);
		list.add(ex2);
		list.add(ex3);
		list.add(ex4);

		Collections.shuffle(list);
		System.out.println(list);
		
		// Using Comparable.
		Collections.sort(list);
		System.out.println(list);
		
		// Using Comparator.
		usingComparator(list);
		
	}

}
