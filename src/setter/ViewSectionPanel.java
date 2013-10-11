package setter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ViewSectionPanel extends JPanel {
	
	
	final JButton btnDelete = new JButton("Delete");
	final JButton btnEdit = new JButton("Edit");
	final JButton btnAddQuestion= new JButton("Add Question");
	final JButton btnAdd = new JButton("Add New Section");
	
	
	/**
	 * Create the panel.
	 */
	public ViewSectionPanel(SetterTestController obj) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		if(obj.getCurrentSection()==0){
		ArrayList<String> list = new ArrayList<String>();
		//list=obj.getSection(obj.getCurrentSection());
		
		JLabel lblS = new JLabel("Section:");
		springLayout.putConstraint(SpringLayout.NORTH, lblS, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblS, 10, SpringLayout.WEST, this);
		add(lblS);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblS);
		add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblT, -17, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 20, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblS);
		add(lblM);
		
		JLabel lblNumOfQuestions = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 0, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -263, SpringLayout.EAST, this);
		add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 18, SpringLayout.SOUTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblS);
		add(lblI);
		
		JLabel lblTotalMarks = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalMarks, 0, SpringLayout.NORTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, 118, SpringLayout.EAST, lblM);
		add(lblTotalMarks);
		
		JLabel lblInstructions = new JLabel(list.get(1));
		springLayout.putConstraint(SpringLayout.NORTH, lblInstructions, 10, SpringLayout.SOUTH, lblTotalMarks);
		springLayout.putConstraint(SpringLayout.WEST, lblInstructions, 65, SpringLayout.EAST, lblI);
		springLayout.putConstraint(SpringLayout.SOUTH, lblInstructions, -338, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblInstructions, -10, SpringLayout.EAST, this);
		//lblInstructions.setWrapStyleWord(true);
		add(lblInstructions);
		
		JLabel lblSection = new JLabel(list.get(0));
		springLayout.putConstraint(SpringLayout.WEST, lblSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSection, 0, SpringLayout.SOUTH, lblS);
		add(lblSection);
		
		JLabel lblTotalTime = new JLabel(list.get(0)+"mins");
		springLayout.putConstraint(SpringLayout.WEST, lblTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTotalTime, 0, SpringLayout.SOUTH, lblT);
		add(lblTotalTime);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, lblInstructions);
		springLayout.putConstraint(SpringLayout.SOUTH, lblInstructions, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		buttonsPanel.add(btnAdd);
		buttonsPanel.add(btnDelete);
		buttonsPanel.add(btnEdit);
		buttonsPanel.add(btnAddQuestion);
				
		}
	}

}
