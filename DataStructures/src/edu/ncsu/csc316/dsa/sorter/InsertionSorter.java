package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * @param <E> the generic type of data to sort
 * @author Dr. King
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
    
	/**
	 * Constructor for InsertionSorter, has a comparator.
	 * @param comparator comparator for the sorter.
	 */
    public InsertionSorter(Comparator<E> comparator) {
    	super(comparator);
    }
    /**
     * Constructor for InsertionSorter, no comparator.
     */
    public InsertionSorter() {
        super(null);
    }
    
    /**
     * Sorts using the Insertion Sort technique.
     * @param data list to sort.
     */
    public void sort(E[] data) { 
        for (int i = 1; i < data.length; i++) {
            E x = data[i];
            int j = i - 1;
            while (j >= 0 && super.compare(data[j], x) == 1){
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = x;
        }
    }
}
