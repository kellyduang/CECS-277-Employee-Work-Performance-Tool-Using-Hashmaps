import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class tester{
	
	/*
	 * Operates depending on option user selects
	 */
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		int choice = 0;

		Map<Integer, Employee> employee = new TreeMap<Integer, Employee>();

		Map<Employee, String> performamce = new TreeMap<Employee, String>();

		Set<Employee> hash2 = new HashSet<Employee>();

		while(choice!= 5){

			printMenuAndGetChoice();

			choice = input.nextInt();

			if(choice == 1){

				add(employee,performamce);
			}

			if(choice == 2){

				remove(employee,performamce);
			}

			if(choice == 3)
			{

				modify(employee,performamce);

			}

			if(choice == 4)
			{

				print(performamce);
			}

			if(choice == 5){

				System.out.println("You have exited the program. Bye bye!");

			}

		}
	}
	
	/** Method that adds a new employee
	 * @param employee employee map
	 * @param performance performance map
	 */
	public static void add(Map<Integer, Employee> employee, Map<Employee, String> performance) {
		Scanner in = new Scanner(System.in);
		System.out.println("~Add an employee below~ ");
		System.out.print("Enter the last name:  ");
		String ln = in.next();
		System.out.print("Enter the first name:  ");
		String fn = in.next();
		System.out.print("Enter the Employee ID:  ");
		int id = in.nextInt();
		System.out.print("Enter the employee's work performance (Best to worst - 5, 4, 3, 2, 1):  ");
		String Performance = in.next();
		//Gives user error message when they enter duplicate employee ID
		while(employee.containsKey(id)) {
			System.out.println("!ERROR! The Employee ID number already exists. Please try Again. \nEnter the Employee ID number");
			id = in.nextInt();
		}
		
		Employee e = new Employee(fn,ln,id);
		employee.put(e.getID(), e);
		performance.put(e, Performance);
		
	}
	
	/**Method that removes a student
	 * @param employee employee map
	 * @param performance performance map
	 */
	public static void remove(Map<Integer, Employee> employee, Map<Employee,String> grade) {
		Scanner in = new Scanner(System.in);
		System.out.println("~Remove an employee~ ");
		System.out.print("Enter the ID of the employee you want to remove:  ");
		int id = in.nextInt();
		//checks if user enters an existing ID
		if(!employee.containsKey(id)) {
			System.out.print("!Error! That ID does not exist. Please try again. ");
		}
		else {
		grade.remove(employee.get(id));
		employee.remove(id);
		}
	}
	
	/**Method that modifies employees' performance
	 * @param employee employee map
	 * @param performance performance map
	 */
	public static void modify(Map<Integer, Employee> employee, Map<Employee, String> performance) {
		Scanner in = new Scanner(System.in);
		System.out.println("~Modify employee's work performance~ ");
		System.out.print("Enter the ID number of the employee whose performance you want to modify:  ");
		int id = in.nextInt();
		//checks if user enters an existing ID
		if(!employee.containsKey(id)) {
			System.out.print("!Error! That ID does not exist. Please try again. ");
		}
		else {
		System.out.print("Enter the new work performance:  ");
		String Performance = in.next();
		performance.put(employee.get(id), Performance);
		}
	}
	
	/**Method that prints all of the employees and their performances
	 * @param performance performance map
	 */
	public static void print(Map <Employee, String> performance) {
		List<Employee> employee = new ArrayList<Employee>(performance.keySet());
		Collections.sort(employee);
		System.out.printf("\n%-7s%-15s%-15s%-10s","ID","First Name", "Last Name","Work Performance");
		System.out.println("\n------------------------------------------------");
		Iterator<Employee> eI = employee.iterator();
		while(eI.hasNext()) {
			Employee em = (Employee)eI.next();
			System.out.println(em.toString() + " " + performance.get(em));
		}

	}	
	/*
	 * Method that prints menu 
	 */
	public static void printMenuAndGetChoice(){
			System.out.println("\nChoose a number: ");
			System.out.println("1. Add an Employee");
			System.out.println("2. Remove an Employee");
			System.out.println("3. Modify an Employee's work performance");
			System.out.println("4. Print all the Employees' work performances");
			System.out.println("5. Exit");
		}
		
}	

