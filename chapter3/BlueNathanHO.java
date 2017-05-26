/**********************************************************\
|    Program: BlueNathanHO.java                            |
|     Author: Nathan Blue                                  |
|   Due Date: 9/20/16                                      |
| Assignment: Chapter 3 Program                            |
|    Purpose: Calculate the occupancy rate of a hotel      |
|             given the number of floors, rooms, and       |
|             occupied rooms                               |
\**********************************************************/

import java.util.Scanner;

public class BlueNathanHO
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int rooms = 0;
		int occupiedRooms = 0;
		int count = 0;
		int totalFloors = 0;
		int totalRooms = 0;
		int totalOccupiedRooms = 0;
		float percentOccupied = 0;


		while(totalFloors < 1)
		{
			System.out.print("\nPlease enter the number of floors in the hotel: ");
			totalFloors = input.nextInt();

			if(totalFloors < 1)
				System.out.println("\n\t\t-----Invalid Input-----\n" +
								   "\tYou must have at least one floor.");
		}

		while(count != totalFloors)
		{
			while(rooms < 10)
			{
				System.out.print("\nEnter the number of rooms on floor " + (count + 1) + ": ");
				rooms = input.nextInt();

				if(rooms < 10)
					System.out.println("\n\t\t-----Invalid Input-----\n" +
									   "\tThe number of rooms must be at least 10.\n");
		 	}

			occupiedRooms = rooms + 1;

			while(occupiedRooms > rooms || occupiedRooms < 0)
			{
				System.out.print("\nEnter the number of occupied rooms on this floor: ");
				occupiedRooms = input.nextInt();

				if(occupiedRooms > rooms || occupiedRooms < 0)
					System.out.println("\n\t\t\t-----Invalid Input-----\n" +
									   "\tThe number of occupied rooms must be a positive number\n" +
								 	   "\t\tless than or equal to the total number of rooms.\n");
			}

			count++;
			totalRooms += rooms;
			totalOccupiedRooms += occupiedRooms;

			rooms = 0;
		}

		percentOccupied = (float) totalOccupiedRooms / totalRooms;
		percentOccupied *= 100;

		System.out.println("\nTotal rooms = " + totalRooms +
						 "\nTotal occupied rooms = " + totalOccupiedRooms +
						 "\nTotal unoccupied rooms = " + (totalRooms - totalOccupiedRooms) +
						 "\nPercentage of rooms occupied = " +  percentOccupied + "%\n\n");

	}
}