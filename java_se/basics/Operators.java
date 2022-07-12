package basics;

/**
 * Types of operators
 */
@SuppressWarnings("unused")
public class Operators {

	/*
	 * Types of operators wrt number of operands: 
	 * 1. Unary : a++, a--, !a. 
	 * 2. Binary : a+b, a >= b.
	 * 3. Ternary. a ? b : c.
	 */

	public void operators() {

		String[] assignment = {"="};
		
		String[] arithmetic = { "+", "-", "*", "/", "%" };
		/*
		 * Rules: 
		 * 1. Follows BODMAS 
		 * 2. Smaller operand type is promoted to larger operand type.
		 */

		String[] comparison = { ">", ">=", "<", "<=", "==", "!=" };
		// comparison operators return boolean

		String[] logical = { "&&", "||", "!" };
		
		/* Operator Precedence:
		 * !, arithmetic, comparison, (&&, ||).
		 */
		
		String[] bitwise = {"&", "|", "^", "~"};
		/*
		 * x = 0001_0001; y = 0000_0011;
		 * x & y : returns 0000_0001;
		 * x | y : returns 0001_0011;
		 * x ^ y : returns 0001_0010; //exclusive-OR
		 * ~x : returns 1110_1110; 
		 */
		
		String[] bitshift = {"<<", ">>>", ">>"};
		/*
		 * x << n : left-shift: shifts binary of x left by n positions, also works as x*(2^n).
		 * x >>> n : unsigned right-shift: shifts binary of x right by n positions, also works as x/(2^n).
		 * x >> n : signed right-shift: maintains -ve || +ve.
		 */
		
		String[] ternary = {"? :"};
		/*
		 * condition ? expression-if-true : expression-if-false;
		 */

	}

}
