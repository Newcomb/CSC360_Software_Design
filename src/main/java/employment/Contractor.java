package employment;

public class Contractor extends Employee
{

	/**
	 * @param fname - First Name
	 * @param lname	- Last Name
	 * @param rate - Rate of pay
	 */
	public Contractor(String fName, String lName, int rate)
	{
		super(fName, lName, rate);
	}
	
	/**
	 * @param hoursWorked - Number of hours worked by an employee
	 */
	@Override
	public int calculatePay()
	{
		
		return this.hoursWorked * this.hourlyRate;
	}
	

}
