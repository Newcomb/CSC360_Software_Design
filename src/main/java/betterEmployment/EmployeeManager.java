package betterEmployment;

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
	 * @payStrat - Interface for how employee gets paid
	 */
	public void addEmployee(String fName, String lName, int rate, PayStrategy payStrat)
	{
		EmpList.add(new Employee(fName, lName, rate, payStrat));
	}
	
	/**
	 * @param fname - First Name
	 * @param lname	- Last Name
	 * @param hoursWorked - Hours that the user wants to input for Employee
	 * Employee specified by first name and last name, then hours are updated
	 */
	public void setHoursWorked(String fName, String lName, int hoursWorked) throws Exception
	{
		if (hoursWorked < 0)
		{
			throw new Exception();
		}
		int l = EmpList.size();
		for (int i=0;i < l; i++)
		{
			if (EmpList.get(i).getFirstName() == fName && EmpList.get(i).getLastName() == lName)
			{
				EmpList.get(i).setHoursWorked(hoursWorked);
				return;
			}
		}
		throw new Exception();
	}
	
	/**
	 * Iterates through all employees and pays them based on number of hours worked.
	 * Returns an integer Array.
	 */
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
	
	/**
	 * @param fname - First Name
	 * @param lname	- Last Name
	 * Returns an employee based on first name and last name 
	 */
	public Employee getEmployee(String fName, String lName)
	{
		int l = EmpList.size();
		for (int i=0;i < l; i++)
		{
			if (EmpList.get(i).getFirstName() == fName && EmpList.get(i).getLastName() == lName)
			{
				return EmpList.get(i);
			}
		}
		return null;
	}

	
}
