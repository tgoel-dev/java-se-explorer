package concurrency.low_level;

/**
 * Volatile Variables, "volatile".
 * 
 * Volatile variables restrict being stored on the CPU caches, and instead, are
 * stored in the shared RAM. This allows for all thread to see any changes made
 * to the volatile variable.
 * 
 * (+) Readability, resource inexpensive, no need to declare all methods synced.
 * (-) Race condition still possible.
 * 
 * Volatile vars are esp. useful when one thread writes and various others read.
 */
public class VolatileVars {

	private static volatile int volVar = 0;

	public static void incrementVolVar() {
		volVar++;
	}

	public int getVolVar() {
		return volVar;
	}

}
