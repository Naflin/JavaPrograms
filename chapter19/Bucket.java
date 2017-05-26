/*************************************************************\
|    Program: Bucket.java                                     |
|     Author: Nathan Blue                                     |
|   Due Date: 4/11/17                                         |
| Assignment: Chapter 19 Program                              |
|    Purpose: Bucket class with the bucket sort algorithm     |
|                                                             |
\*************************************************************/
import java.lang.Math;

public class Bucket
{
	public static void sort(int[] nums)
	{
		int[][] buckets = new int[10][nums.length];
		int digit = 0;
		int exp = 0;
		int highest = 0;
		int max = 0;
		int index = 0;

		for(int i = 0; i < nums.length; i++)
			if(nums[i] > highest)
				highest = nums[i];

		while(highest > 0)
		{
			highest = highest / 10;
			max++;
		}

		while(exp <= max)
		{
			for(int i = 0; i < nums.length; i++)
			{
				for(int x = 0; x < exp; x++)
					digit = (nums[i]/((int)Math.pow(10,x))) % 10;

				for(int j = 0; j < buckets[digit].length; j++)
					if(buckets[digit][j] == 0)
					{
						buckets[digit][j] = nums[i];
						break;
					}
			}

			for(int i = 0; i < buckets.length; i++)
				for(int j = 0; j < buckets[i].length; j++)
					if(buckets[i][j] != 0)
					{
						nums[index++] = buckets[i][j];
						buckets[i][j] = 0;
					}
			index = 0;
			exp++;
		}
	}
}