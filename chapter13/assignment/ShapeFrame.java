/**********************************************************\
|    Program: ShapeFrame.java                              |
|     Author: Nathan Blue                                  |
|   Due Date: 2/7/17                                       |
| Assignment: Chapter 13 Program                           |
|    Purpose: JFrame holding the combobox and the          |
|             shape panel                                  |
|                                                          |
\**********************************************************/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ShapeFrame extends JFrame
{
	private final JComboBox<String> comboBox;
	private int index;
	private ShapePanel shapePanel;
	private JPanel northPanel;
	private JButton button;

	private static final String[] shapeNames =
		{"circle", "rectangle", "triangle"};

	public ShapeFrame()
	{
		super("Shape Generator");
		setLayout(new BorderLayout());
		index = 0;

		northPanel = new JPanel(new BorderLayout());

		shapePanel = new ShapePanel(index);
		add(shapePanel, BorderLayout.CENTER);

		button = new JButton("Generate");

		comboBox = new JComboBox<String>(shapeNames);
		comboBox.setMaximumRowCount(3);
		comboBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent event)
				{
					if (event.getStateChange() == ItemEvent.SELECTED)
					{
						index = comboBox.getSelectedIndex();
						shapePanel.setIndex(index);
					}
				}
			}
		);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});

		add(northPanel, BorderLayout.NORTH);
		northPanel.add(comboBox, BorderLayout.CENTER);
		northPanel.add(button, BorderLayout.EAST);
	}
}