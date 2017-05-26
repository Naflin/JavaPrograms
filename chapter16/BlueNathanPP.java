/*************************************************************\
|    Program: BluNathanPP.java                                |
|     Author: Nathan Blue                                     |
|   Due Date: 3/7/17                                          |
| Assignment: Chapter 16 Program                              |
|    Purpose: Check whether an integer is prime or not.       |
|             If it is prime, tell the user, else, show       |
|             the components that make up the integer.        |
\*************************************************************/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;

public class BlueNathanPP
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		Set<Integer> set;

		int num = 0;
		int temp = 0;
		boolean canDivide = true;

		System.out.println("======= Prime Number Checker =======");

		do{
			System.out.print("Enter an integer or enter -1 to quit: ");

			num = temp = input.nextInt();

			if(num > 1)
			{

				for(int i = 2; i < num; i++)
				{
					do
					{
						if(temp % i == 0)
						{
							temp /= i;
							list.add(i);
						}
						else
							canDivide = false;
					} while(canDivide);
					canDivide = true;
				}
				set = new TreeSet<>(list);

				if(set.size() == 0)
					System.out.println("\n" + num + " is a prime number.");
				else
				{
					System.out.println("\n" + num + " is a composite number that is made up of the following:");
					for(Integer value : set)
						System.out.print(" " + value);
				}

				list.clear();
			}
			else if(num == 1 || num == 0)
			{
				System.out.println("\n" + num + " is neither a prime number nor a composite number.");
			}
			else
			{
				System.out.println("\nGoodbye!");
			}

			System.out.println("\n\n\n");
		} while(num > -1);

	}
}