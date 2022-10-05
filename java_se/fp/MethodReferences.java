package fp;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Method References (temp: metrefs)
 * 
 * Metrefs are used to pass in an existing method as an argument, instead of
 * writing new logic.
 */
@SuppressWarnings("unused")
public class MethodReferences {

	
	public static void metrefs() {
	
		// Lambda implementation
		Consumer<String> output = (d -> System.out.println(d));
		
		// Metref implementation
		output = System.out::println;

		/*
		 * When the output object is called, it will simply print all variables.
		 */
		
		/* Syntax:
		 *  
		 * 1. Static Methods = Class::method; 
		 * 2. Instance Methods = Object::method;
		 * 
		 * 3. Instance Methods with multiple parameters; ex: BiFunction interface.
		 * 	  For lambda expression ((d,c) -> d.contains(c))
		 *    metref = ClassOfD::method;
		 *
		 * */
	}

	public static void specialMetrefs() {
		
		/* Constructor References; 
		 * 
		 * especially useful for calling overloaded constructors.
		 */
		Supplier<String> output = String::new; 		
	}
	
}
