package setter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

public class FillBlankPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FillBlankPanel() {

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblPoints = new JLabel("Marks: 10");
		springLayout.putConstraint(SpringLayout.NORTH, lblPoints, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblPoints, -10, SpringLayout.EAST, this);
		add(lblPoints);
		
		JLabel lblSub = new JLabel("Subsection:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSub, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSub, 10, SpringLayout.WEST, this);
		add(lblSub);
		
		JLabel lblSubsection = new JLabel("SubsectionA");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 0, SpringLayout.NORTH, lblSub);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 30, SpringLayout.EAST, lblSub);
		add(lblSubsection);
		
		JLabel lblQ = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 18, SpringLayout.SOUTH, lblSubsection);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		JLabel lblPartA = new JLabel("He is a math teacher. He is 19");
		springLayout.putConstraint(SpringLayout.WEST, lblPartA, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPartA, 0, SpringLayout.SOUTH, lblQ);
		add(lblPartA);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblPartA);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblQ);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPartB = new JLabel("old.");
		springLayout.putConstraint(SpringLayout.WEST, lblPartB, 6, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPartB, 0, SpringLayout.SOUTH, lblQ);
		add(lblPartB);
	}

}
