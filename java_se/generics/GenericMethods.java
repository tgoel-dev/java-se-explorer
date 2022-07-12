package generics;

import java.io.Serializable;

/**
 * Generic Methods are (instance/static) methods that declare their own
 * type_params. Typically used for static utility methods.
 * 
 * (+) Infinite Method Overloading.
 */
public class GenericMethods {

	// @type_params come before return_type.
	public static <T> T print(T input) {

		System.out.println(input);
		return input;

	}
	
	// Other examples of generic methods:
	
	<T extends Serializable, T2> void doSomething(T input) {	}
	
	<T1, T2> void doSomething2() {  }
	
	protected static <T> void doSomething3(T input1, T input2) {  }
	

	// Generic Constructors: extremely rare.
	public <T> GenericMethods(T input) {  }
	public <T> GenericMethods() {  }
	
	public static void main(String[] args) {

		// Method Invocation:

		// 1. Type_arg automatically inferred by the compiler (most common).
		print("java");
		print(15.83);
		Number i = print(1.0); // infers Number, not Double.
		print(i);
		print(new Wildcard<String>());
		
		doSomething3(15, 3.0); // ex: infers most specific type. In this case: Number.
		
		// 2. Explicit Specification (extremely rare) - declared before the method call.
		GenericMethods.<Long>print(4L); // requires className for static methods.
		
		GenericMethods gm = new GenericMethods();
		gm.<Double, String>doSomething(57.0); 
		
		/*
		 * Compiler's inference rules are extremely complicated. Thus approach 2 is
		 * only ever used when automatic inference returns unexpected type.
		 */
		
	}

}
