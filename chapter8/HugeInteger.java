/**********************************************************\
|    Program: HugeInteger.java                             |
|     Author: Nathan Blue                                  |
|   Due Date: 11/1/16                                      |
| Assignment: Chapter 8 Program                            |
|    Purpose: The class used to add, subtract, and         |
|             compare huge integers                        |
|                                                          |
\**********************************************************/

import java.lang.StringBuilder;

public class HugeInteger
{
	/******************************************

				Attributes

	******************************************/
	int[] array;
	int digits;

	/******************************************

				Constructors

	******************************************/

	public HugeInteger()
	{
		array = new int[40];
		digits = 0;
		reset();
	}

	/******************************************

					Methods

	******************************************/

	public void parse(String string)
	{
		StringBuilder builder = new StringBuilder(string).reverse();
		digits = string.length();

		for(int i = 0; i < digits; i++)
		{
			if(builder.charAt(i) == 45)
				array[i] = builder.charAt(i);
			else
				array[i] = builder.charAt(i) - 48;
		}
	}

	public String toString()
	{
		String string = "";
		StringBuilder builder;

		for(int i = 0; i < digits; i++)
		{
			if(array[i] == 45)
				string += "-";
			else
				string += Integer.toString(array[i]);
		}

		builder = new StringBuilder(string).reverse();
		return builder.toString();
	}

	public void add(HugeInteger integer)
	{
		StringBuilder string1 = new StringBuilder(this.toString()).reverse();
		StringBuilder string2 = new StringBuilder(integer.toString()).reverse();
		int carry = 0;
		int length = 0;
		int holder = 0;
		int trimmer = 0;


		if(this.toString().charAt(0) == 45 && integer.toString().charAt(0) == 45)
		{
			string1 = new StringBuilder(string1.substring(0, string1.length() - 1)).reverse();
			string2 = new StringBuilder(string2.substring(0, string2.length() - 1)).reverse();
			trimmer = 1;
		}

		if(string1.length() > string2.length())
		{
			length = string1.length();
			for(int x = 0; x < (this.length() - integer.length()); x++)
				string2.append("0");
		}
		else
		{
			length = integer.length();

			for(int x = 0; x < (integer.length() - this.length()); x++)
				string1.append("0");

			digits = length - trimmer;
		}

		for(int i = 0; i < length; i++)
		{
			holder = (string1.charAt(i) - 48) + (string2.charAt(i) - 48) + carry;

			if(holder > 9)
			{
				array[i] = holder % 10;
				carry = 1;
			}
			else
			{
				array[i] = holder;
				carry = 0;
			}

			if(carry == 1 && (i == length - 1))
			{
				array[i+1] = 1;
				digits++;
			}
		}
	}

	public void subtract(HugeInteger integer)
	{
		StringBuilder string1 = new StringBuilder(this.toString()).reverse();
		StringBuilder string2 = new StringBuilder(integer.toString()).reverse();
		StringBuilder tempString;

		int carry = 0;
		int length = 0;
		int holder = 0;
		int nextNumber = 0;

		if(this.length() > integer.length())
		{
			length = this.length();

			for(int x = 0; x < (this.length() - integer.length()); x++)
				string2.append("0");
		}
		else
		{
			length = integer.length();

			for(int x = 0; x < (integer.length() - this.length()); x++)
				string1.append("0");

			digits = length;
		}

		for(int i = 0; i < length; i++)
		{
			if(carry == 10)
				holder = (string1.charAt(i) - 48) - (string2.charAt(i) - 48) - 1;
			else
				holder = (string1.charAt(i) - 48) - (string2.charAt(i) - 48);

			if(holder < 0)
				carry = 10;
			else
				carry = 0;

			holder = holder + carry;

			array[i] = holder;
		}

	}

	public boolean isEqualTo(HugeInteger integer)
	{
		return this.toString().equals(integer.toString());
	}

	public boolean isNotEqualTo(HugeInteger integer)
	{
		return !this.toString().equals(integer.toString());
	}

	public boolean isGreaterThan(HugeInteger integer)
	{
		int compare = this.toString().compareTo(integer.toString());

		if(compare > 0)
			return true;

		return false;
	}

	public boolean isLessThan(HugeInteger integer)
	{
		int compare = this.toString().compareTo(integer.toString());

		if(compare < 0)
			return true;

		return false;
	}

	public boolean isGreaterThanOrEqualTo(HugeInteger integer)
	{
		int compare = this.toString().compareTo(integer.toString());

		if(compare > 0 || compare == 0)
			return true;

		return false;
	}

	public boolean isLessThanOrEqualTo(HugeInteger integer)
	{
		int compare = this.toString().compareTo(integer.toString());

		if(compare < 0 || compare == 0)
			return true;

		return false;
	}

	public boolean isZero()
	{
		if(this.toString().matches("[^1-9]"))
			return true;

		return false;
	}

	public int getDigits()
	{
		return digits;
	}

	public int length()
	{
		return this.toString().length();
	}

	public void reset()
	{
		for(int i = 0; i < array.length; i++)
			array[i] = 0;
	}

}