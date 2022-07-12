package basics;

/**
 * Control flow statements: if and switch.
 * Loops: for, for-each, and while.
 * Labeled break and continue. 
 * 
 */
public class ControlFlow {

	static final int FUN = 4;

	public String controlFlow(int input) {

		String result = ifStatement(input);
		switchStatement(input);

		// Ternary operator
		String sign = (input > 0) ? "positive" : "negative";

		return result + "and the number is " + sign;
	}

	public void loops(int check) {

		int[] array = forLoop(check);
		forEachLoop(array);
		whileLoop(check);
		doWhileLoop(check);
		int factorial = recursion(check);

		System.out.println("factorial of " + check + " is " + factorial);

	}

	private static void switchStatement(int input) {

		// Especially useful when checking multiple states of a single variable.
		// Improves readability.
		switch (input) {
		case 2:
			System.out.println("Too low");
			break; // Ends the control-flow statement.
		case 1 + 2:
			System.out.println("Too low");
			break;
		case FUN:
			System.out.println("Perfect");
			break;
		case 5:
			System.out.println("Too high");
			break;
		default:
			System.out.println("Try a number b/w 2 and 5");
			break;
		}

	}

	private String ifStatement(int input) {

		if (input > 0 && input < 100) {
			return "You pass!";
		} else if (input > 100) {
			return "You overachieved!";
		} else {
			return "You fail.";
		}
	}

	private int[] forLoop(int size) {
		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			if (i == 5) {
				continue;
				// Progresses to the next iteration, skipping any further expressions within the
				// loop.
			}
			array[i] = i;
		}
		return array;
	}

	private void forEachLoop(int[] array) {

		for (int i : array) {
			System.out.println(10 - i);
		}
	}

	private void whileLoop(int condition) {

		while (condition > 0) {
			System.out.println(condition + " still works");
			condition /= 2;
		}
	}
	
	private void doWhileLoop(int condition) {
		do {
			System.out.println("Checks the condition at the end. Thus runs, at least once.");
			condition /= 2;
		} while (condition > 0);
	}

	private int recursion(int factorial) {
		// Clean, but slow code.
		int ans = 1;
		if (factorial > 1) {
			ans = factorial * recursion(factorial - 1);
		}
		return ans;
	}

	public void labeledBreakAndContinue() {

		name: for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 5; j++) {
				if (i == 2 && j == 2) {
					break name;
					// Ends the named loop.

				} else if (i == 1 && j == 2) {
					continue name;
					// Skips to the next iteration of the named loop.
				} else {
					System.out.println(i + ", " + j);
				}
				
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("prints to the console");
		long t1 = System.nanoTime();
		// returns time in nanoseconds (1sec = 1,000,000,000 nanosec)

		ControlFlow ii = new ControlFlow();
		ii.loops(6);
		long t2 = System.nanoTime();
		System.out.println((t2 - t1) / 1_000_000.0); // returns time in milliseconds.

	}
}
