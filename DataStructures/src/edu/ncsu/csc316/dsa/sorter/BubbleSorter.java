package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * BubbleSorter class, extends Comparable and AbstractComparisonSorter. Uses the bubble
 * sort to sort different lists.
 * @param <E> the generic type of data to sort
 * @author David Mond
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	/**
	 * Constructor for BubbleSorter, no comparator.
	 */
	public BubbleSorter() {
		super(null);
	}
	/**
	 * Constructor for BubbleSorter, comparator.
	 * @param comparator comparator for the sorter.
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}
	/**
	 * Sorts using the BubbleSort technique.
	 * @param data list to sort.
	 */
	public void sort(E[] data) {
		boolean r = true;
		while(r) {
			r = false;
			for(int i = 1; i < data.length; i++) {
				if(super.compare(data[i], data[i - 1]) < 0) {
					E x = data[i - 1];
					data[i - 1] = data[i];
					data[i] = x;
					r = true;
				}
			}
		}
	}
}
