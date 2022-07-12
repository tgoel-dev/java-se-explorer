package fp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Lambdas are simply an anonymous method which does not belong to any class.
 * Lambdas can only be used to instantiate FUNCTIONAL INTERFACES, and replace
 * anonymous classes.
 * 
 * (+) compact code, reduced memory usage (no outer object reference).
 * 
 * (-) can only instantiate functional interfaces (for interfaces with multiple
 * abstract methods, anon classes must be used.)
 */
public class Lambdas {

	public final static int VAR = 0;
	/*
	 * Lambda expressions can capture variables from outside its declaration, as
	 * long as they are final or effectively final (remain unchanged).
	 */

	static void simplifyingCode() {

		ArrayList<Integer> list = new ArrayList<>();

		// Descending order with Anon class:
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1; // Reverses the order.
			}
		});

		// Descending order with Lambda Expressions:
		Collections.sort(list, (Integer i1, Integer i2) -> {
			return i2 - i1;
		});

		Collections.shuffle(list);

		// Further simplifying lambda expressions.
		Collections.sort(list, (i1, i2) -> i2 - i1); // param_type and return statement inferred by compiler.

	}

	@SuppressWarnings("unused")
	static void commonLambdas() {

		// Common Functional Interfaces (aka Strategies) and their Lambda expressions:

		Comparator<Integer> comparison = (i1, i2) -> i2 - i1;
		// compare(i1, i2) compares two objects; used for sorting.

		Predicate<String> filtration = s -> s.length() < 10;
		// test(s) checks if object passes criteria; used for filtering.
		
		Function<Integer, String> conversion = i -> i.toString();
		// apply(i) converts object type i to s; used for transforming data.

		UnaryOperator<Integer> splConversion = i -> i + 5;
		// Simply Function<Integer, Integer>.

		Consumer<String> consumption = d -> System.out.println(d);
		// accept(d) returns void; used to perform specific action to data.

		Supplier<String> production = () -> "used along with captured variables " + VAR;
		// get() returns <T>; used to conditionally produce data.
		/*
		 * Supplier is often used nested within an if statement. (+) This reduce memory
		 * usage. Ex: string is only concatenated if Supplier .get() is accessed. 
		 */
	}

}
