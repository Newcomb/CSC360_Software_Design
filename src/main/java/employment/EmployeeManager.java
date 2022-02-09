package employment;

import java.util.*;

public class EmployeeManager
{
	LinkedList<Employee> EmpList = new LinkedList<Employee>();
	
	public EmployeeManager()
	{
		
	}
	
	/**
	 * @param fname - First Name
	 * @param lname	- Last Name
	 * @param rate - Rate of pay
	 */
	public void addContractor(String fName, String lName, int rate)
	{
		EmpList.add(new Contractor(fName, lName, rate));
	}
	
	/**
	 * @param fname - First Name
	 * @param lname	- Last Name
	 * @param rate - Rate of pay
	 */
	public void addHourly(String fName, String lName, int rate)
	{
		EmpList.add(new Hourly(fName, lName, rate));
	}
	
	public void addHoursWorked(String fName, String lName, int hoursWorked)
	{
		int l = EmpList.size();
		for (int i=0;i < l; i++)
		{
			if (EmpList.get(i).getFirstName() == fName && EmpList.get(i).getLastName() == lName)
			{
				EmpList.get(i).setHoursWorked(hoursWorked);
			}
		}
	}
	
	public int[] payEmployees() 
	{
		int l = EmpList.size();
		int arr[] = new int[l];
		for (int i=0;i < l; i++)
		{
			arr[i] = EmpList.get(i).calculatePay();
		}
		return arr;
	}
	

	public static void main(String[] args)
	{
		EmployeeManager EmpMan = new EmployeeManager();
		EmpMan.addContractor("Bob", "Allen", 12);
		
		EmpMan.addHourly("Rick", "Allen", 13);
		EmpMan.addHoursWorked("Bob", "Allen", 20);
		EmpMan.addHoursWorked("Rick", "Allen", 50);
		System.out.println(Arrays.toString(EmpMan.payEmployees()));
	}
	
}
