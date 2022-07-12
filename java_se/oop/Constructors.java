package oop;

/**
 * Constructors, constructor chaining, "this". Method overloading, and varargs.
 */
public class Constructors {

	/*
	 * CONSTRUCTOR: methods with the same name as the class and no return type,
	 * invoked with the keyword new. Creates a new object (aka instance) of the
	 * Class.
	 * 
	 * If no constructor is present, compiler adds a no-args constructor by default.
	 * If a constructor is present, compiler does not add any constructors.
	 * 
	 */
	public Constructors() {
		this(0);
	}

	/*
	 * METHOD OVERLOADING: Implementing multiple methods with the same name, but
	 * different parameters (return type can be different).
	 */

	// Overloaded constructors:
	public Constructors(int x) {
		this(x, 0);
		/*
		 * Constructor Chaining: this() invokes the primary constructor.
		 * 
		 * "this" refers to the current instance, and is used to access object state.
		 */
	}

	public Constructors(int x, int y) {
		this(x, y, 0);
	}

	/*
	 * Primary Constructor: conventionally all overloaded constructors point to the
	 * primary constructor, while only the primary constructor is programmed.
	 * 
	 * No this() invocation allowed within the primary constructor.
	 * 
	 */
	public Constructors(int... y) {
		/*
		 * Varargs (...) = variable-length arguments, allows for infinite overloading,
		 * by accepting an infinite number of arguments of type specified.
		 * 
		 * Varargs is Iterable.
		 */

		for (int i : y) {
			System.out.print(i + ", ");
		}

	}

}
