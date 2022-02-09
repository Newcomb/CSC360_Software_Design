package betterEmployment;

public class PayStrategyHourly implements PayStrategy
{
	/**
	 * @param e- Employee that called the function is passed
	 * Accesses hours worked and rate to calculate pay for hourly workers
	 */
	@Override
	public int calculatePay(Employee e)
	{
		if (e.getHoursWorked() <= 40)
		{
			return e.getHoursWorked() * e.getHourlyRate();
		}
		else 
		{
			int overtime = e.getHoursWorked()-40;
			return (int) (40*e.getHourlyRate() + overtime*(e.getHourlyRate())*1.5);
		}

	}

}
