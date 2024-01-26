package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA
 * @author Dr. King
 *
 */
public class StudentGPAComparator implements Comparator<Student> {

	/**
	 * Compares students based on GPA in descending order.
	 * @param one Student one to compare.
	 * @param two Student two to compare.
	 * @return int Returns negative if incorrect, positive if correct, and compareTo method if same.
	 */
	@Override
	public int compare(Student one, Student two) {
		if(one.getGpa() < two.getGpa()) {
			return 1;
		}
		else if(one.getGpa() > two.getGpa()) {
			return -1;
		}
		return 0;
	}
}
