package tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit Annotations (@)
 */
public class Annotations {

	
	@BeforeClass
	public static void preConditions() {
		// Used to execute statements before all test cases.
		// Must be static
		System.out.println("BeforeClass");
	}
	
	@Before
	public void setup() {
		// Used to execute statements before each test case.
		System.out.println("--b--");
		
	}
	
	@Ignore
	public void test1() {
		// Ignores the method during testing.
		assertTrue(true);
	}
	
	@Test(timeout=100)
	public void test2() {
		// Test times out after 100 ms.
		assertTrue(true);
	}
	
	@Test
	public void test3() {
		assertTrue(true);
	}
	
	@After
	public void cleanUp() {
		// Used to execute statements after each test case.
		System.out.println("--a--");
	}
	
	@AfterClass
	public static void postConditions() {
		// Used to execute statements after all test cases.
		// Must be static
		System.out.println("AfterClass");
	}
}	
