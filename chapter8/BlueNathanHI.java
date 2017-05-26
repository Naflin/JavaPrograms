/**********************************************************\
|    Program: BlueNathanHI.java                            |
|     Author: Nathan Blue                                  |
|   Due Date: 11/1/16                                      |
| Assignment: Chapter 8 Program                            |
|    Purpose: Driver for testing the HugeInteger class     |
|                                                          |
|                                                          |
\**********************************************************/

public class BlueNathanHI
{
	public static void main(String[] args)
	{
		HugeInteger huge = new HugeInteger();
		HugeInteger huge2 = new HugeInteger();

		huge.parse("1920000000000");
		huge2.parse("1080000000000");
		System.out.println("1920000000000 isNotEqualTo 1080000000000: " + huge.isNotEqualTo(huge2));
		System.out.println("1920000000000 isGreaterThan 1080000000000: " + huge.isGreaterThan(huge2));
		System.out.println("1920000000000 isLessThan 1080000000000: " + huge.isLessThan(huge2));
		System.out.println("1920000000000 isGreaterThanOrEqualTo 1080000000000: " + huge.isGreaterThanOrEqualTo(huge2));
		System.out.println("1920000000000 isLessThanOrEqualTo 1080000000000: " + huge.isLessThanOrEqualTo(huge2));
		System.out.println("1920000000000 isZero: " + huge.isZero());

		huge.parse("0");
		System.out.println("0 isZero: " + huge.isZero());

		huge.parse("0000000000");
		System.out.println("0000000000 isZero: " + huge.isZero());

		huge.parse("30050020090");
		huge2.parse("90100020080");
		huge.add(huge2);

		System.out.println("30050020090" + " + " + "90100020080 = " + huge.toString());

		huge.parse("98765432188");
		huge2.parse("8978088888");
		huge.subtract(huge2);
		System.out.println("98765432188" + " - " + "8978088888 = " + huge.toString());

	}
}