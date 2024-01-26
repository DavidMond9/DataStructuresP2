package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {
	
	/**
	 * Sorts using the Radix Sort technique.
	 * @param data list to sort.
	 */
	public void sort(E[] data) {
		int k = 0;
		for(int i = 0; i <= data.length - 1; i++) {
			k = Math.max(k, data[i].getId());
		}
		double x = Math.ceil(Math.log(k + 1) / Math.log(10));
		int p = 1;
		for(int j = 1; j <= x; j++) {
			int[] listB = new int[10];
			for(int i = 0; i <= data.length - 1; i++) {
				listB[(data[i].getId() / p) % 10] = listB[(data[i].getId() / p) % 10] + 1;
			}
			for(int i = 1; i <= 9; i++) {
				listB[i] = listB[i - 1] + listB[i];
			}
			@SuppressWarnings("unchecked")
			E[] listF = (E[])(new Identifiable[data.length]);
			for(int i = data.length - 1; i >= 0; i--) {
				listF[listB[(data[i].getId() / p) % 10] - 1] = data[i];
				listB[(data[i].getId() / p) % 10] = listB[(data[i].getId() / p) % 10] - 1;
			}
			
			for(int i = 0; i <= data.length - 1; i++) {
				data[i] = listF[i];
			}
			p = p * 10;
		}
	}
}
