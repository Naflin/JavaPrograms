/*************************************************************\
|    Program: FractalJPanel.java                              |
|     Author: Nathan Blue                                     |
|   Due Date: 3/28/17                                         |
| Assignment: Chapter 18 Program                              |
|    Purpose: Modified code from the book to draw the         |
|             5 fractal lines to create a fractal star.       |
|                                                             |
\*************************************************************/
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.lang.Math;

public class FractalJPanel extends JPanel
{
	private Color color;
	private int level;

	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	public FractalJPanel(int currentLevel)
	{
		color = Color.BLUE;
		level = currentLevel;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g)
	{
		if(level == 0)
			g.drawLine(xA, yA, xB, yB);
		else
		{
			int xC = (xA + xB) / 2;
			int yC = (yA + yB) / 2;

			int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
			int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

			drawFractal(level - 1, xD, yD, xA, yA, g);
			drawFractal(level - 1, xD, yD, xC, yC, g);
			drawFractal(level - 1, xD, yD, xB, yB, g);
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int x = Math.round(WIDTH / 2);
    	int y = Math.round(HEIGHT / 2);
		int xPos;
        int yPos;
        float radius = 100;
        int angle = -54;

        g.setColor(color);

        for(int i = 0; i < 5; i++)
        {

			xPos = Math.round((float) (x + Math.cos(Math.toRadians(angle)) * radius));
			yPos = Math.round((float) (y + Math.sin(Math.toRadians(angle)) * radius));
			drawFractal(level, xPos, yPos, WIDTH/2, HEIGHT/2, g);
			angle += 72;
		}
	}

	public void setColor(Color c)
	{
		color = c;
	}

	public void setLevel(int currentLevel)
	{
		level = currentLevel;
	}

	public int getLevel()
	{
		return level;
	}
}