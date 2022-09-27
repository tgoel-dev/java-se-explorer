package tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**
 * TDD, JUnit tests, Assertions.
 * 
 * JUnit Testing requires the JUnit Library to be added to the build path.
 */
public class JUnitTesting {

	/*
	 * Test Driven Development (TDD): a development approach where tests are written
	 * prior to any code. The tests specify and validate the code.
	 * 
	 * (+) Better detects bugs, broken code, and improves collaboration.
	 * 
	 * Design Convention: create a test class for each individual class/action.
	 * Naming Convention: ClassTest.class
	 */

	@SuppressWarnings("unused")
	@Test
	public void test1() {

		int expectedOutcome = 15;
		int objBeingTested = 15;

		boolean bool = true;

		/* Execute code to be tested */

		assertTrue(bool);
		assertFalse(bool);

		assertEquals(expectedOutcome, objBeingTested);

		assertNull(objBeingTested);
		assertNotNull(objBeingTested);

		if (!bool) {
			fail();
			// Fails the test.
		}

	}

	@Test
	public void test2() {
		assertTrue(true);
	}

}
