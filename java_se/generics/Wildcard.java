package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Raw types, Unbounded Wildcard
 * 
 * @param <T>
 */
@SuppressWarnings("unused")
public class Wildcard<T> {

	public void unboundedWildcard(List<?> input) {

		/*
		 * "?" - Unbounded Wildcard
		 * 
		 * Used to bypass invariance. It can only be used as a type_arg, indicates that
		 * the type is irrelevant.
		 * 
		 * Most commonly used when parameterized types are required in method_params.
		 * They cannot be used to instantiate an object, but can be used in assignment
		 * statements (uncommon).
		 * 
		 * Use when parameterized type produces data, and data type is irrelevant.
		 */

		// Compiles, but uncommon. Mostly unnecessary.
		List<?> local = input;
		List<?> local2 = new ArrayList<Integer>();

		System.out.println(local);
		System.out.println(local2);

	}
	
	public void upperBoundedWildcard(List<? extends Number> inp) {
		
		/* 
		 * "? extends Class" - Upper Bounded Wildcard
		 * 
		 * Restricts ? to subclasses of Class. 
		 * 
		 * <?> is basically <? extends Object>.
		 */
		
		Number d = inp.get(0); // valid
		// Integer f = inp.get(1); // invalid
		
		// Better to use for production of data.
		Number u = inp.get(3);
		
	}
	
	public void lowerBoundedWildcard(List<? super Number> inp) {
		
		/*
		 * "? super Class" - Lower Bounded Wildcard
		 * 
		 * Restricts ? to superclasses of Class.
		 */
		
		Object o = inp.get(0); // valid
		// Number i = inp.get(0); //invalid
		
		// Better to use for consumption of data. 
		inp.add(15);
	}
	
	/*
	 * When to use wildcards (Get/Put Principle):
	 * 
	 * 1. Parameterized type produces (Gets) data --> <? extends >
	 * 2. Parameterized type produces data, and data type irrelevant --> <?>
	 * 3. Parameterized type consumes (Puts) data --> <? super >
	 * 
	 * 4. Parameterized type produces and consumes data --> exact match, do not use ?.
	 */
	 
	public void copy(List<? extends Number> source, List<? super Number> destination) {
		
		// ex: source produces data, destination consumes data.
		for (Number i : source) {
			destination.add(i);
		}

	}

}
