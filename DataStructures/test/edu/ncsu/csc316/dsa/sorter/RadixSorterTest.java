package edu.ncsu.csc316.dsa.sorter;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;

/**
 * Tests the Radix Sorter with lists of students.
 * @author David Mond
 */
public class RadixSorterTest {
	/**
	 * Test student one.
	 */
	private Student sOne;
	/**
	 * Test student two.
	 */
	private Student sTwo;
	/**
	 * Test student three.
	 */
	private Student sThree;
	/**
	 * Test student four.
	 */
	private Student sFour;
	/**
	 * Test student five.
	 */
	private Student sFive;
	/**
	 * Sorter for Radix.
	 */
	private RadixSorter<Student> sorter;
	/**
	 * Tests the set up with students.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
		
		sorter = new RadixSorter<Student>();
	}
	/**
	 * Tests sorter with student.
	 */
	@Test
	public void testSortStudent() {
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}
}
