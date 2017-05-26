/**********************************************************\
|    Program: BlueNathanHR.java                            |
|     Author: Nathan Blue                                  |
|   Due Date: 10/25/16                                     |
| Assignment: Chapter 7 Program                            |
|    Purpose: Create a program that calculates a person's  |
|             age, maximum heart rate, target heart rate   |
|             that uses the HeartRates class.              |
\**********************************************************/

import java.util.Scanner;

public class BlueNathanHR
{
	public static void main(String[] args)
	{
		HeartRates hr = new HeartRates();
		Scanner input = new Scanner(System.in);
		String firstName;
		String lastName;
		String month;
		int year = 1970;
		int day = 1;

		System.out.println("Target Heart Rate Calculator\n\n");

		System.out.print("Enter your first name: ");
		firstName = input.nextLine();
		hr.setFirstName(firstName);

		System.out.print("Enter your last name: ");
		lastName = input.nextLine();
		hr.setLastName(lastName);

		System.out.println("\n\nPlease enter your birthday");

		do {
			System.out.print("\nMonth of birth (Ex. October): ");
			month = input.nextLine();

			if(hr.monthToInt(month) == 0)
				System.out.println("\nPlease enter a valid month of the year!\n");

		} while(hr.monthToInt(month) == 0);

		hr.setMonth(month);

		do {
			System.out.print("\nDay of birth (Ex. 19): ");
			day = input.nextInt();

			if(day < 1 || day > 31)
				System.out.println("\nPlease enter a valid day of the year!\n");

		} while(day < 1 || day > 31);

		hr.setDay(day);

		do {
			System.out.print("\nYear of birth (Ex. 1984): ");
			year = input.nextInt();

			if(year < 1900)
				System.out.println("\nPlease enter a year greater than 1900!\n");

		} while (year < 1900);

		hr.setYear(year);

		System.out.println("\n\n---------- Information -----------");

		System.out.println("First name\t\t: " + hr.getFirstName() +
						   "\nLast name\t\t: " + hr.getLastName() +
						   "\nDate of birth\t\t: " + hr.getMonth() + " " + hr.getDay() + " " + hr.getYear() +
						   "\nAge\t\t\t: " + hr.calculateAge(month, day, year) +
						   "\nMaximum heart rate\t: " + hr.maximumHeartRate() + " bpm" +
						   "\nTarget-heart rate range\t: " + hr.targetHeartRateLow() + " - "
						   	  + hr.targetHeartRateHigh() + " bpm\n\n");
	}
}