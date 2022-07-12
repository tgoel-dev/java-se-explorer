package oop;

/**
 * Polymorphism, "instanceof"
 */
public class Polymorphism {

	private AbstractClassA obj;
	
	public void polymorphism() {

		/*
		 * Polymorphism allows the object reference type to be a superclass, abstract
		 * class, or an interface of the instance being assigned. 
		 * 
		 * Prefer interfaces or least specific class for polymorphism. 
		 * 
		 * (+) Loosely coupled programming, higher flexibility.
		 * 
		 * The polymorphic variable can access the methods defined in the reference var.
		 * To access any methods unique to the instance requires explicit typecasting.
		 */

		Object ab = 15;
		System.out.println(ab);
		obj = new SubClassA();
		
		obj.method();
		((SubClassA) obj).uniqueMethod();
		// Throws an IllegalCastException if obj is not of type SubClassA.
		// Use instanceof to check first.
	}

	public void instanceOf() {
		// instanceof checks the class of the object.
		AbstractClassA test = new SubClassB();

		if (test instanceof SubClassB) { // returns true.
			// run code.
			System.out.println("B");
		} else if (test instanceof SubClassA) {
			// run code.
			System.out.println("A");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
