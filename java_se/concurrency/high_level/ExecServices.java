package concurrency.high_level;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ExecutorService extends Executor and provides methods for submitting tasks to
 * the work queue, and managing termination.
 */
@SuppressWarnings("unused")
public class ExecServices {

	private ExecutorService exec;
	private ExecutorService exec2;
	/*
	 * (::) Use different executors (pools) for different services.
	 * 
	 * (+) Allows for proper thread count allocation (ie. heavy services get more
	 * threads, light services get fewer threads).
	 */

	Runnable r;
	// Used to run a particular task.

	Callable<?> c;
	/*
	 * Used to represent tasks that may take time to complete execution, and/or
	 * other tasks depend on their computation result.
	 */

	public void submittingTasks() {

		exec = Executors.newFixedThreadPool(4);
		exec2 = Executors.newFixedThreadPool(2);

		/*
		 * For ExecutorService, tasks can be either Callable or Runnable, and are
		 * submitted to the work queue (which will be executed as soon as an idle thread
		 * is available). Submit returns an instance of Future<V>.
		 */
		Future<?> fr = exec.submit(r);
		Future<?> fc = exec2.submit(c);
		/*
		 * Future<V> represents the result of a computation, or in other words, the
		 * life-cycle of a task. It allows for managing of the task.
		 */

		exec.execute(r);
		/*
		 * The execute(r || c) method is similar to submit, but does not return a Future
		 * instance.
		 */

		try {

			/*
			 * THREAD COOPERATION
			 * 
			 * F.get() halts the current thread and waits for the computation in F to
			 * complete, and then retrieves its result (which notifies current thread).
			 * 
			 * [No need to define a specific lock; current thread and F are simply inferred
			 * to be sharing the same lock.]
			 */
			fr.get(); // Returns null
			fc.get(); // Returns result

			fc.get(5L, TimeUnit.SECONDS); // Returns result || throws TimeoutExc.
			// Placing time limits on tasks is extremely important, to allow for resource
			// use.

			// THREAD INTERRUPTION
			boolean interruptEvenIfRunning = true;
			fr.cancel(interruptEvenIfRunning); // .cancel(true/false) is used for thread interruption.

			// A task cannot be cancelled if:
			boolean cannotBeInterrupted = fr.isCancelled() || fr.isDone();

		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		List<Future<?>> taskList = new ArrayList<Future<?>>();
		taskList.add(fc);
		taskList.add(fr);

	}

	public <T> void timingTasks(List<Callable<T>> listOfCallables) {

		Future<T> fc = exec.submit(listOfCallables.get(0));

		try {
			// Timed get() call specifies the time limit for each particular task.
			fc.get(3, TimeUnit.SECONDS);

		} catch (InterruptedException | ExecutionException | TimeoutException e1) {
			e1.printStackTrace();
		}

		// Preferred approach: pools the time taken for execution of all listed tasks.
		try {
			List<Future<T>> listOfFutures = exec.invokeAll(listOfCallables, 60, TimeUnit.SECONDS);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void shuttingDownExecServices() throws InterruptedException {

		exec.shutdown();
		/*
		 * ExecServices no longer accepts any tasks, but executes all remaining tasks in
		 * the queue, prior to shutting down.
		 */

		if (!exec.awaitTermination(60, TimeUnit.SECONDS)) {

			exec.shutdownNow();
			/*
			 * ExecServices no longer accepts any tasks, abandons any tasks remaining in the
			 * queue, and interrupts any running tasks (may fail). Shuts down ASAP.
			 */

			if (!exec.awaitTermination(60, TimeUnit.SECONDS)) {
				System.out.println("Could not terminate!");
			}
		}

	}
}
