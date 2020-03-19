
/**
 * The employee class contains employees' first name, last name, ID 
 */

public class Employee implements Comparable<Employee> {
	private int ID;
	private String firstName;
	private String lastName;
	
	/**Constructor that initializes the values */
	public Employee(){
		ID = 0;
		firstName = " ";
		lastName = " ";
	}
	
	/**Overloaded constructor
	 * 
	 * @param fn first name
	 * @param ln last name
	 * @param ID Employee ID
	 */
	public Employee(String fn,String ln,int ID) {
		this.ID = ID;
		lastName = ln;
		firstName = fn;
	}
	
	/**Replaces the first name with a new value
	 * @param fn first name
	 */
	public void setfn(String fn) {
		firstName = fn;
	}
	
	/**Accessor method that replaces the last name with a new value
	 * @param ln last name
	 */
	public void setln(String ln) {
		lastName = ln;
	}
	
	/**Mutator method replaces the ID with a new value
	 * @param ID employee ID
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**Accessor method to get the first name
	 * @return first name
	 */
	public String getfn() {
		return firstName;
	}
	
	/**Accessor method to get the last name
	 * @return last name
	 */
	public String getln() {
		return lastName;
	}
	
	/**Accessor method to get the Employee ID
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	
	/**ToString method to convert the values to string */
	public String toString() {
		return String.format("\n%-7s%-15s%-15s", Integer.toString(ID), firstName, lastName);
	}
	
	/**Overridden compareTo method
	 * Method that orders employees' last names in abc order. But if employees share last names, it orders by first name
	 *  
	 */
	
	public int compareTo(Employee e) {
		if(lastName.compareTo(e.lastName) == 0) {
			if(firstName.compareTo(e.lastName) == 0) {
				return ID - e.ID;
			}
			return firstName.compareTo(e.firstName);
		}
		return lastName.compareTo(e.lastName);
	}
	
	/**Overridden equals method*/
	public boolean equals(Employee e) {
		if(lastName.equals(e.lastName) && firstName.equals(e.lastName) && ID == e.ID) {
			return true;
		}
		return false;
	}
	
	/*Calculates a hash code by combining the hash codes of the instance variables
	 * @return a hash code dependent on the instance variables
	 */
	public int hashCode() {
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer)ID).hashCode();
		return h;
	}
}