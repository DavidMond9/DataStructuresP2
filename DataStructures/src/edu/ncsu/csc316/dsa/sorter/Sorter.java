package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * @author Dr. King
 * @param <E> type E for sorter.
 */
public interface Sorter<E> {
	
	/**
	 * Abstract method that sorts data.
	 * @param data data to be sorted.
	 */
	void sort(E[] data);
}
