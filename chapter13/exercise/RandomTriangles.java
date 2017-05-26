//13.9 Exercise
//Nathan Blue
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.GeneralPath;
import java.security.SecureRandom;

public class RandomTriangles extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		SecureRandom random = new SecureRandom();

		int[] xPoints = {0, -40, 40};
		int[] yPoints = {0, 20, 20};
		int x = 100;
		int y = 0;

		Graphics2D g2d = (Graphics2D) g;
		GeneralPath star = new GeneralPath();

		star.moveTo(xPoints[0], yPoints[0]);

		for (int count = 1; count < xPoints.length; count++)
		{
			star.lineTo(xPoints[count], yPoints[count]);
		}
		star.closePath();

		g2d.translate(75,50);

		for (int count = 1; count <= 30; count++)
		{
			g2d.setColor(new Color(random.nextInt(256),
			random.nextInt(256), random.nextInt(256)));
			g2d.fill(star);


			if(y != 0)
				y = 0;


			if(count % 5 == 0)
			{
				y = 50;
				x = -400;
			}

			if(count % 5 == 1 && count > 5)
			{
				if(x > 0)
					x = -100;
				else
					x = 100;
			}

			g2d.translate(x, y);
		}

	}
}