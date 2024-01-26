package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {
    /**
     * Sorter for CountingSorter.
     * @param data list to sort.
     */
    public void sort(E[] data) {
        int min = data[0].getId();
        int max = data[0].getId();
        for(int i = 0; i <= data.length - 1; i++) {
        	min = Math.min(min, data[i].getId());
        	max = Math.max(max, data[i].getId());
        }
        int k = max - min + 1;
        int[] listB = new int[k];
        for(int i = 0; i <= data.length - 1; i++) {
        	listB[data[i].getId() - min] = listB[data[i].getId() - min] + 1;
        }
        for(int i = 1; i <= k - 1; i++) {
        	listB[i] = listB[i - 1] + listB[i];
        }
        @SuppressWarnings("unchecked")
        E[] listF = (E[])(new Identifiable[data.length]);
        for(int i = data.length - 1; i >= 0; i--) {
        	listF[listB[data[i].getId() - min] - 1] = data[i];
        	listB[data[i].getId() - min] = listB[data[i].getId() - min] - 1;
        }
        for(int i = 0; i < data.length; i++) {
        	data[i] = listF[i];
        }
    }
}
