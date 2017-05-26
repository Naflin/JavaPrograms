/*************************************************************\
|    Program: BlueNathanBS.java                               |
|     Author: Nathan Blue                                     |
|   Due Date: 4/11/17                                         |
| Assignment: Chapter 19 Program                              |
|    Purpose: Driver for the bucket sort algorithm            |
|                                                             |
\*************************************************************/
import java.util.Random;

public class BlueNathanBS
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		Bucket bucket = new Bucket();
		int size = 10;
		int[] nums = new int[size];

		for(int i = 0; i < size; i++)
			nums[i] = rand.nextInt(100);

		System.out.println("Unsorted: ");
		for(int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);

		bucket.sort(nums);

		System.out.println("\n\n\nSorted: ");

		for(int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}
}