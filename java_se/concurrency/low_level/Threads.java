package concurrency.low_level;

import java.util.concurrent.TimeUnit;

public class Threads {

	// Common fields: name, priority (which the TSch may use or ignore), etc.

	public static void commonMethods(Thread th) {

		// To access the current thread, the following syntax is used.
		Thread T2 = Thread.currentThread();
		T2 = new Thread(); // Resetting T2 for demo purposes.

		T2.setPriority(7); // Priority can be [0,10], 5 being the default.
		th.setPriority(Thread.MAX_PRIORITY);

		System.out.println(th.getName());
		
		try {

			// Used to pace (by adding delay between) requests for the current thread.
			Thread.sleep(500L); // Time in milliseconds.
			TimeUnit.SECONDS.sleep(5); // Can also use enum TimeUnit.

			// Used to indicate that the current thread is willing to yield CPU use.
			Thread.yield();

			/*
			 * Used to wait for a particular thread (in this case: T2) to die, before
			 * advancing to the next line of code.
			 */
			T2.join();
			
			// executes after T2 is dead.

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}
}
