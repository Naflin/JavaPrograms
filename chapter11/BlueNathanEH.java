/**********************************************************\
|    Program: BluNathanEH.java                             |
|     Author: Nathan Blue                                  |
|   Due Date: 11/22/16                                     |
| Assignment: Chapter 11 Program                           |
|    Purpose: A simple survey program that includes        |
|             exception checking.                          |
|                                                          |
\**********************************************************/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BlueNathanEH
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String fileName = "";
		String currentLine = null;
		String[][] array = new String[52][2];
		String homeState = "";
		String stateName = "";
		String zipCodeString = "";
		String zeros = "";
		int row = 0;
		int age = 0;
		int zipCode = 0;
		boolean flag = true;
		boolean quit = false;

		System.out.println("Welcome to the survey!\n");

		try {
			System.out.print("What is your age?: ");
			age = input.nextInt();
			input.nextLine();

			do {
				try {
					System.out.print("\nPlease enter the file containing the state " +
									 "names and their abbreviations\n" +
									 "Or enter Quit to exit.\n=> ");
					fileName = input.nextLine();

					if(!fileName.equalsIgnoreCase("quit"))
					{
						FileReader fileReader = new FileReader(fileName);
						BufferedReader bufferedReader = new BufferedReader(fileReader);

						while((currentLine = bufferedReader.readLine()) != null)
						{
							array[row][0] = currentLine.substring(0,2);
							array[row][1] = currentLine.substring(3);
							row++;
						}

						bufferedReader.close();
						flag = false;
					}
					else
						quit = true;
				}
				catch(FileNotFoundException e)
				{
					System.out.println("\n- File not found and cannot be opened");
					flag = true;
				}
				catch(IOException e)
				{
					System.out.println("\n- Problems reading file");
					flag = true;
				}

			} while(flag && !quit);

			flag = true;

			while(flag && !quit)
			{
				System.out.print("\nEnter the abbreviation of your home state\n=> ");
				homeState = input.nextLine();

				for(int i = 0; i < array.length; i++)
				{
					if(array[i][0].equalsIgnoreCase(homeState))
					{
						flag = false;
						stateName = array[i][1];
						break;
					}
				}

				if(flag)
					System.out.println("\n- That is not a valid abbreviation");

			}

			flag = true;

			while(flag && !quit)
			{
				try {
					System.out.print("\nEnter your zip code\n=> ");
					zipCode = input.nextInt();

					if(zipCode > 0 && zipCode < 100000)
					{
						flag = false;

						zipCodeString = Integer.toString(zipCode);

						for(int i = 5; zipCodeString.length() < i; i--)
							zeros += "0";

						zipCodeString = zeros + zipCodeString;

					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("\n- Not a valid zip code");
					flag = true;
				}

				if(flag)
					input.next();
			}

			if(!quit)
				System.out.println("\nAge: " + age +
							 	   "\nState: " + stateName +
							 	   "\nZip Code: " + zipCodeString +
								   "\n\nThank you for your valuable contribution to the survey!");
			else
				System.out.println("I understand you do not want to fill out the survey");

		}
		catch(InputMismatchException e)
		{
			System.out.println("\nI understand that you do not want to fill out the survey.");
		}
		finally
		{
			System.out.println("\nThank you for your participation!\n\n");
		}

	}
}