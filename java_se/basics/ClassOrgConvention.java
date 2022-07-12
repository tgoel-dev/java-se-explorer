package basics;

/**
 * Convention for Organizing the various elements of a class.
 */
//@SuppressWarnings("unused")
public class ClassOrgConvention {

	// VARIABLES
	static int staticVariables = 0;
	int instanceVariables = 0;

	
	// STATIC-CODE
	static { /* Static Initializers */ }
	
	static class nestedStaticClasses { 	}
	
	static void staticMethods() {	}	
	
	
	// INSTANCE-BASED CODE
	{ /* Instance Initializers */ }	
	
	public ClassOrgConvention() { /* Constructors */ }
	
	class nestedInstanceClasses {	}
	
	
	void instanceMethods() {	}
	
}
