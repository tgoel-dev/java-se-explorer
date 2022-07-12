package nesting;

public class NestedStaticClasses {

	@SuppressWarnings("unused")
	private static class StaticMemberClass {
		/*
		 * Used when access to outer instance fields/methods is not required.
		 * 
		 * Static Member classes can have static/instance fields/methods. In essence, it
		 * is a complete nested class.
		 * 
		 * Prefer static member classes over inner classes.
		 */
	}
}
