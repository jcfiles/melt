package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.MatteBorder;

public class MultichoicePanel extends JPanel {

	final JButton btnDelete = new JButton("Delete");
	final JButton btnEdit = new JButton("Edit");
	final JButton btnAdd = new JButton("Add New Question");
	
	/**
	 * Create the panel.
	 */
	public MultichoicePanel() {
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
		
		//load the subsection of the question
		JLabel lblSubsection = new JLabel("SubsectionA");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 0, SpringLayout.NORTH, lblSub);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 30, SpringLayout.EAST, lblSub);
		add(lblSubsection);
		
		JLabel lblQ = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 18, SpringLayout.SOUTH, lblSubsection);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		//load the question
		JLabel lblQuestion = new JLabel("How much is 2+2?");
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.SOUTH, lblQuestion, 0, SpringLayout.SOUTH, lblQ);
		add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAnswer, 19, SpringLayout.SOUTH, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, lblAnswer, 0, SpringLayout.WEST, lblSub);
		add(lblAnswer);
		
		//load the possible answers with the count
		PossibleAnswers panel = new PossibleAnswers(3);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, lblAnswer);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		add(panel);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -44, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 440, SpringLayout.WEST, this);		
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		buttonsPanel.add(btnAdd);
		buttonsPanel.add(btnDelete);
		buttonsPanel.add(btnEdit);

	}
	
	//for each possible answer set a radio button
	 public class PossibleAnswers extends JPanel {

	        private JPanel answers;
	        private int count;

	        public PossibleAnswers(int num) {
	            setLayout(new BorderLayout());

	            answers = new JPanel(new GridBagLayout());
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridwidth = GridBagConstraints.REMAINDER;
	            gbc.weightx = 20;
	            gbc.weighty = 20;
	            
	            answers.add(new JPanel(), gbc);
	            count=num;
	            add(new JScrollPane(answers));

	                	
	                	for (int i=0; i<count; i++)
	                	{
	                		//JRadioButton
		                    JPanel panel = new JPanel();
		                    JCheckBox rdbtn =new JCheckBox("...");	     //set the possible answer ex. true/false           
		                    panel.add(rdbtn);
		                    GridBagConstraints gbc1 = new GridBagConstraints();
		                    gbc1.gridwidth = GridBagConstraints.REMAINDER;
		                    gbc1.weightx = 1;
		                    gbc1.weighty = 1;
		                    gbc1.anchor=GridBagConstraints.NORTHWEST;
		                    answers.add(panel, gbc1, i);
		                    
		                    validate();
		                    repaint();
	                	}
	        }

	        @Override
	        public Dimension getPreferredSize() {
	            return new Dimension(200, 200);
	        }
	    }
}
