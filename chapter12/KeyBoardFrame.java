/**********************************************************\
|    Program: KeyBoardFrame.java                           |
|     Author: Nathan Blue                                  |
|   Due Date: 12/11/16                                     |
| Assignment: Chapter 12 Program                           |
|    Purpose: The class for the typing assistance          |
|             application that create the frame, gui,      |
|             and handles the logic                        |
\**********************************************************/
 import java.awt.Color;
 import java.awt.event.ActionListener;
 import java.awt.event.KeyListener;
 import java.awt.event.KeyEvent;
 import javax.swing.JFrame;
 import javax.swing.JTextArea;
 import javax.swing.JButton;
 import javax.swing.JLabel;

 public class KeyBoardFrame extends JFrame implements KeyListener
 {
 	private final JLabel label;
 	private final JTextArea textArea;
 	private final JButton buttons[];
 	private final Color mainColor;
 	String text[] = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=",
 					   "Backspace", "Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O",
 					   "P", "[", "]", "\\", "Caps", "A", "S", "D", "F", "G", "H", "J", "K",
 					   "L", ";", "'", "Enter", "Shift", "Z", "X", "C", "V", "B", "N", "M",
 					   ",", ".", "?", "^", "", "<", "v", ">"};

 	int ascii[] = {192,49,50,51,52,53,54,55,56,57,48,45,
 					61,8,9,81,87,69,82,84,89,85,73,79,80,91,93,
 					92,20,65,83,68,70,71,72,74,75,76,59,222,10,
 					16,90,88,67,86,66,78,77,44,46,47,38,32,37,40,39};

 	private int x, y, w, h, offset;

 	public KeyBoardFrame()
 	{
 		super("Typing Application");
 		setLayout(null);

 		label = new JLabel("<html>Type some text using your keyboard. " +
 							  "The keys you press will be highlighted " +
 							  "and the text will be displayed. <br>" +
 							  "Note: Clicking the buttons with your mouse " +
 							  "will not perform any actions<html>");

 		label.setBounds(10,0,750,50);
 		add(label);

 		textArea = new JTextArea();
 		textArea.setBounds(10,50,765,175);
 		textArea.setFocusable(true);
 		textArea.setLineWrap(true);
 		textArea.setWrapStyleWord(true);
 		add(textArea);

 		x = 10;
 		y = 240;
 		w = 46;
 		h = 35;
 		offset = 10;

 		buttons = new JButton[text.length];
 		for (int i = 0; i < text.length; i++)
 		{
 			buttons[i] = new JButton(text[i]);
 			buttons[i].setFocusable(false);

 			switch(text[i])
 			{
 				case "Backspace" : buttons[i].setBounds(x, y, w + 55, h);
 								   break;
 				case "Shift"	 : buttons[i].setBounds(x, y, (w * 2), h);
 								   offset += w * 2 + 10;
 								   break;
 				case "Enter"	 : buttons[i].setBounds(x, y, w + 51, h);
 								   offset += w;
 								   break;
 				case "Tab"		 :
 				case "Caps"		 : buttons[i].setBounds(x, y, (w + w/2 + 5), h);
 								   offset += w + 40;
 								   break;
 				case "?"		 : buttons[i].setBounds(x, y, w, h);
 								   offset += w + 40;
 								   break;
 				case ""  		 : buttons[i].setBounds(x, y, w + 260, h);
 								   offset += w + 550;
 								   break;
 				default		     : buttons[i].setBounds(x, y, w, h);
 								   offset += w + 5;
 						 		   break;
 			}

 			x = offset;

 			if(buttons[i].getText() == "Backspace" ||
 				buttons[i].getText() == "\\" ||
 				buttons[i].getText() == "Enter")
 			{
 				x = 10;
 				y += 40;
 				offset = 5;
 			}

 			if(buttons[i].getText() == "^")
 			{
 				x = (w*4) + 25;
 				y += 40;
 				offset = 5;
 			}

 			add(buttons[i]);
 		}

 		mainColor = buttons[0].getBackground();
 		textArea.addKeyListener(this);
 	}


 	@Override
 	public void keyPressed(KeyEvent e)
 	{
 		for(int i = 0; i < buttons.length; i++)
 			if(ascii[i] == e.getKeyCode())
 				buttons[i].setBackground(Color.PINK);
 	}

 	@Override
 	public void keyReleased(KeyEvent e)
 	{
 		for(int i = 0; i < buttons.length; i++)
 			if(ascii[i] == e.getKeyCode())
 				buttons[i].setBackground(mainColor);
 	}

 	@Override
 	public void keyTyped(KeyEvent e)
 	{

 	}
}