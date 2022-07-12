package concurrency.high_level;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * The Executor framework (java.util.concurrent.Executors) is the
 * industry-preferred approach to concurrency.
 */
@SuppressWarnings("unused")
public class ExecutorFramework {

	/*
	 * The executor framework overcomes the thread-per-task approach of low-level
	 * concurrency (which can result in high thread creation/deletion costs), and
	 * instead utilizes a thread pool (with re-usable threads), and a work queue
	 * (FIFO list of tasks).
	 * 
	 * (+) Fixed thread pool size, and wide variety of thread pools.
	 */

	public static void threadPools() {

		final int MAX_THREADS_ALLOWED = 3;

		// The Executors class provides static factory methods.
		Executor fixedExec = Executors.newFixedThreadPool(MAX_THREADS_ALLOWED);
		/*
		 * Fixed Th Pool creates new threads as new tasks are submitted. Once the thread
		 * limit is reached, the new tasks are added to the work queue, and wait on
		 * threads to be idle.
		 * 
		 * (+) Esp. useful for heavy-load production servers.
		 */

		Executor singleExec = Executors.newSingleThreadExecutor(); // Single Th Executor = .newFixedThreadPool(1);

		Executor cachedExec = Executors.newCachedThreadPool();
		/*
		 * A cached Th Pool does not have a work queue. Any new tasks are either
		 * assigned to existing idle threads, or new threads are created for them. An
		 * idle thread is TERMINATED after 60s.
		 * 
		 * (+) Esp. useful for light-load production servers.
		 */

		Executor scheduledExec = Executors.newScheduledThreadPool(MAX_THREADS_ALLOWED);
		/*
		 * Creates a fixed sized pool for each: Delayed tasks {run after a set period}
		 * and Periodic tasks {run every set period}.
		 */

	}

	public static void executingTasks(Runnable r) {

		Executor fixedExec = Executors.newFixedThreadPool(3);

		fixedExec.execute(r);
		// .execute is used to add Runnable to the work queue.

		/*
		 * Note: Executor objects do not close or auto-close. Thus, ExecutorService is
		 * preferred.
		 */
		while (fixedExec != null) {
			System.out.println("Executor still running. Terminate program!");
		}
	}

	public static void main(String[] args) {

		ExecutorFramework.executingTasks(new Runnable() {

			@Override
			public void run() {
				System.out.println("Runs");
			}

		});
	}
}
