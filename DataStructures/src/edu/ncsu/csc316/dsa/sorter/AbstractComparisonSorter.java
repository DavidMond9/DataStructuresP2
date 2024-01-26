package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * AbstractComparisonSorter for all of the types of sorters, central interface.
 * @param <E> type to compare.
 * @author David Mond
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {
	/**
	 * Comparator to use for the different methods.
	 */
    private Comparator<E> comparator;
    
    /**
     * Constructor for the abstract comparison.
     * @param comparator abstract comparator.
     */
    public AbstractComparisonSorter(Comparator<E> comparator) {
        setComparator(comparator);
    }
    
    /**
     * Sets the comparator.
     * @param comparator comparator to set.
     */
    private void setComparator(Comparator<E> comparator) {
        if(comparator == null) {
            this.comparator = new NaturalOrder();
        } else {
            this.comparator = comparator;
        }
    }   
    
    /**
     * Inner class for the NaturalOrder. Implements comparator and has compare
     * method to compare with the comparator.
     */
    private class NaturalOrder implements Comparator<E> {
    	/**
    	 * Compare function in natural order.
    	 * @param first first element to compare
    	 * @param second second element to compare
    	 * @return returns a comparable with compareTo function.
    	 */
        public int compare(E first, E second) {
            return ((Comparable<E>) first).compareTo(second);
        }
    }
    
    /**
     * Compare method outside of the NaturalOrder.
     * @param first first to compare.
     * @param second second to compare.
     * @return returns positive if greater, negative if less, 0 if equal.
     */
    public int compare(E first, E second) {
        return comparator.compare(first,  second);
    }
}
