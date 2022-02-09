package betterEmployment;

public class PayStrategyContractor implements PayStrategy
{
	/**
	 * @param e- Employee that called the function is passed
	 * Accesses hours worked and rate to calculate pay for contract workers
	 */
	@Override
	public int calculatePay(Employee e)
	{
		return e.getHoursWorked() * e.getHourlyRate();
	}

}
