package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	/**
	 * The initial capacity of the list if the client does not provide a capacity
	 * when constructing an instance of the array-based list
	 **/
	private final static int DEFAULT_CAPACITY = 16;

	/** The array in which elements will be stored **/
	private E[] data;

	/** The number of elements stored in the array-based list data structure **/
	private int size;

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * default initial capacity of the internal array
	 */
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * provided initial capacity
	 * 
	 * @param capacity the initial capacity of the internal array used to store the
	 *                 list elements
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	/**
	 * Adds a value to the array based list at a specific index.
	 * 
	 * @param index the index for the value
	 * @param value the value to add
	 */
	public void add(int index, E value) {
		checkIndexForAdd(index);
		ensureCapacity(index);
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = value;
		size++;
	}

	/**
	 * To ensure amortized O(1) cost for adding to the end of the array-based list,
	 * use the doubling strategy on each resize. Here, we add +1 after doubling to
	 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
	 * still produce a capacity of 0).
	 * 
	 * @param minCapacity the minimium capacity that must be supported by the
	 *                    internal array
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 2) + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	/**
	 * Removes a value from the array based list at a specific index. 
	 * @param index Index to remove value from.
	 * @return returns the value removed.
	 */
	public E remove(int index) {
		checkIndex(index);
		E temp = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[size - 1] = null;
		size--;
		return temp;
	}

	/**
	 * Gets a value from the array at a specific index. 
	 * @param index Index to get value from.
	 * @return returns the value that was retrieved.
	 */
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	/**
	 * Sets a value to the array at a specific index. 
	 * @param index Index to set value to.
	 * @param value Value to set at the specific index.
	 * @return returns the value that was set.
	 */
	public E set(int index, E value) {
		checkIndex(index);
		E temp = data[index];
		data[index] = value;
		return temp;
	}

	/**
	 * Retrieves the size field.
	 * @return returns the size of array.
	 */
	public int size() {
		return size;
	}


	private class ElementIterator implements Iterator<E> {
		private int position;
		private boolean removeOK;

		/**
		 * Construct a new element iterator where the cursor is initialized to the
		 * beginning of the list.
		 */
		public ElementIterator() {
			position = 0;
			removeOK = false;
		}

		public boolean hasNext() {
			return position < size;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No such element.");
			}
			removeOK = true;
			return data[position++];
		}

		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException("Illegal State Exception");
			}
			ArrayBasedList.this.remove(position - 1);
			position--;
			removeOK = false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

}