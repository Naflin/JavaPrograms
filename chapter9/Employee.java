 /**********************************************************\
 |    Program: Employee.java                                |
 |     Author: Nathan Blue                                  |
 |   Due Date: 11/8/16                                      |
 | Assignment: Chapter 9 Program                            |
 |    Purpose: Employee class                               |
 |                                                          |
 |                                                          |
 \**********************************************************/

public class Employee
{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	public Employee(String firstName, String lastName, String socialSecurityNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %s %s%n%s: %s%n",
			"employee", firstName, lastName,
			"social security number", socialSecurityNumber);
	}
}