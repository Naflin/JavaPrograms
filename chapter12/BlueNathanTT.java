/**********************************************************\
|    Program: BluNathanTT.java                             |
|     Author: Nathan Blue                                  |
|   Due Date: 12/11/16                                     |
| Assignment: Chapter 12 Program                           |
|    Purpose: The program that allows the user to see      |
|             which keys they press by showing the layout  |
|             of the buttons in a gui                      |
\**********************************************************/
import javax.swing.JFrame;

public class BlueNathanTT
{
	public static void main(String[] args)
	{
		KeyBoardFrame frame = new KeyBoardFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 480);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}