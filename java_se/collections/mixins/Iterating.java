package collections.mixins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * To be able to iterate over a collection/object via a for-each loop, the class
 * must use an Iterator object, or implement the Iterable interface (which in
 * turn uses an Iterator object).
 */
public class Iterating {

	@SuppressWarnings("unused")
	private class CollectionA<E extends Number> implements Iterable<Integer> {
		/*
		 * Iterable interface is typically used to define collections that can be
		 * iterated over, especially when there is only a single required way to iterate
		 * over a collection. Ex: iterating over each object in the collection.
		 * 
		 * A collection must implement Iterable (override iterator())in order for it to
		 * be used in a for-each loop.
		 */
		
		// Acting as replacement for a collection.
		public ArrayList<Integer> list = new ArrayList<>();

		@Override
		public Iterator<Integer> iterator() {
			return new PrimeIterator<Integer>(list);
		}

	}

	private class PrimeIterator<E extends Number> implements Iterator<Integer> {
		/*
		 * Iterator interface is typically used to allow for retrieval/removal of
		 * elements during iteration. The Iterator interface is typically used to define
		 * a method of iterating over an object.
		 * 
		 * Ex: A collection might only be required to iterate over prime numbers,
		 * odd/even numbers. For objects, it may be some distinct property.
		 * 
		 * (+) Iterator allows for altering of the elements being iterated over.
		 */

		private int cursor = 0;
		private List<Integer> collection;

		@Override
		public boolean hasNext() {

			if (cursor > collection.size()) {
				return false;
			}

			for (int i = cursor; i < collection.size(); i++) {
				if (isPrime(i)) {
					cursor = i;
					return true;
				}
			}

			return false;
		}

		@Override
		public Integer next() {
			return collection.get(cursor++);
		}
		
		/*
		 * Iterator behind the scenes:
		 * 
		 * while (hasNext()) {
		 * 		next();
		 * }
		 */

		public PrimeIterator(List<Integer> list) {
			this.collection = list;
		}

		private boolean isPrime(int n) {
			
			if (n <= 1) return false;
			if (n <= 3) return true;

			if (n % 2 == 0 || n % 3 == 0) return false;

			for (int i = 5; i * i <= n; i = i + 6) {
				if (n % i == 0 || n % (i + 2) == 0) return false;
			}
			
			return true;
		}
	}

}
