/**********************************************************\
|    Program: BluNathanSH.java                             |
|     Author: Nathan Blue                                  |
|   Due Date: 2/7/17                                       |
| Assignment: Chapter 13 Program                           |
|    Purpose: Generate 20 different color shapes           |
|             according to what the user has chosen        |
|             from the combo box                           |
\**********************************************************/
import javax.swing.JFrame;

public class BlueNathanSH
{
	public static void main(String[] args)
	{
		ShapeFrame frame = new ShapeFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}