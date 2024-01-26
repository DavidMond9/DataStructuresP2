package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
    
	/**
	 * Constructor for SelectionSorter with comparator.
	 * @param comparator comparator for the sorter.
	 */
    public SelectionSorter(Comparator<E> comparator) {
        super(comparator);
    }
    /**
	 * Constructor for SelectionSorter with comparator.
	 */
    public SelectionSorter() {
    	this(null);
    }
      
    /**
     * Sorts the data using the Selection Sort technique.
     * @param data list to sort.
     */
    public void sort(E[] data) {
        for(int i = 0; i <= data.length - 1; i++) {
        	int min = i;
        	for(int j = i + 1; j <= data.length - 1; j++) {
        		if(super.compare(data[j], data[min]) < 1) {
        			min = j;
        		}
        	}
        	if(i != min) {
        		E x = data[i];
        		data[i] = data[min];
        		data[min] = x;
        	}
        }
    }
}
