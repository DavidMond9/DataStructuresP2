package edu.ncsu.csc316.dsa.data;

/**
 * A student is comparable and identifiable.
 * Students have a first name, last name, id number, 
 * number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 *
 */
public class Student implements Comparable<Student>, Identifiable {
	/**
	 * Represents the first name of the student.
	 */
	private String first;
	/**
	 * Represents the last name of the student.
	 */
	private String last;
	/**
	 * Represents the id of the student.
	 */
	private int id;
	/**
	 * Represents the credit hours of the student.
	 */
	private int creditHours;
	/**
	 * Represents the gpa of the student.
	 */
	private double gpa;
	/**
	 * Represents the unity ID of the student.
	 */
	private String unityID;
	/**
	 * Constructor that creates a student with all the fields above.
	 * @param first first name of the student.
	 * @param last last name of the student.
	 * @param id id of the student.
	 * @param creditHours credit hours of the student.
	 * @param gpa gpa of the student.
	 * @param unityID unity ID of the student.
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(creditHours);
		setGpa(gpa);
		setUnityID(unityID);
	}
	/**
	 * Gets the first name.
	 * @return returns the first name
	 */
	public String getFirst() {
		return first;
	}
	/**
	 * Sets the first name.
	 * @param first first name to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	/**
	 * Gets the last name.
	 * @return returns the last name
	 */
	public String getLast() {
		return last;
	}
	/**
	 * Sets the last name.
	 * @param last last name to set
	 */
	public void setLast(String last) {
		this.last = last;
	}
	/**
	 * Gets the id.
	 * @return returns the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Sets the id.
	 * @param id id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Gets the credit hours.
	 * @return returns the credit hours.
	 */
	public int getCreditHours() {
		return creditHours;
	}
	/**
	 * Sets the credit hours.
	 * @param creditHours credit hours to set
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	/**
	 * Gets the gpa.
	 * @return returns the gpa.
	 */
	public double getGpa() {
		return gpa;
	}
	/**
	 * Sets the gpa.
	 * @param gpa gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * Gets the unity ID.
	 * @return returns the unity ID
	 */
	public String getUnityID() {
		return unityID;
	}
	/**
	 * Sets the unity ID.
	 * @param unityID unity ID to set.
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}
	/**
	 * Compares 2 students by first name, last name, and student ID.
	 * @param o student to compare.
	 * @return int returns a comparison integer.
	 */
	@Override
	public int compareTo(Student o) {
		if(last.compareTo(o.getLast()) > 0) {
			return 1;
		}
		else if(last.compareTo(o.getLast()) < 0) {
			return -1;
		}
		
		if(first.compareTo(o.getFirst()) > 0) {
			return 1;
		}
		else if(first.compareTo(o.getFirst()) < 0) {
			return -1;
		}
		if(id < o.getId()) {
			return 1;
		}
		else if(id > o.getId()) {
			return -1;
		}
		return 0;
	}
	/**
	 * Gets the hashcode for a student by first name, last name, and student ID.
	 * @return int returns the hashcode as an integer.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + id;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		return result;
	}
	/**
	 * Checks to see if 2 students are equal with first name, last name, and student ID.
	 * @param obj student to compare
	 * @return boolean returns true if same, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return false;
	}
	/**
	 * Returns the student in string format.
	 * @return returns a string for the student.
	 */
	@Override
	public String toString() {
		return "Student [first=" + first + ", last=" + last + ", id=" + id + ", creditHours=" + creditHours + ", gpa="
				+ gpa + ", unityID=" + unityID + "]";
	}
	
}
