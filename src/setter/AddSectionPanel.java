package setter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AddSectionPanel extends JPanel {
	private JTextField txtTotalTime;
	private JTextField txtSection;
	
	final JButton btnSave = new JButton("Save");

	/**
	 * Create the panel.
	 */
	public AddSectionPanel(SetterTestController obj) {		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblSubsection = new JLabel("Section:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		add(lblSubsection);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblSubsection);
		add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblT, -17, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 20, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblSubsection);
		add(lblM);
		
		JLabel lblNumOfQuestions = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 0, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -263, SpringLayout.EAST, this);
		add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 18, SpringLayout.SOUTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblSubsection);
		add(lblI);
		
		txtTotalTime = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtTotalTime, 74, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		add(txtTotalTime);
		txtTotalTime.setColumns(10);
		
		txtSection = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtSection, -13, SpringLayout.NORTH, txtTotalTime);
		springLayout.putConstraint(SpringLayout.EAST, txtTotalTime, 0, SpringLayout.EAST, txtSection);
		springLayout.putConstraint(SpringLayout.WEST, txtSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, txtSection, -10, SpringLayout.EAST, this);
		add(txtSection);
		txtSection.setColumns(10);
		
		JLabel lblTotalMarks = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalMarks, 0, SpringLayout.NORTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, 118, SpringLayout.EAST, lblM);
		add(lblTotalMarks);
		
		JTextArea txtInstructions = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtInstructions, 10, SpringLayout.SOUTH, lblTotalMarks);
		springLayout.putConstraint(SpringLayout.WEST, txtInstructions, 65, SpringLayout.EAST, lblI);
		springLayout.putConstraint(SpringLayout.EAST, txtInstructions, 0, SpringLayout.EAST, txtTotalTime);
		txtInstructions.setLineWrap(true);
		txtInstructions.setWrapStyleWord(true);
		add(txtInstructions);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, txtInstructions, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, txtTotalTime);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		
		buttonsPanel.add(btnSave);

		
	}
}
