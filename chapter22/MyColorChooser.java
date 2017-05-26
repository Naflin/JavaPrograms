/**********************************************************\
|    Program: MyColorChooser.java                          |
|     Author: Nathan Blue                                  |
|   Due Date: 5/7/17                                       |
| Assignment: Chapter 22 Program                           |
|    Purpose: Build a color chooser with the capability    |
|             of drawing different shapes                  |
\**********************************************************/
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MyColorChooser extends JPanel
{
	private static final int FPS_MIN = 0;
	private static final int FPS_MAX = 255;
	private static final int FPS_INIT = 125;
	private int index;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;
	private JTextField redText;
	private JTextField greenText;
	private JTextField blueText;
	private Color color;
	private JPanel choosePanel;
	private RectPanel rectPanel;
	private final JComboBox<String> comboBox;
	private static final String[] shapeNames =
		{"circle", "rectangle", "triangle"};

	public MyColorChooser()
	{
		choosePanel = new JPanel();
		rectPanel = new RectPanel();

		setLayout(new BorderLayout());
		choosePanel.setLayout(new GridLayout(2,3));

		redSlider = new JSlider(SwingConstants.HORIZONTAL,
								FPS_MIN, FPS_MAX,
								FPS_INIT);

		redSlider.setMajorTickSpacing(50);
		redSlider.setMinorTickSpacing(10);
		redSlider.setPaintTicks(true);
		redSlider.setPaintLabels(true);
		redSlider.setVisible(true);
		choosePanel.add(redSlider);

		redText = new JTextField("" + redSlider.getValue());
		redText.setHorizontalAlignment(JTextField.CENTER);

		redSlider.addChangeListener(
			new ChangeListener()
			{
				@Override
				public void stateChanged(ChangeEvent e)
				{
					redText.setText("" + redSlider.getValue());
					rectPanel.setRed(redSlider.getValue());
					repaint();
				}
			}
		);

		redText.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent key)
			{
				String input = redText.getText();
				redSlider.setValue(0);
				if(!input.matches("\\d+") ||
					Integer.parseInt(redText.getText()) < 0 ||
					Integer.parseInt(redText.getText()) > 255 )
				{
					return;
				}
				int value = Integer.parseInt(input);
				redSlider.setValue(value);
			}
        });


		greenSlider = new JSlider(SwingConstants.HORIZONTAL,
										FPS_MIN, FPS_MAX,
										FPS_INIT);

		greenSlider.setMajorTickSpacing(50);
		greenSlider.setMinorTickSpacing(10);
		greenSlider.setPaintTicks(true);
		greenSlider.setPaintLabels(true);
		greenSlider.setVisible(true);
		choosePanel.add(greenSlider);

		greenText = new JTextField("" + greenSlider.getValue());
		greenText.setHorizontalAlignment(JTextField.CENTER);

		greenSlider.addChangeListener(
			new ChangeListener()
			{
				@Override
				public void stateChanged(ChangeEvent e)
				{
					greenText.setText("" + greenSlider.getValue());
					rectPanel.setGreen(greenSlider.getValue());
					repaint();
				}
			}
		);

		greenText.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent key)
			{
				String input = greenText.getText();
				greenSlider.setValue(0);
				if(!input.matches("\\d+") ||
					Integer.parseInt(greenText.getText()) < 0 ||
					Integer.parseInt(greenText.getText()) > 255 )
				{
					return;
				}
				int value = Integer.parseInt(input);
				greenSlider.setValue(value);
			}
        });

		blueSlider = new JSlider(SwingConstants.HORIZONTAL,
										FPS_MIN, FPS_MAX,
										FPS_INIT);

		blueSlider.setMajorTickSpacing(50);
		blueSlider.setMinorTickSpacing(10);
		blueSlider.setPaintTicks(true);
		blueSlider.setPaintLabels(true);
		blueSlider.setVisible(true);
		choosePanel.add(blueSlider);

		blueText = new JTextField("" + blueSlider.getValue());
		blueText.setHorizontalAlignment(JTextField.CENTER);

		blueSlider.addChangeListener(
			new ChangeListener()
			{
				@Override
				public void stateChanged(ChangeEvent e)
				{
					blueText.setText("" + blueSlider.getValue());
					color = new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
					rectPanel.setBlue(blueSlider.getValue());
					repaint();
				}
			}
		);

		blueText.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent key) {
				String input = blueText.getText();
				blueSlider.setValue(0);
				if(!input.matches("\\d+") ||
					Integer.parseInt(blueText.getText()) < 0 ||
					Integer.parseInt(blueText.getText()) > 255 )
				{
					return;
				}
				int value = Integer.parseInt(input);
				blueSlider.setValue(value);
			}
        });

		choosePanel.add(redText);
		choosePanel.add(greenText);
		choosePanel.add(blueText);

		color = new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());

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
						rectPanel.setIndex(index);
					}
				}
			}
		);

		add(rectPanel, BorderLayout.CENTER);
		add(choosePanel, BorderLayout.SOUTH);
		add(comboBox, BorderLayout.NORTH);
	}
}