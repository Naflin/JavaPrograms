 /**********************************************************\
 |    Program: BluNathanEH.java                             |
 |     Author: Nathan Blue                                  |
 |   Due Date: 11/8/16                                      |
 | Assignment: Chapter 9 Program                            |
 |    Purpose: Driver program to test out and verify        |
 |            that the BasePlusCommissionEmployee           |
 |            CommissionEmployee, and Employee classes work |
 \**********************************************************/

public class BlueNathanEH
{
	public static void main(String[] args)
	{
		CommissionEmployee employee = new CommissionEmployee(
			"Sue", "Jones", "222-22-2222", 10000, .06);

		System.out.println("Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
		System.out.printf("%s %s%n", "Last name is", employee.getLastName());
		System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());

		employee.setGrossSales(5000);
		employee.setCommissionRate(.1);

		System.out.printf("%n%s:%n%n%s%n",
			"Updated employee informatin obtained by toString", employee);

		System.out.println("\n\n");

		BasePlusCommissionEmployee baseEmployee = new BasePlusCommissionEmployee(
			"Bob", "Lewis", "333-33-3333", 5000, .04, 300);

		System.out.println("Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", baseEmployee.getFirstName());
		System.out.printf("%s %s%n", "Last name is", baseEmployee.getLastName());
		System.out.printf("%s %s%n", "Social security number is", baseEmployee.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is", baseEmployee.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is", baseEmployee.getCommissionRate());
		System.out.printf("%s %.2f%n", "Base salary is", baseEmployee.getBaseSalary());

		baseEmployee.setBaseSalary(1000);

		System.out.printf("%n%s:%n%n%s%n",
			"Updated employee information obtained by toString",
			baseEmployee.toString());
	}
}