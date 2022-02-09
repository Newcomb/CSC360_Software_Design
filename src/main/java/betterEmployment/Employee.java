package betterEmployment;

//Employee superclass will have the basic variables and functions to be inherited by subclasses
public class Employee
{
	
	String firstName;
	String lastName;
	int hourlyRate;
	int hoursWorked;
	PayStrategy payType;
	
	/**
	 * @param fname - First Name
	 * @param lname	- Last Name
	 * @param rate - Rate of pay
	 */
	
	public Employee(String fName, String lName, int rate, PayStrategy p)
	{
		this.firstName = fName;
		this.lastName = lName;
		this.hourlyRate = rate;
		this.payType = p;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return the hourlyRate
	 */
	public int getHourlyRate()
	{
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(int hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	}

	/**
	 * @return the hoursWorked
	 */
	public int getHoursWorked()
	{
		return hoursWorked;
	}

	/**
	 * @param hoursWorked the hoursWorked to set
	 */
	public void setHoursWorked(int hoursWorked)
	{
		this.hoursWorked = hoursWorked;
	}
	
	/**
	 * Calls calculatePay() that is in the pay strategy and passes the Employee object
	 */
	public int calculatePay() 
	{
		return this.payType.calculatePay(this);
	}
	

	@Override
	public String toString()
	{
		return "Employee: " + firstName + " " + lastName + "\nHourly Rate: " + hourlyRate
				+ "\nHours Worked: " + hoursWorked;
	}
	
}
