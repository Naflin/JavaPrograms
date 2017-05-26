/**********************************************************\
|    Program: BluNathanTA.java                             |
|     Author: Nathan Blue                                  |
|   Due Date: 2/14/17                                      |
| Assignment: Chapter 14 Program                           |
|    Purpose: Reads a line of text and prints out a table  |
|             listing the word lengths and occurences      |
|                                                          |
\**********************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class BlueNathanTA
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sentence = "";
		String[] words;
		int maxWordLength = 0;
		int counter = 0;

		System.out.println("Enter a line of text to analyze: ");
		sentence = input.nextLine();

		words = sentence.split(" ");
		System.out.printf("%n%nNumber of words: %d%n", words.length);

		for(String word : words)
		{
			if(word.length() > maxWordLength)
				maxWordLength = word.length();

			list.add(word.length());
		}

		System.out.println("\n\n Word Length\t\tOccurences");

		for(int i = 1; i <= maxWordLength; i++)
		{
			for(int j = 0; j < words.length; j++)
				if(list.get(j) == i)
					counter++;

			System.out.println(" " + i + "\t\t\t " + counter);
			counter = 0;
		}

		System.out.print("\n\n\n");
	}
}