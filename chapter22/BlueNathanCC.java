/**********************************************************\
|    Program: BlueNathanCC.java                            |
|     Author: Nathan Blue                                  |
|   Due Date: 5/7/17                                       |
| Assignment: Chapter 22 Program                           |
|    Purpose: Build a color chooser with the capability    |
|             of drawing different shapes                  |
\**********************************************************/
import javax.swing.JFrame;

public class BlueNathanCC
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("My Color Chooser");
		MyColorChooser chooser = new MyColorChooser();
		frame.add(chooser);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}