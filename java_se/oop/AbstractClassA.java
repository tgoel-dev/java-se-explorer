package oop;

/**
 * Abstract class, "abstract".
 */
public abstract class AbstractClassA {

	/*
	 * Abstract classes are simply classes that cannot be instantiated, but can be
	 * extended.
	 * 
	 * Abstract classes can have concrete, abstract, or final methods, as well as
	 * constructors (only accessible from a sub-class). It can also have static and
	 * non-static methods and fields.
	 * 
	 * (+) Improve software design, and reusability of code. (+) Useful for
	 * polymorphism.
	 */

	// Abstract methods: must be implemented by the sub-class(es).
	abstract void method();

	void concreteMethod() {
		// Inherited by all subsequent sub-classes. Can be overriden.
	}

	final void finalMethod() {
		// Inherited by all subsequent sub-classes. Cannot be overriden.
	}

	public AbstractClassA() {
		// Only accessible from sub-class(es). Abstract classes cannot be instantiated.
	}

}
