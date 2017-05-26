/**********************************************************\
|    Program: BlueNathanPT.java                            |
|     Author: Nathan Blue                                  |
|   Due Date: 9/27/16                                      |
| Assignment: Chapter 4 Program                            |
|    Purpose: Write a program to bruteforce all the        |
|             possible combinations for a                  |
|             pythagorean triple.                          |
\**********************************************************/
import java.util.Scanner;

public class BlueNathanPT
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int combinations = 0;

		for(int side1 = 1; side1 <= 500; side1++)
		{
			for(int side2 = 1; side2 <= 500; side2++)
			{
				for(int hypotenuse = 1; hypotenuse <= 500; hypotenuse++)
				{
					if((hypotenuse * hypotenuse) == ((side1 * side1) + (side2 * side2)))
					{
						System.out.printf("Hypotenuse: %5d | Side One: %5d | Side Two: %5d%n", hypotenuse, side1, side2);

						combinations++;

						if(combinations % 50 == 0)
						{
							System.out.print("\nEnter a number to get the next 50 combinations: ");
							input.next();
							System.out.println();
						}
					}
				}
			}

		}

		System.out.println("\n\nFinished!\n\n");
	}
}