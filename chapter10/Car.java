/**********************************************************\
|    Program: Car.java                                     |
|     Author: Nathan Blue                                  |
|   Due Date: 11/15/16                                     |
| Assignment: Chapter 10 Program                           |
|    Purpose: Car class implementing the                   |
|             CarbonFootprint interface                    |
\**********************************************************/

public class Car implements CarbonFootprint
{
	private final double co2EmittedPerGallon = 19.4;
	private final double greenHouseGasesPerGallon = 1.052632;
	private int speed;
	private int gasLevel;
	private int numOfPassengers;
	private int milesDrivenPerWeek;
	private int fuelEfficiency;

	public Car()
	{
		this.speed = 0;
		this.gasLevel = 100;
		this.numOfPassengers = 1;
		this.milesDrivenPerWeek = 200;
		this.fuelEfficiency = 22;
	}

	public void setSpeed(int speed)
	{
		if(speed < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		this.speed = speed;
	}

	public void setGasLevel(int gasLevel)
	{
		if(gasLevel < 0 || gasLevel > 100)
			throw new IllegalArgumentException("Quantity must be >= 0 and <= 100");

		this.gasLevel = gasLevel;
	}

	public void setNumOfPassengers(int numOfPassengers)
	{
		if(numOfPassengers < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		this.numOfPassengers = numOfPassengers;
	}

	public void setMilesDrivenPerWeek(int milesDrivenPerWeek)
	{
		if(numOfPassengers < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		this.milesDrivenPerWeek = milesDrivenPerWeek;
	}

	public void setFuelEfficiency(int fuelEfficiency)
	{
		if(fuelEfficiency < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		this.fuelEfficiency = fuelEfficiency;
	}

	public int getSpeed()
	{
		return speed;
	}

	public int getGasLevel()
	{
		return gasLevel;
	}

	public int getNumOfPassengers()
	{
		return numOfPassengers;
	}

	@Override
	public double getCarbonFootprint()
	{
		return ((milesDrivenPerWeek * 52) / fuelEfficiency) * co2EmittedPerGallon * greenHouseGasesPerGallon;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %d%n%s: %d%n%s: %d%n%s: %.2f",
							 "Speed", speed, "Gas Level", gasLevel,
							 "Number of passengers", numOfPassengers,
							 "Carbon Footprint", this.getCarbonFootprint());
	}
}