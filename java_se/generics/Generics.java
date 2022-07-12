package generics;

import java.util.ArrayList;

/**
 * Generics is a compile-time only concept. The compiler uses TYPE ERASURE {<T>
 * and T references are removed and replaced with the actual @type_arguments}
 * and adds IMPLICIT TYPECASTING.
 * 
 * In essence, Generics provides flexibility to the reference type of a
 * variable. Generics is extremely useful when multiple different (even
 * unrelated) classes share the same logic.
 * 
 * (+) Allows for flexibility, and checks type safety at compile-type.
 * 
 * Polymorphism may be used instead of generics, but polymorphism (--) can be
 * too generic (leading to ClassCastExc), requires Explicit Casting, and
 * discovers errors at runtime.
 * 
 * @type_param <T>, aka Formal Type Parameter.
 */
public class Generics<T1, T2> {

	/*
	 * Naming Convention: 
	 * E - elements (for Collections) 
	 * K - keys, V - values (for Maps) 
	 * N - number 
	 * T - type (for non-Collections) (most common)
	 */

	private T1 var1;
	private T2 var2;
	
	/*
	 * Generics can only be used as instance variables, and within non-static
	 * methods (local variables, parameters, return types).
	 */

	public Generics(T2 a) {
		this.var2 = a;
		System.out.println(var2);
	}

	public void setVar1(T1 a) {
		this.var1 = a;
	}

	public T1 getVar1() {
		return var1;
	}

	public static void staticMethod() {
		// Cannot reference T1, T2, T3.
	}

	public static void main(String[] args) {
		Generics<Integer, String> gg = new Generics<>("T2");
		Generics<ArrayList<Integer>, Number> gg2 = new Generics<>(12);
		/**
		 * @type_arguments <Integer, String>, aka Actual Type Parameter. type_args
		 *                 cannot be primitives.
		 * @parameterized_types instances with type_args. ex:
		 *                      Generics<ArrayList<Integer>, Number>.
		 */

		gg.setVar1(13);
		System.out.println(gg.getVar1());

		gg2.setVar1(new ArrayList<Integer>());
		gg2.getVar1().add(15);
		gg2.getVar1().add(18);
		System.out.println(gg2.getVar1());

	}

}
