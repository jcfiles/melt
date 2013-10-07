package setter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

public class FillBlankPanel extends JPanel {
	private JTextField txtQuestion;

	/**
	 * Create the panel.
	 */
	public FillBlankPanel() {

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		//load the marks of the question
		JLabel lblMarks = new JLabel("Marks: 10");
		springLayout.putConstraint(SpringLayout.NORTH, lblMarks, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblMarks, -10, SpringLayout.EAST, this);
		add(lblMarks);
		
		JLabel lblSub = new JLabel("Subsection:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSub, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSub, 10, SpringLayout.WEST, this);
		add(lblSub);
		
		//load the subsection
		JLabel lblSubsection = new JLabel("SubsectionA");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 0, SpringLayout.NORTH, lblSub);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 30, SpringLayout.EAST, lblSub);
		add(lblSubsection);
		
		JLabel lblQ = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 18, SpringLayout.SOUTH, lblSubsection);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		//load the question
		JLabel lblPartA = new JLabel("He is a math teacher. He is 19");
		springLayout.putConstraint(SpringLayout.WEST, lblPartA, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPartA, 0, SpringLayout.SOUTH, lblQ);
		add(lblPartA);
		
		txtQuestion = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtQuestion, 6, SpringLayout.EAST, lblPartA);
		springLayout.putConstraint(SpringLayout.SOUTH, txtQuestion, 0, SpringLayout.SOUTH, lblQ);
		add(txtQuestion);
		txtQuestion.setColumns(10);
		
		JLabel lblPartB = new JLabel("old.");
		springLayout.putConstraint(SpringLayout.WEST, lblPartB, 6, SpringLayout.EAST, txtQuestion);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPartB, 0, SpringLayout.SOUTH, lblQ);
		add(lblPartB);
	}

}
