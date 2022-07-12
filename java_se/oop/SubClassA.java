package oop;

/**
 * Inheritance, Method Overriding, "super".
 */
public class SubClassA extends AbstractClassA implements InterfaceA {

	/*
	 * INHERITANCE: Each class must extend exactly one class, but can implement
	 * multiple interfaces (comma separated).
	 * 
	 * A class must implement all the unimplemented methods of its super-class, or
	 * declare itself an Abstract class and leave it to its own sub-class(es).
	 * 
	 * By default, each Class extends the Object class.
	 */

	@Override
	public void promise() {
		/*
		 * METHOD OVERRIDING: By declaring a method with the same name and parameters, a
		 * method can be overriden. The @Override annotation is optional, and its
		 * primary benefit is readability.
		 * 
		 * During compilation, the compiler binds the most specific method to the method
		 * call.
		 */

		System.out.println("Sub-Class A: Overriding the Interface");
	}

	public SubClassA () {
		super(); // Invokes the super-class's constructor.
		super.concreteMethod();
		/*
		 * "super" refers to the super-class. It can be used to access the fields and
		 * methods of the super-class.
		 */
		
		InterfaceA.super.newMethod();
		// Interfaces can be accessed via Interface.super.
	}
	
	@Override
	public int promise2(int input) {
		System.out.println("Sub-Class A: Overriding the Interface");
		return 0;
	}

	@Override
	void method() {
		System.out.println("Sub-Class A: Overriding the Abstract Class");
	}

	void uniqueMethod() {
		System.out.println("Sub-Class A: Unique method");
	}

}
