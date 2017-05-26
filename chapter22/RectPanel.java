/**********************************************************\
|    Program: RectPanel.java                               |
|     Author: Nathan Blue                                  |
|   Due Date: 2/7/17                                       |
| Assignment: Chapter  Program                             |
|    Purpose: The JPanel where the shapes will be drawn    |
|                                                          |
\**********************************************************/
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RectPanel extends JPanel implements MouseListener, MouseMotionListener
{
	private Color color;
	private int red;
	private int green;
	private int blue;
	private int startPosX;
	private int startPosY;
	private int endPosX;
	private int endPosY;
	private int width;
	private int height;
	private int index;
	boolean canDraw;

	public RectPanel()
	{
		canDraw = false;
		startPosX = 0;
		startPosY = 0;
		endPosX = 100;
		endPosY = 100;
		index = 4;
		red = 50;
		green = 50;
		blue = 50;
		color = new Color(red,green,blue);
		addMouseListener(this);
        addMouseMotionListener(this);
	}

	public RectPanel(int r, int g, int b)
	{
		canDraw = false;
		startPosX = 0;
		startPosY = 0;
		endPosX = 0;
		endPosY = 0;
		index = 4;
		if(r >= 0 || r < 256)
			red = r;
		else
			red = 50;
		if(g >= 0 || g < 256)
			green = g;
		else
			green = 50;
		if(b >= 0 || b < 256)
			blue = b;
		else
			blue = 50;

		color = new Color(red,green,blue);
		addMouseListener(this);
        addMouseMotionListener(this);
	}

	public void setRed(int r)
	{
		if(r >= 0 || r < 256)
			red = r;
		color = new Color(red,green,blue);
	}

	public void setGreen(int g)
	{
		if(g >= 0 || g < 256)
			green = g;
		color = new Color(red,green,blue);
	}

	public void setBlue(int b)
	{
		if(b >= 0 || b < 256)
			blue = b;
		color = new Color(red,green,blue);
	}

	public void setIndex(int i)
	{
		index = i;
		canDraw = true;
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
		int[] xPoints = {startPosX, endPosX, width};
		int[] yPoints = {startPosY, endPosY, endPosY};

		switch(index)
		{
			case 0:
					g.setColor(color);
					g.fillOval(startPosX, startPosY,
							   width, height);
					break;
			case 1:
					g.setColor(color);
					g.fillRect(startPosX, startPosY,
						 		width, height);
					break;
			case 2:
					g.setColor(color);
					g.fillPolygon(xPoints, yPoints, 3);
					break;
			default:
					g.setColor(color);
					g.fillRect(0,0,800,600);
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		startPosX = e.getX();
		startPosY = e.getY();
		if(!canDraw && startPosY < 500)
		{
			index = 0;
			canDraw = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		endPosX = e.getX();
		endPosY = e.getY();
		width = endPosX - startPosX;
		height = endPosY - startPosY;
		if(width < 0)
			width = width * (-1);
		if(height < 0)
			height = height * (-1);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e){}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		endPosX = e.getX();
		endPosY = e.getY();
		width = endPosX - startPosX;
		height = endPosY - startPosY;
		if(width < 0)
			width = width * (-1);
		if(height < 0)
		height = height * (-1);

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e){}
}