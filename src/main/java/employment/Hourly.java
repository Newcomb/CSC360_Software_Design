package employment;

public class Hourly extends Employee
{
	/**
	 * @param fname - First Name
	 * @param lname	- Last Name
	 * @param rate - Rate of pay
	 */
	public Hourly(String fName, String lName, int rate) 
	{
		super(fName, lName, rate);
	}
	
	/**
	 * @param hoursWorked - Number of hours worked by an employee
	 */
	@Override
	public int calculatePay()
	{
		if (this.hoursWorked <= 40)
		{
			return this.hoursWorked * this.hourlyRate;
		}
		else 
		{
			int overtime = this.hoursWorked%40;
			return (int) (40*this.hourlyRate + overtime*(this.hourlyRate)*1.5);
		}
	}
}
