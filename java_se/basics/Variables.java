package basics;

/**
 * Types of variables (instance, static, local), Access Modifiers
 */
public class Variables {

	// Declared at the class-level, instance/static variables get default values.
	static String staticVariable = "belongs to the class";
	String instanceVariable = "belongs to the object"; // lacks the static keyword

	// Declared at the class-level, final variables do not get default values.
	final String finalVariable = "cannot be reassigned once initialized";
	final Object finalVar2 = new Object();
	
	static final String CONSTANT_VARIABLE = "a static and final var"; 
	// Convention: primitive or String only.

	
	// ACCESS MODIFIERS
	String def = "accessible within the package"; // Default, Note: keyword default is used in other context. 
	public String pub = "accessible to anyone";
	protected String pro = "accessible within the package and to the sub-classes";
	@SuppressWarnings("unused")
	private String pvt = "accessible only to the class and its objects";

	
	public String method() {
		// Declared at the method level, local variables do not get default values.
		String localVariable = "belongs to the method";
		
		return localVariable;
	}

}
