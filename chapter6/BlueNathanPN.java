/**********************************************************\
|    Program: BlueNathanPN.java                            |
|     Author: Nathan Blue                                  |
|   Due Date: 10/11/16                                     |
| Assignment: Chapter 6 Program                            |
|    Purpose: Determine all the prime numbers between      |
|             2 and 1000 using the Sieve of Eratosthenes   |
|             method.                                      |
\**********************************************************/

public class BlueNathanPN
{
	public static void main(String[] args)
	{
		boolean[] array = new boolean[1000];

		initToTrue(array);

		for(int x = 2; x < array.length; x++)
			if(array[x] == true)
				for(int y = x + 1; y < array.length; y++)
					if(y % x == 0)
						array[y] = false;

		System.out.println("Prime Numbers:");

		for(int i = 2; i < array.length; i++)
			if(array[i] == true)
				System.out.printf("%5d\t", i);

		System.out.println();
	}

	public static boolean[] initToTrue(boolean[] array)
	{
		for (int i = 0; i < array.length; i++)
			array[i] = true;

		return array;
	}
}