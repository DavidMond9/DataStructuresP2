package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Student Class.
 * @author David Mond
 */
public class StudentTest {
	/**
	 * Test student 1.
	 */
	private Student sOne;
	/**
	 * Test student 2.
	 */
	private Student sTwo;
	/**
	 * Tests the set up for student.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
	}
	/**
	 * Tests student first name.
	 */
	@Test
	
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}
	/**
	 * Tests student last name.
	 */
	@Test
	
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}
	/**
	 * Tests student ID.
	 */
	@Test

	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}
	/**
	 * Tests student GPA.
	 */
	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}
	/**
	 * Tests student Unity ID.
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}
	/**
	 * Tests student CompareTo.
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOne) == 0);
		assertTrue(sTwo.compareTo(sTwo) == 0);
	}
	/**
	 * Tests student toString.
	 */
	@Test
	public void testToString() {
		assertEquals(sOne.toString(), "Student [first=OneFirst, last=OneLast, id=1, creditHours=1, gpa=1.0, unityID=oneUnityID]");
	}
	
	/**
	 * Tests student hashCode.
	 */
	@Test
	
	public void testHashCode() {
		assertEquals(sOne.hashCode(), 1492839428);
	}
	
	/**
	 * Tests student Equals.
	 */
	@Test

	public void testEquals() {
		assertTrue(sOne.equals(sOne));
	}
}
