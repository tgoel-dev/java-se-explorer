package concurrency.low_level;

import java.util.concurrent.atomic.*;

/**
 * Atomic classes (java.util.concurrent.atomic.*) are improved volatile
 * variables, that also provide atomicity (ie. no race condition).
 */
public class AtomicVars {

	// Scalar Classes
	public AtomicLong al = new AtomicLong(1551L);
	public AtomicInteger ai = new AtomicInteger(15);
	public AtomicBoolean ab = new AtomicBoolean(true);
	public AtomicReference<Object> ar = new AtomicReference<>();

	private static final int ARRAY_SIZE = 3;

	// Array Classes
	public AtomicLongArray ala = new AtomicLongArray(ARRAY_SIZE);
	public AtomicIntegerArray aia = new AtomicIntegerArray(ARRAY_SIZE);
	public AtomicReferenceArray<Object> ara = new AtomicReferenceArray<>(ARRAY_SIZE);

	// Field Updater Classes (rare)
	// Compound Variables Classes (rare)
}
