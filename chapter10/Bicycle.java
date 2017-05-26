/**********************************************************\
|    Program: Bicycle.java                                 |
|     Author: Nathan Blue                                  |
|   Due Date: 11/15/16                                     |
| Assignment: Chapter 10 Program                           |
|    Purpose: Bicycle class implementing the               |
|             CarbonFootprint interface                    |
\**********************************************************/

public class Bicycle implements CarbonFootprint
{
	private int speed;
	private int gear;
	private String brand;
	private double miles;

	public Bicycle()
	{
		this.speed = 0;
		this.gear = 1;
		this.brand = "Giant";
		this.miles = .5;
	}

	public void setSpeed(int speed)
	{
		if(speed < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		this.speed = speed;
	}

	public void setGear(int gear)
	{
		if(gear < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		this.gear = gear;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public void setMiles(double miles)
	{
		if(miles < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		this.miles = miles;
	}

	public int getSpeed()
	{
		return speed;
	}

	public int getGear()
	{
		return gear;
	}

	public String getBrand()
	{
		return brand;
	}

	public double getMiles()
	{
		return miles;
	}


	@Override
	public double getCarbonFootprint()
	{
		return 0.046 * miles;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %d%n%s: %d%n%s: %s%n%s: %.2f%n%s: %.2f",
							 "Speed", speed, "Gear", gear,
							 "Brand", brand, "Miles", miles,
							 "Carbon Footprint", this.getCarbonFootprint());
	}
}