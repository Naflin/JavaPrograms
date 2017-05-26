/*************************************************************\
|    Program: BluNathanTA.java                                |
|     Author: Nathan Blue                                     |
|   Due Date: 2/28/17                                         |
| Assignment: Chapter 15 Program                              |
|    Purpose: Given a number generate all the possible 7      |
|             letter combinations, save them to a file,       |
|             and then show the user the real words created   |
\*************************************************************/
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;;

public class BlueNathanTW
{
	public static void main(String[] args)
	{
		String number = "";
		String combo = "";
		String temp = "";
		char ch;
		int c;
		boolean isBadInput = true;
		ArrayList<String> list = new ArrayList<String>();
		int[] index = new int[7];
		int[] num = new int[7];
		char[] letters = {'A','B','C',
						  'D','E','F',
						  'G','H','I',
						  'J','K','L',
						  'M','N','O',
						  'P','R','S',
						  'T','U','V',
					  	  'W','X','Y'};

		Scanner input = new Scanner(System.in);
		PrintStream ps;

		while(number == "")
		{
			System.out.print("Please enter your phone number: ");
			number = input.nextLine();

			number = number.trim();
			number = number.replaceAll("[^\\d.]", "");

			if(number.length() != 7)
			{
				number = "";
				System.out.println("\nYour phone number must be 7 digits long.\n");
			}
			else
			{
				for(int i = 0; i < number.length(); i++)
				{
					ch = number.charAt(i);
					c = Character.getNumericValue(ch);
					if(c < 2)
					{
						System.out.println("You can't have numbers 0 or 1 in your phone number.");
						number = "";
						break;
					}

					index[i] = 0;
					num[i] = 3*(c-2);
				}
			}
		}

		System.out.println("\nChecking for 7 letter word matches...\n");

		try
		{
			input = new Scanner(Paths.get("enable1.txt"));
			while(input.hasNext())
			{
				temp = input.nextLine();
				if(temp.length() == 7)
					list.add(temp);
			}
			input.close();
		}
		catch(IOException e)
		{
			System.err.println("\nError opening file. Terminating.\n");
			System.exit(1);
		}
		catch(NoSuchElementException e)
		{
			System.err.println("\nFile improperly formed. Terminating.\n");
		}
		catch(IllegalStateException e)
		{
			System.err.println("\nError reading from file. Terminating.\n");
		}

		try
		{
			ps = new PrintStream(new FileOutputStream("words.txt"));

			System.out.println("\n\tReal Word List:");

			for(int i = 0; i < 2187; i++)
			{
				combo = String.valueOf(letters[index[0]+num[0]]) +
						String.valueOf(letters[index[1]+num[1]]) +
						String.valueOf(letters[index[2]+num[2]]) +
						String.valueOf(letters[index[3]+num[3]]) +
						String.valueOf(letters[index[4]+num[4]]) +
						String.valueOf(letters[index[5]+num[5]]) +
						String.valueOf(letters[index[6]+num[6]]);

				ps.println(combo);

				for(int x = 0; x < list.size(); x++)
					if(combo.equalsIgnoreCase(list.get(x)))
						System.out.println("\t" + combo);

				for(int j = 0; j < 7; j++)
				{
					if(index[j] == 2)
						index[j] = 0;
					else
					{
						index[j]++;
						break;
					}
				}
			}
			ps.flush();
			ps.close();
			System.out.println("\nCheck words.txt for all character combinations.\n");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("\nwords.txt not found!\n");
		}
		System.out.println("\n\n");
	}
}