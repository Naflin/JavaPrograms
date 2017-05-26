/*************************************************************\
|    Program: BlueNathanIP.java                               |
|     Author: Nathan Blue                                     |
|   Due Date: 4/25/17                                         |
| Assignment: Chapter 20/21 Program                           |
|    Purpose: Driver for testing the InfixToPostfixConverter  |
|             Algorithm.                                      |
\*************************************************************/

import java.lang.StringBuffer;
import java.util.Scanner;

public class BlueNathanIP
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		StringBuffer buff = new StringBuffer();
		StringBuffer buff2 = new StringBuffer();
		InfixToPostfixConverter converter = new InfixToPostfixConverter();
		String choice;

		System.out.println("Infix to postfix converter\n\n"
						   + "Please enter an expression using integers and\n"
						   + "the following arithmetic operations - + * / ^ %");


		System.out.println("\n\nExamples:\n (5+4)/3 \tbecomes 54+3/" +
						   "\n 9+(3*(2+1)) \tbecomes 9321+*+" +
						   "\n 4+8/7-6 \tbecomes 487/+6-");

		do {
			System.out.print("\n\nEneter Your Expression: ");
			choice = input.nextLine();
			buff.setLength(0);
			buff.append(choice);

			if(converter.isValidExpression(buff))
			{
				buff2 = converter.convertToPostfix(buff);
				System.out.println("\n\nConverted to a postfix expression: " + buff2);
				buff2.setLength(0);
			}
			else
				System.out.println("\n\nNot a valid expresssion");

			System.out.print("\nTry again? (Y/n): ");
			choice = input.nextLine();

		} while(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
	}
}