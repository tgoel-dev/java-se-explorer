package basics;

/**
 * Primitives, Default values, Wrapper classes, String classes, Typecasting
 */
@SuppressWarnings("unused")
public class Primitives {

	// Methods
	public static boolean bool() {

		/*
		 * Variables are defined as: ReferenceType varName = value;
		 */

		boolean boo = false; // false (default) or true.
		return boo;

	}
	
	
	public static void numbers() {

		// There are 7 primitive numbers: all default to 0.

		// Integers
		byte by = 123; // 08-bit range = [-128, 127]
		short sh = 12; // 16-bit range = [-32,758, 32,767]
		int mostCommon = 1234; // 32-bit range = [-2,147,483,648, 2,147,483,647]
		long l = 123L; // 64-bit range = [-9.223*(10^18), 9.223*(10^18)]

		// Floating Points
		float f = 0.0F; // range roughly upto 6-7 decimal places
		double d = 0.0; // range roughly upto 15-16 decimal places
		/*
		 * Decimal points cannot be accurately represented in binary. 
		 * Thus, math with decimal points might return approximate answers. 
		 * When precision is required, prefer using BigDecimal class.
		 */

		// Character
		char c = 66; // can take numeric value wrt UTF-16 or chars directly.
		char u = '\u0042';
		char b = 'B'; // c = u = b

		// Valid values
		int hexadecimal = 0xffffffff; // returns -1
		int binary = 0b00000011; // returns 3
		int readability = 2_147_483_647; // java ignores _, returns 2147483647

	}

	public static void wrappers() {

		// Wrapper classes add functionality to Primitives
		Boolean bool = Boolean.FALSE;

		Byte by = Byte.MAX_VALUE;
		Short sh = Short.MIN_VALUE;
		Integer in = Integer.valueOf(89);
		Long l = Long.max(189L, 13893L);

		Float ff = Float.MAX_VALUE;
		Double dd = Double.POSITIVE_INFINITY;

		Character cc = Character.valueOf('c');

	}
	
	public static void strings() {
		
		String common = "plain text"; // utilizes char
		// Strings are immutable to address security concerns, and concurrency.
		
		// Other String classes in JRE System Library
		StringBuilder mutable = new StringBuilder("useful for multiple string concatentation operations. \n");
		mutable.append("Better time and space complexity than String class too. ");
		mutable.append("Not syncronized. ");
		
		StringBuffer obsolete = new StringBuffer("StringBuilder + syncronized. "); // Rarely used.
		
		/*
		 * Escape sequences:
		 * \n = line break; \t = tab;
		 * \" = double quote;  \' = single quote; \\ = backslash;
		 * (rare:) \b = backspace; \r = carriage return; \f = formfeed;
		 * */	
		
	}

	public static void typecasting() {

		int one = 47;

		// Implicit casting (smaller to larger); done by compiler automatically.
		long two = one + 1900;
		double three = one * 1.08;

		// Explicit casting (larger to smaller); required for compilation.
		int four = (int) two;
		char c = (char) one;
		int five = (int) three; // can result in information loss.

	}

	public static void main(String[] args) {
		System.out.println(0xffffffff);
	}

}
