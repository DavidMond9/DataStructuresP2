package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the StudentIDComparator test class.
 * @author David Mond
 */
public class StudentIDComparatorTest {
	
	/**
	 * Test student 1.
	 */
	private Student sOne;
	/**
	 * Test Student 2.
	 */
	private Student sTwo;
	/**
	 * Test comparator for studentID.
	 */
	private StudentIDComparator comparator;
	/**
	 * Tests the set up for the comparator comparator.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");

		comparator = new StudentIDComparator();
	}
	/**
	 * Tests the actual comparator.
	 */
	@Test
	public void testCompare() {
		assertTrue(comparator.compare(sOne, sTwo) < 0);
		assertFalse(comparator.compare(sTwo, sOne) < 0);

	}


}
