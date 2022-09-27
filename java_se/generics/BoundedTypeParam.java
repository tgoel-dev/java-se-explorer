package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Bounded Type Parameters, Invariance.
 * 
 * @param <T extends List>
 */
public class BoundedTypeParam<T extends List<Number>> {
	/*
	 * T must extend List<Integer>.
	 * 
	 * For multiple bounds, "&" is used. T must extend/implement all bounds. Bounds
	 * can be classes (restricted to only one), interfaces, enums, and
	 * parameterized_types.
	 */

	private T list;

	public BoundedTypeParam(T l) {
		this.list = l;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		/* OO */ BoundedTypeParam<List<Number>> numbers = new BoundedTypeParam<>(new ArrayList<Number>()); 		
		/* OO */ BoundedTypeParam<ArrayList<Number>> numbers2 = new BoundedTypeParam<>(new ArrayList<Number>()); 

		/* XX */ // BoundedTypeParam<ArrayList<Integer>> ints = new BoundedTypeParam<>(new ArrayList<Integer>()); 
		
		/*
		 * INVARIANCE: subclasses cannot be used for defined type_args.
		 * 
		 * ex: OO: T = ArrayList<Number>; XX: T = List<Integer>.
		 * 
		 * Invariance can be bypassed using wildcards.
		 */

		numbers.method(189.45);
		System.out.println(numbers);

	}

	public void method(Double element) {

		/* Invariance checks for compile-time type errors. */
		
		/* OO */ list.add(element); 
		/* OO */ list.add(12);
		/* OO */ list.remove(1);
		/* OO */ list.add((int) Math.floor(element / 3)); 
		
		/* XX */ // list.add("String"); 
		
		System.out.println(list);
	}
}
