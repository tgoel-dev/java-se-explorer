package concurrency.low_level;

/**
 * Synchronization (temp: Sync), Locks, "synchronized"
 * 
 * Sync is used to prevent the RACE CONDITION {when multiple threads share and
 * affect the same fields (variables); (-) can cause data corruption, unwanted
 * behavior, etc}.
 * 
 * Sync ensures that everything within a sync block is run atomically.
 */
public class Synchronization {

	int mutable = 0;

	public void syncBlock() {

		Object lock = this;

		/*
		 * A sync block uses an object as a Lock. The lock is acquired by the thread
		 * upon entering the sync block, and released upon its execution. A lock can
		 * only be acquired by one thread at any given moment.
		 * 
		 * If the lock is unavailable, the thread is put in a BLOCKED state.
		 */
		synchronized (lock) {
			/*
			 * For effective syncing, use the same object as lock to guard the same var
			 * variable.
			 */

			mutable++; // (::) Sync everywhere where the variable is accessed.
			/*
			 * Note, single statements may encapsulate multiple statements, and thus, might
			 * require a sync block. Ex: ++ implies three functions: read, increment, and
			 * write.
			 */
		}
	}

	public synchronized void syncMethod() {
		/*
		 * Using synchronized in the method declaration is the same as encapsulating the
		 * method with a sync block (with current instance ("this") as the lock).
		 * 
		 * If the current instance is already acquired, then the method goes into a
		 * BLOCKED STATE. Any of the unsynced methods can still be called.
		 */

		this.mutable = 15;

	}

	public synchronized int getvar() {
		return this.mutable;
		// "synchronized" recommended as mutable is accessed within a sync block.
	}

	public void bestPractices() {
		/*
		 * (::) Sync static mutable variables (race condition can occur for multiple
		 * access, even within a single thread).
		 * 
		 * (::) Sync only where needed. Excessive syncing can limit performance.
		 * (::) Keep sync blocks as small as possible. Move any time-consuming work 
		 * outside the sync block
		 * (::) If unsure, avoid syncing. Document the class as "not thread-safe".
		 * 
		 */ 
	}

}
