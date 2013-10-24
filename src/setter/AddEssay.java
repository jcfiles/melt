package setter;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddEssay extends JPanel {
	private JTextField txtSize;
	private JTextField txtWordLimit;

	/**
	 * Create the panel.
	 */
	public AddEssay(final SetterTestController obj) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblSize = new JLabel("Size of the text box:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSize, 21, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSize, 10, SpringLayout.WEST, this);
		add(lblSize);
		
		txtSize = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtSize, -3, SpringLayout.NORTH, lblSize);
		springLayout.putConstraint(SpringLayout.WEST, txtSize, 34, SpringLayout.EAST, lblSize);
		springLayout.putConstraint(SpringLayout.EAST, txtSize, -33, SpringLayout.EAST, this);
		add(txtSize);
		txtSize.setColumns(10);
		
		JLabel lblWordLimit = new JLabel("Word limit:");
		springLayout.putConstraint(SpringLayout.NORTH, lblWordLimit, 21, SpringLayout.SOUTH, lblSize);
		springLayout.putConstraint(SpringLayout.WEST, lblWordLimit, 0, SpringLayout.WEST, lblSize);
		add(lblWordLimit);
		
		txtWordLimit = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtWordLimit, -3, SpringLayout.NORTH, lblWordLimit);
		springLayout.putConstraint(SpringLayout.WEST, txtWordLimit, 82, SpringLayout.EAST, lblWordLimit);
		springLayout.putConstraint(SpringLayout.EAST, txtWordLimit, -33, SpringLayout.EAST, this);
		add(txtWordLimit);
		txtWordLimit.setColumns(10);
	}
	
	public String getBoxSize()
	{
		return txtSize.getText();
	}
	
	public String getWords()
	{
		return txtWordLimit.getText();
	}
}
