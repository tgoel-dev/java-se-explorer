package oop;

/**
 * Static and Instance Initializers.
 */
public class Initializers {

	// Static Initializer
	static {
		// Executed when the class is loaded.
		System.out.println("Order of execution: \n\n0 Static Initializer");
		/*
		 * Useful for initializing final static variables that require multiple lines of
		 * code (ex: requiring a try/catch block), or to populate a data structure.
		 */
	}

	// Instance Initializer
	{
		// Runs prior to the constructor during initialization.
		System.out.println("1 Instance Initializer");
		/*
		 * Used to share code among constructors, ex: if each constructor works
		 * differently enough to prevent a primary constructor, but shares code in the
		 * beginning.
		 * 
		 */
	}

	// Instance Initializer 2
	{
		/*
		 * There can be multiple (static/instance) initializers, they are executed in
		 * the order they are written.
		 */
		System.out.println("2 Instance Initializer");
	}

	public Initializers() {

		System.out.println("3 Constructor");

	}

	public static void main(String[] args) {

		Initializers init = new Initializers();
		System.out.println(init);
	}

}
