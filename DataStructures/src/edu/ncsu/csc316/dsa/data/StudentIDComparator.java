package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator to compare students based on id number
 * @author Dr. King
 *
 */
public class StudentIDComparator implements Comparator<Student> {

	/**
	 * Compares students based on id number in ascending order
	 * @param one Student one to compare
	 * @param two Student two to compare
	 * @return int Returns positive if correct, negative if incorrect, 0 if same.
	 */
	@Override
	public int compare(Student one, Student two) {
		if(one.getId() > two.getId()) {
			return 1;
		}
		else if(one.getId() < two.getId()) {
			return -1;
		}
		return 0;
	}

}
