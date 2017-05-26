//13.9 Exercise
//Nathan Blue
import java.awt.Color;
import javax.swing.JFrame;

public class Exercise13_9
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Drawing Triangles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RandomTriangles triangles = new RandomTriangles();
		frame.add(triangles);
		frame.setBackground(Color.WHITE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}