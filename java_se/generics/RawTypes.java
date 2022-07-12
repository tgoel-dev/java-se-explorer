package generics;

import java.util.ArrayList;

public class RawTypes<T> {
	
	public T var1;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void rawTypes() {

		RawTypes ww = new RawTypes(); // Warning: "rawtypes"
		/*
		 * Raw Types, ie. ignoring generics.
		 * 
		 * Only done to support legacy programming. Should not be done for new classes.
		 * Exc: instanceof, and Class files (List.class)
		 * 
		 * (--) methods with generic instance variables cannot be used.
		 * 
		 * Instead, wildcards should be used.
		 */

		// Too flexible.
		ww.var1 = new ArrayList<String>();
		ww.var1 = new StringBuilder("eew");

		((ArrayList) ww.var1).add("amazing");
		// Errors will be discovered at runtime only.

		System.out.println(ww.var1);

	}
	
	public static void main(String[] args) {
		rawTypes();
	}
	
}
