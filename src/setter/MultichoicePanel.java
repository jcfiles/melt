package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.MatteBorder;

public class MultichoicePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MultichoicePanel() {
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
		
		JLabel lblQuestion = new JLabel("How much is 2+2?");
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.SOUTH, lblQuestion, 0, SpringLayout.SOUTH, lblQ);
		add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAnswer, 19, SpringLayout.SOUTH, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, lblAnswer, 0, SpringLayout.WEST, lblSub);
		add(lblAnswer);
		
		PossibleAnswers panel = new PossibleAnswers(3);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 19, SpringLayout.SOUTH, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, panel, 46, SpringLayout.EAST, lblAnswer);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -27, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 297, SpringLayout.EAST, lblAnswer);
		add(panel);

	}
	
	 public class PossibleAnswers extends JPanel {

	        private JPanel answers;
	        private int count;

	        public PossibleAnswers(int num) {
	            setLayout(new BorderLayout());

	            answers = new JPanel(new GridBagLayout());
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridwidth = GridBagConstraints.REMAINDER;
	            gbc.weightx = 1;
	            gbc.weighty = 1;
	            answers.add(new JPanel(), gbc);
	            count=num;
	            add(new JScrollPane(answers));

	                	
	                	for (int i=0; i<count; i++)
	                	{
	                		//JRadioButton
		                    JPanel panel = new JPanel();
		                    JRadioButton rdbtn =new JRadioButton("...");	                
		                    panel.add(rdbtn);
		                    //panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
		                    GridBagConstraints gbc1 = new GridBagConstraints();
		                    gbc1.gridwidth = GridBagConstraints.REMAINDER;
		                    gbc1.weightx = 1;
		                    gbc1.fill = GridBagConstraints.HORIZONTAL;
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
