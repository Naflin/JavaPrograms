/**********************************************************\
|    Program: BlueNathanCAI.java                           |
|     Author: Nathan Blue                                  |
|   Due Date: 10/4/16                                      |
| Assignment: Chapter 3 Program                            |
|    Purpose: Create a Computer-Assisted Instruction       |
|             program that gives a student some simple     |
|             multiplication problems to solve.            |
\**********************************************************/

import java.util.Scanner;
import java.security.SecureRandom;

public class BlueNathanCAI
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int num1 = generateInt(9);
		int num2 = generateInt(9);
		int guess = 0;

		do {
			displayQuestion(num1, num2);

			guess = input.nextInt();

			if(guess == (num1 * num2))
			{
				num1 = generateInt(9);
				num2 = generateInt(9);
				displayResponse(true);
			}
			else
				displayResponse(false);

		} while(guess >= 0);

	}

	public static int generateInt(int range)
	{
		SecureRandom randomNumber = new SecureRandom();
		return randomNumber.nextInt(range) + 1;
	}

	public static void displayQuestion(int n1, int n2)
	{
		System.out.println("How much is " + n1 + " times " + n2 + "?");
	}

	public static void displayResponse(Boolean isCorrect)
	{
		int rand = generateInt(4);

		if(isCorrect)
		{
			switch(rand)
			{
				case 1 : System.out.println("\nVery good!\n");
						 break;
				case 2 : System.out.println("\nExcellent!\n");
						 break;
				case 3 : System.out.println("\nNice work!\n");
						 break;
				case 4 : System.out.println("\nKeep up the good work!\n");
						 break;
			}
		}
		else
		{
			switch(rand)
			{
				case 1 : System.out.println("\nNo. Please try again.\n");
						 break;
				case 2 : System.out.println("\nWrong. Try once more.\n");
						 break;
				case 3 : System.out.println("\nDon't give up!\n");
						 break;
				case 4 : System.out.println("\nNo. Keep trying.\n");
						 break;
			}
		}
	}
}