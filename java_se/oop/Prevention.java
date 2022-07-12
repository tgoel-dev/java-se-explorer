package oop;

/**
 * Inheritance Prevention, Decorator Pattern.
 */
public class Prevention {

	/*
	 * Inheritance can be prevented via two methods:
	 * 
	 * 1. a private constructor. 2. a final declaration in class declaration.
	 */

	// 1.
	private Prevention() {

		/*
		 * Class is no longer extendible or instantiable.
		 * 
		 * Private constructors are typically used when all methods are static. ex:
		 * java.lang.Math class.
		 */
	}

}

// 2.
final class FinalClass {
	// Class is no longer extendible, but is instantiable.

	public FinalClass() {
		// Instantiable.
	}

	public void method1() {
	}

}

/*
 * The Decorator pattern (or Wrapper classes) is used to add functionality to a
 * final class.
 * 
 * The Decorator class and the Decorated class should conventionally be sister
 * classes, ie. implementing the same interface (to allow for polymorphism).
 */
class Decorator {

	private FinalClass obj;

	public Decorator(FinalClass obj) {
		this.obj = obj;
		// The Decorator pattern is used by chaining constructors.
	}

	public void addedFunctionality() {
		// Code.
	}

	public void method1() {
		obj.method1();
	}
}
