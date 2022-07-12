package nesting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Nested classes serve only their enclosing class, reducing class pollution {}.
 * (+) Better design.
 * 
 * Outer class and nested class(es) can access each other's private
 * fields/methods.
 * 
 * After compilation, nested class files are named: Outer$Inner.class.
 */
@SuppressWarnings("unused")
public class NestedInnerClasses {

	/*
	 * Nested class can either be inner classes (non-static member, anonymous, or
	 * local) or static member classes.
	 */

	void method() {
		System.out.println("Outer method");
	}

	void methodCalls() {
		method(); // Calls outer method.
		this.method(); // Calls outer method.
		(new NonStaticMember()).method(); // Calls inner method.
	}

	private class NonStaticMember {

		/*
		 * A non-static member inner class can have instance fields/methods, but not
		 * static fields/methods.
		 */

		void method() {
			System.out.println("Inner Method");
		}

		void methodCalls() {
			method(); // Calls outer method.
			this.method(); // Calls inner method.
			NestedInnerClasses.this.method(); // Calls outer method.
		}

	}

	public void anonymousClass(List<String> list) {
		/*
		 * Anonymous classes are classes created without using the keyword "class". Such
		 * classes also lack a name. During compilation, they are given numbers for
		 * class names.
		 * 
		 * After compilation, anon classes files are named: Outer$1.class.
		 * 
		 * Anon classes are typically used to create functional objects that extend
		 * functional interfaces.
		 */

		// Here, an anonymous class is used to extend the Comparator interface.
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg1.toString().compareTo(arg0.toString());
			}

		});

		/*
		 * Anon classes can capture variables from outer class, as long as they are
		 * final or effectively final (remain unchanged).
		 */
		String outerVar = "works";

		// Anon classes themselves, can also be stored to a reference var.
		Comparator<String> demo = new Comparator<>() {

			@Override
			public int compare(String arg0, String arg1) {
				System.out.println(outerVar); // Works
				return 0;
			}

		};

		// outerVar = "changed"; // Anon class throws a compilation error.

	}

	public void localClass() {

		class LocalClass {
			// Defined within a method. Extremely rare.
		}

	}

}
