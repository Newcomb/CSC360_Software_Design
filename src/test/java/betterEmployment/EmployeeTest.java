/**
 * 
 */
package betterEmployment;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hi.PersonAge;
import hi.UnderAgeException;

/**
 * @author newcomb
 *
 */
class EmployeeTest
{

	EmployeeManager EmpMan;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		// Create EmployeeManager that stores Employees
		EmpMan = new EmployeeManager();
		
		// Add a contractor to manager
		EmpMan.addEmployee("Bob", "Allen", 12, new PayStrategyContractor());
		
		// Add hourly workers to the manager
		EmpMan.addEmployee("Rick", "Allen", 13, new PayStrategyHourly());
		EmpMan.addEmployee("Trick", "Allen", 13, new PayStrategyHourly());
		
		// Set the hours worked for all 3 
		EmpMan.setHoursWorked("Bob", "Allen", 20);
		EmpMan.setHoursWorked("Rick", "Allen", 50);
		

	}
	
	@Test
	void testToString()
	{
		// Get string of employee with name and hours set
		assertEquals("Employee: Rick Allen\nHourly Rate: 13\nHours Worked: 50", EmpMan.getEmployee("Rick", "Allen").toString());
		
		//Get string of employee with name set and no hours
		assertEquals("Employee: Trick Allen\nHourly Rate: 13\nHours Worked: 0", EmpMan.getEmployee("Trick", "Allen").toString());
	}

	@Test
	void testEmployee()
	{
				
		// Test that hours worked are changed when name is provided
		try
		{
			EmpMan.setHoursWorked("Trick", "Allen", 46);
			
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("Threw exception");
		}
		// Assert new hours is 46
		assertEquals(46, EmpMan.getEmployee("Trick", "Allen").getHoursWorked());
		
		// Test that an exception is thrown when wrong name is entered
		try
		{
			EmpMan.setHoursWorked("Trik", "Allen", 30);
		} catch (Exception e)
		{
			System.out.println("Failed because name entered not in manager: GOOD FAILURE");
		}
		
		// Test that Employee Manager returns null when wrong name is searched
		assertEquals(null, EmpMan.getEmployee("Bob", "Richards"));

		// Check that paying employees returns the correct array
		assertEquals("[240, 715, 637]", Arrays.toString(EmpMan.payEmployees()));
		
		// Check that paying a contractor over 40 hours pays the appropriate amount
		try 
		{
			EmpMan.setHoursWorked("Bob", "Allen", 55);
		} catch (Exception e)
		{
			fail("Threw Exception");
		}
		// Check array
		assertEquals("[660, 715, 637]", Arrays.toString(EmpMan.payEmployees()));
		
		/**
		 *  Check that paying an hourly worker under 40 hours works
		 *  These also check that the ordering of the employees does not 
		 * Change after entrance
		 */
		try 
		{
			EmpMan.setHoursWorked("Rick", "Allen", 30);
		} catch (Exception e)
		{
			fail("Threw Exception");
		}
		// Check array
		assertEquals("[660, 390, 637]", Arrays.toString(EmpMan.payEmployees()));

		// Check that a contractor is added
		EmpMan.addEmployee("Dylan", "Rice", 20, new PayStrategyContractor());
		assertEquals("Employee: Dylan Rice\nHourly Rate: 20\nHours Worked: 0", EmpMan.getEmployee("Dylan", "Rice").toString());
		
		// Check that pay is calculated when someone has worked 0 hours
		assertEquals("[660, 390, 637, 0]", Arrays.toString(EmpMan.payEmployees()));
		
		// Check that incorrect hourly input throws an Exception
		try
		{
			EmpMan.setHoursWorked("Trick", "Allen", -30);
		} catch (Exception e)
		{
			System.out.println("Failed because hours worked cannot be negative: GOOD FAILURE");
		}
		
		
	}

}
