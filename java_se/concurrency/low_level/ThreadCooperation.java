package concurrency.low_level;

/**
 * Thread Cooperation is the process of weaving threads such that they do not
 * collide, but cooperate.
 */
public class ThreadCooperation {

	// APPROACH 1
	public volatile double result = 0;
	public boolean workCompleted = false;

	public void approach1() {
		// Using volatile variables and control flow (naive approach):

		double requiredResult = 5;

		while (true) {
			// Recurringly execute code that relies on a separate thread executing.
			
			result = Math.random() * 10;	// temp replacement for actual code

			if (result > requiredResult) { // Checks to see if the code executed correctly.
				break;
			}
		}
	}

	// APPROACH 2
	public void approach2() {
		// Using wait() and notify() and sync blocks (better, not ideal):
		waitThread();
		notifyThread();
	}

	public void waitThread() {
		synchronized (this) {
			try {
				// Code executes.
				System.out.println("Running code...");

				while (!workCompleted) {
					
					System.out.println("Waiting...");
					this.wait();
					/*
					 * Halts the current sync block, putting the thread in a WAITING state, and
					 * releasing its lock. The WAITING thread then listens in for a notification.
					 */

					/*
					 * Typically, while loops are used to check if the notification was previously
					 * called {ie. notify() thread runs before wait() thread}, thus, wait() is not
					 * required; as well as to ensure that the wait() was not notified prematurely
					 * (can happen in some cases), in which cases, the thread must wait() again.
					 */
				}

				// Code executes once the notification is heard, and the lock is acquired again.
				System.out.println("Done waiting. Running code...");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void notifyThread() {

		synchronized (this) {
			// Code executes.
			workCompleted = true;

			this.notify(); // Notifies a random thread in the WAITING state.
			this.notifyAll(); // Notifies all threads in the WAITING state (preferred).
			/*
			 * Notifies threads in the WAITING state (with the same lock), which are then
			 * moved on to the BLOCKED state. The lock is not yet released.
			 */

			System.out.println("Running code...");

			System.out.println("Lock released.");
			// Lock is released at the end of the sync block.
		}
	}

	// APPROACH 3
	public void approach3() {
		// Using the Executor framework. High-level concurrency.
	}

}
