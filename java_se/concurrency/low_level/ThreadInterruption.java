package concurrency.low_level;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread Interruption, Extrinsic locks.
 * 
 * To stop a thread during execution, Java does not support forceful stops, but
 * instead uses thread interruption mechanism. Thread Interruption allows a
 * thread time to clean up its current tasks (implementation left to the task).
 */
public class ThreadInterruption {

	public void cancel(Thread t1) {

		t1.interrupt();
		/*
		 * While, the clean-up is handled by the thread, convention is to reset the
		 * interrupt_status to false, and throw an InterruptedException.
		 */
	}

	/*
	 * The following are interruptable: 
	 * StreamIO - must be closed instead. 
	 * Sync blocks - can use explicit locks (java.util.concurrent.locks.*).
	 */
	@SuppressWarnings("unused")
	public void interruptingSyncBlocks() {
		Lock explicit = new ReentrantLock();

		synchronized (explicit) {
			try {

				// Explicit lock methods:
				boolean lockObtained = explicit.tryLock(); // attempts to acquire lock, if successful returns true;
				Condition threadCoop = explicit.newCondition();

			} finally {
				explicit.unlock(); // Releases the lock.
			}
		}

		/*
		 * Explicit locks also have a fairness field, which determines if they maintain
		 * order of acquisition (FIFO) or not.
		 * 
		 * Prefer intrinsic locks to extrinsic locks; since they are widely used, and 
		 * automatically release lock after the sync-block. Prefer extrinsic locks 
		 * when additional features and complicated lock systems are required.
		 */
	}
}
