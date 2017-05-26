/**********************************************************\
|    Program: ShapePanel.java                              |
|     Author: Nathan Blue                                  |
|   Due Date: 2/7/17                                       |
| Assignment: Chapter 13 Program                           |
|    Purpose: The JPanel where the shapes will be drawn    |
|                                                          |
\**********************************************************/
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

public class ShapePanel extends JPanel
{
	private int index;
	private Color[] color = {Color.BLACK, Color.BLUE, Color.CYAN,
							 Color.DARK_GRAY, Color.GRAY, Color.GREEN,
							 Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
							 Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

	public ShapePanel()
	{
		index = 0;
	}

	public ShapePanel(int i)
	{
		index = i;
	}

	public void setIndex(int i)
	{
		index = i;
	}

	public int getIndex()
	{
		return index;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		SecureRandom random = new SecureRandom();
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];

		switch(index)
		{
			case 0:
				for(int i = 0; i < 20; i++)
				{
					g.setColor(color[random.nextInt(13)]);
					g.fillOval(random.nextInt(600), random.nextInt(450),
							 random.nextInt(300), random.nextInt(300));
				}
				break;
			case 1:
				for(int i = 0; i < 20; i++)
				{
					g.setColor(color[random.nextInt(13)]);
					g.fillRect(random.nextInt(700), random.nextInt(500),
						 random.nextInt(250), random.nextInt(250));
				}
				break;
			case 2:
				for(int i = 0; i < 20; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						xPoints[j] = random.nextInt(750);
						yPoints[j] = random.nextInt(550);
					}
					g.setColor(color[random.nextInt(13)]);
					g.fillPolygon(xPoints, yPoints, 3);
				}
				break;
		}

	}
}