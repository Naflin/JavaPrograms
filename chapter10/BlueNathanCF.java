/**********************************************************\
|    Program: BluNathanCF.java                             |
|     Author: Nathan Blue                                  |
|   Due Date: 11/15/16                                     |
| Assignment: Chapter 10 Program                           |
|    Purpose: Driver program to test out and verify        |
|             that the Bicycle, Car, and Building classes  |
|             work polymorphically                         |
\**********************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class BlueNathanCF
{
	public static void main(String[] args)
	{
		ArrayList<CarbonFootprint> array = new ArrayList<CarbonFootprint>();
		Bicycle bicycle = new Bicycle();
		Car car = new Car();
		Building building = new Building();
		Scanner input = new Scanner(System.in);

		array.add(bicycle);
		array.add(car);
		array.add(building);

		for (CarbonFootprint currentFootprint: array)
		{
			System.out.println(currentFootprint.getClass() + "\n"
							   + currentFootprint + "\n");
		}

		System.out.println("\nChanging data:\n\n");

		System.out.println("Bicycle");
		System.out.print("Set speed (int): ");
		bicycle.setSpeed(input.nextInt());

		System.out.print("Set Gear (int): ");
		bicycle.setGear(input.nextInt());

		System.out.print("Set Brand (String): ");
		input.nextLine();
		bicycle.setBrand(input.nextLine());

		System.out.print("Set Miles (int): ");
		bicycle.setMiles(input.nextInt());

		System.out.println("\nCar");
		System.out.print("Set speed (int): ");
		car.setSpeed(input.nextInt());

		System.out.print("Set gas level (int): ");
		car.setGasLevel(input.nextInt());

		System.out.print("Number of passengers (int): ");
		car.setNumOfPassengers(input.nextInt());

		System.out.print("Miles driven per week (int): ");
		car.setMilesDrivenPerWeek(input.nextInt());

		System.out.print("Fuel efficiency (int): ");
		car.setFuelEfficiency(input.nextInt());

		System.out.println("\nBuilding");
		System.out.print("Set floors (int): ");
		building.setFloors(input.nextInt());

		System.out.print("Set rooms: ");
		building.setRooms(input.nextInt());

		System.out.print("Set fuel bill per month (double): ");
		building.setFuelBillPerMonth(input.nextDouble());

		System.out.print("Set price per gallon (double): ");
		building.setPricePerGallon(input.nextDouble());

		System.out.println("\n\nNew data\n\n");

		for (CarbonFootprint currentFootprint: array)
		{
			System.out.println(currentFootprint.getClass() + "\n"
							   + currentFootprint + "\n");
		}
	}
}