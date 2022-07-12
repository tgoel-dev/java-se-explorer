package oop;

/**
 * Interfaces, "default".
 */
public interface InterfaceA {

	/*
	 * Interfaces are non-instantiable, and must be implemented by other classes.
	 * They are used to allow multiple inheritance.
	 * 
	 * Interfaces are mostly used to define methods that are public and abstract by
	 * default. The implementations are left to the sub-classes, which must override
	 * the methods.
	 * 
	 */
	void promise();

	int promise2(int input);

	/*
	 * Interfaces cannot have fields (exc: constants (public, static, and final)),
	 * and no constructors.
	 */
	public static final int FIELDS_EXCEPTION = 14;


	// Rare: interfaces can also define static methods, and default methods.
	public static void ownMethod() {
		// Not inherited by sub-classes.
	}

	public default void newMethod() {
		/*
		 * Inherited by sub-classes.
		 * 
		 * The purpose of default methods was to progress API interfaces, without
		 * breaking existing implementations. Uses the keyword "default".
		 * 
		 * Default methods need not be implemented via overriding.
		 */

		System.out.println("default implementation");
	}
}
