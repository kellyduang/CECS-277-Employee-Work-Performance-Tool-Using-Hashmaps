import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * User class contains methods to carry out different operations displayed in the menu
 */
public class User {
	Scanner in = new Scanner(System.in);
	private Map<Integer, Employee> employee;
	private Map<Employee,String> performance;
	
	/** Constructor which initializes the maps*/
	public User() {
		employee=new HashMap<Integer, Employee>();
		performance=new HashMap<Employee,String>();
	}
	/**Overloaded constructor
	 * @param e employee map which has Integer type key and Employee type values
	 * @param p performance map which has Employee type keys and String type values
	 */
	public User(Map<Integer, Employee> e, Map<Employee, String> p) {
		employee = e;
		performance = p;
	}
	/** Method used to get the employee map
	 * @return employee map 
	 */
	public Map<Integer, Employee> getEmployeemap(){
		return employee;
	}
	/** Method used to get the performance map
	 * @return performance map
	 */
	public Map<Employee,String> getPerformancemap(){
		return performance;
	}
}