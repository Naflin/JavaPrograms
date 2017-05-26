/**********************************************************\
|    Program: HeartRates.java                              |
|     Author: Nathan Blue                                  |
|   Due Date: 10/25/16                                     |
| Assignment: Chapter 7 Program                            |
|    Purpose: The class used to calculate a person's age,  |
|             maximum heart rate, and target heart rate    |
|                                                          |
\**********************************************************/

import java.time.LocalDate;
import java.time.Period;

public class HeartRates
{
	/******************************************

					Attributes

	******************************************/

	private String firstName;
	private String lastName;
	private String month;
	private int day;
	private int year;

	/******************************************

					Constructors

	******************************************/

	public HeartRates()
	{
		this.firstName = "John";
		this.lastName = "Doe";
		this.month = "January";
		this.day = 1;
		this.year = 1970;
	}

	public HeartRates(String firstName, String lastName, String month, int day, int year)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/******************************************

					Getters

	******************************************/

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getMonth()
	{
		return month;
	}

	public int getDay()
	{
		return day;
	}

	public int getYear()
	{
		return year;
	}

	/******************************************

					Setters

	******************************************/

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public void setMonth(String month)
	{
		this.month = month;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	/******************************************

						Methods

	******************************************/

	public int maximumHeartRate()
	{
		return 220 - calculateAge(month, day, year);
	}

	public int targetHeartRateLow()
	{
		return (int)((220 - calculateAge(month, day, year)) * 0.5);
	}

	public int targetHeartRateHigh()
	{
		return (int)((220 - calculateAge(month, day, year)) * .85);
	}

	public int monthToInt(String month)
	{
		switch(month)
		{
			case "january" 	:
			case "January" 	: return 1;
			case "february" :
			case "February" : return 2;
			case "march" 	:
			case "March" 	: return 3;
			case "april" 	:
			case "April" 	: return 4;
			case "may" 		:
			case "May" 		: return 5;
			case "june"		:
			case "June" 	: return 6;
			case "july" 	:
			case "July" 	: return 7;
			case "august" 	:
			case "August" 	: return 8;
			case "september":
			case "September": return 9;
			case "october"  :
			case "October"  : return 10;
			case "november" :
			case "November" : return 11;
			case "december" :
			case "December" : return 12;
			default : return 0;
		}
	}

	public int calculateAge(String month, int day, int year)
	{
			int m = monthToInt(month);

			LocalDate birthDate = LocalDate.of(year, m, day);
			LocalDate currentDate = LocalDate.now();
			Period p = Period.between(birthDate, currentDate);

			return p.getYears();
	}
}