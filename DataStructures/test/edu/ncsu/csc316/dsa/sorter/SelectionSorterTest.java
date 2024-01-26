package edu.ncsu.csc316.dsa.sorter;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Selection Sorter with lists of integers.
 * @author David Mond
 */
public class SelectionSorterTest {
	/**
	 * Test list 1.
	 */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	/**
	 * Test list 2.
	 */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	/**
	 * Test list 3.
	 */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };
	/**
	 * Test selection sorter..
	 */
	private SelectionSorter<Integer> integerSorter;
	/**
	 * Sets up the selection.
	 */
	@Before
	public void setUp() {
		integerSorter = new SelectionSorter<Integer>();
	}
	/**
	 * Tests the sorter with integers.
	 */
	@Test
	public void testSortIntegers() {
		integerSorter.sort(dataAscending);
		assertTrue(dataAscending[0].equals(1));
		assertTrue(dataAscending[1].equals(2));
		assertTrue(dataAscending[2].equals(3));
		assertTrue(dataAscending[3].equals(4));
		assertTrue(dataAscending[4].equals(5));

		integerSorter.sort(dataDescending);
		assertTrue(dataDescending[0].equals(1));
		assertTrue(dataDescending[1].equals(2));
		assertTrue(dataDescending[2].equals(3));
		assertTrue(dataDescending[3].equals(4));
		assertTrue(dataDescending[4].equals(5));

		integerSorter.sort(dataRandom);
		assertTrue(dataRandom[0].equals(1));
		assertTrue(dataRandom[1].equals(2));
		assertTrue(dataRandom[2].equals(3));
		assertTrue(dataRandom[3].equals(4));
		assertTrue(dataRandom[4].equals(5));
	}

}
