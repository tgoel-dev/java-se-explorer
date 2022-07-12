package concurrency.low_level;

/**
 * Concurrency (aka Multithreading, aka Parallel Programming) is an efficient
 * approach where multiple threads may be used to execute a program.
 * 
 * (+) Multithreading allows for faster execution of the program, better
 * resource (multi-core CPU) use, and limited halting.
 * 
 * (-) Quite complex, careful documentation is recommended.
 */
public class Multithreading {

	/*
	 * The speed of Sequential Programming = t1 + t2 + t3 + ... The speed of
	 * Parallel Programming = t1 || t2 || t3 || ...
	 */

	public static void threads(Runnable task) {

		/*
		 * java.lang.Thread is an executor of task.
		 * 
		 * Threads can be Daemon (background threads) or Non-Daemon (purposefully
		 * created by a program). As long as there is a single Non-Daemon thread
		 * running, JVM continues running.
		 * 
		 * Each thread gets its own call stack.
		 */
		Thread T1 = new Thread(task); // Thread status: NEW

		/*
		 * Runnable is a functional interface (method: run()) which executes the code
		 * within run(). A thread requires a task assignment to run.
		 */

		T1.start(); // Thread status: RUNNABLE

		/*
		 * The threads are scheduled to run by the THREAD SCHEDULER (temp: TSch). TSch
		 * runs a thread in the RUNNABLE state (and can also change its state to
		 * BLOCKED, WAITING). Once the thread completes execution, it is TERMINATED, and
		 * cannot be used again.
		 */

		// T1.start(); // Cannot be run a second time.

	}

	// Non-Daemon Main thread.
	public static void main(String[] args) {

		threads(new Runnable() {

			@Override
			public void run() {
				System.out.println("thread1: task1");
			}

		});
		
		System.out.println("main thread");
	}
}
