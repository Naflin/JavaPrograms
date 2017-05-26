/**********************************************************\
|    Program: Building.java                                |
|     Author: Nathan Blue                                  |
|   Due Date: 11/15/16                                     |
| Assignment: Chapter 10 Program                           |
|    Purpose: Building class implementing the              |
|             CarbonFootprint interface                    |
\**********************************************************/

public class Building implements CarbonFootprint
{
	private final double emissionsFactor = 22.37;

	private int floors;
	private int rooms;
	private double fuelBillPerMonth;
	private double pricePerGallon;

	public Building()
	{
		this.floors = 1;
		this.rooms = 1;
		this.fuelBillPerMonth = 400;
		this.pricePerGallon = 2.23;
	}

	public void setFloors(int floors)
	{
		if(floors < 1)
			throw new IllegalArgumentException("Quantity must be >= 1");

		this.floors = floors;
	}

	public void setRooms(int rooms)
	{
		if(rooms < 1)
			throw new IllegalArgumentException("Quantity must be >= 1");

		this.rooms = rooms;
	}

	public void setFuelBillPerMonth(double fuelBillPerMonth)
	{
		if(fuelBillPerMonth < 0.01)
			throw new IllegalArgumentException("Quantity must be >= 1");

		this.fuelBillPerMonth = fuelBillPerMonth;
	}

	public void setPricePerGallon(double pricePerGallon)
	{
		if(pricePerGallon < 0.01)
			throw new IllegalArgumentException("Quantity must be >= 0.01");

		this.pricePerGallon = pricePerGallon;
	}

	public int getFloors()
	{
		return floors;
	}

	public int getRooms()
	{
		return rooms;
	}

	public double getFuelBillPerMonth()
	{
		return fuelBillPerMonth;
	}

	public double getPricePerGallon()
	{
		return pricePerGallon;
	}


	@Override
	public double getCarbonFootprint()
	{
		return (fuelBillPerMonth / pricePerGallon) * emissionsFactor * 12;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %d%n%s: %d%n%s: %.2f",
 							 "Floors", floors, "Rooms", rooms,
							 "Carbon Footprint", this.getCarbonFootprint());
	}
}