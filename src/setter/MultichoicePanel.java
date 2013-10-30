package setter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import backend.MCQ;
import backend.Question;
import backend.Section;

/*
 * @author Erotokritou Zoe
 */
public class MultichoicePanel extends JPanel {

	final JButton btnDelete = new JButton("Delete");
	final JButton btnEdit = new JButton("Edit");
	final JButton btnAdd = new JButton("Add New Question");
	private PossibleAnswers panel;
	private JLabel lblMarks;
	private JLabel lblQuestion;
	private ArrayList<String> list = new ArrayList<String>();
	private SetterTestController obj;
	private SetterGUI gui;
	
	
	/**
	 * Create the panel.
	 */
	public MultichoicePanel(final SetterTestController o,final SetterGUI g) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		obj=o;
		gui=g;
		
		//load the marks of the question
		lblMarks = new JLabel("Marks: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblMarks, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblMarks, -10, SpringLayout.EAST, this);
		add(lblMarks);
		
		JLabel lblQ = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		//load the question
		lblQuestion = new JLabel("Q1");
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 39, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.SOUTH, lblQuestion, 0, SpringLayout.SOUTH, lblQ);
		add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAnswer, 19, SpringLayout.SOUTH, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, lblAnswer, 10, SpringLayout.WEST, this);
		add(lblAnswer);
		
		
		//Set text to all the labels
		list=obj.getQuestion(gui.current.getUserObject());
		
		lblMarks.setText("Marks: "+ list.get(0));
		lblQuestion.setText(list.get(1));
		panel = new PossibleAnswers(list.size()-2);
		
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, lblAnswer);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblQuestion);
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
		
		
		btnAdd.addActionListener(new ActionListener(){  //button to add new question
		      public void actionPerformed(ActionEvent e) {
		        
		    	  AddQuestionPanel addPanel=new AddQuestionPanel(obj,gui,false);
		    	  
		    	  gui.centerPanel.removeAll();
		    	  gui.centerPanel.add(addPanel);
		                           
		    	  gui.centerPanel.validate();
		    	  gui.centerPanel.repaint();
		      }
		    });

		btnDelete.addActionListener(new ActionListener(){  //Delete the question
		       public void actionPerformed(ActionEvent e) {
		         
		    	 //default icon, custom title
					int n = JOptionPane.showConfirmDialog(
					    gui,
					    "Are you sure that you whant to delete the Question?",
					    "Delete Question",
					    JOptionPane.YES_NO_OPTION);
					
					if(n==JOptionPane.YES_OPTION)
					{
						obj.deleteQuestion();
						
						/*if(obj.getCurrentQuestion()==obj.countQuestion())
						{
							obj.setCurrentQuestion(obj.getCurrentQuestion()-1);
						}
						*/
						if(obj.getQuestionType()==0)
						{
							MultichoicePanel panel=new MultichoicePanel(obj,gui);
							gui.centerPanel.removeAll();
							gui.centerPanel.add(panel);
						}
						else
						{
							FillBlankPanel panel=new FillBlankPanel(obj,gui);
							gui.centerPanel.removeAll();
							gui.centerPanel.add(panel);
						}
					
						
						gui.validate();
						gui.repaint();
					}										
		       }
		    });
		
		btnEdit.addActionListener(new ActionListener(){  //Edit the question
	        public void actionPerformed(ActionEvent e) {

	        	AddQuestionPanel addPanel=new AddQuestionPanel(obj,gui,true);
	        	gui.centerPanel.removeAll();
	        	gui.centerPanel.add(addPanel);
	         
	        	gui.centerPanel.validate();
	        	gui.centerPanel.repaint();
	        
	       }
	    });
		
		

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

	                	
	                	for (int i=0; i<count; i=i+2)
	                	{
	                		//JRadioButton
		                    JPanel panel = new JPanel();
		                    JCheckBox rdbtn =new JCheckBox(list.get(2+i));	     //set the possible answer ex. true/false           
		                    panel.add(rdbtn);
		                    GridBagConstraints gbc1 = new GridBagConstraints();
		                    gbc1.gridwidth = GridBagConstraints.REMAINDER;
		                    gbc1.weightx = 1;
		                    gbc1.weighty = 1;
		                    gbc1.anchor=GridBagConstraints.NORTHWEST;
		                    answers.add(panel, gbc1, i/2);
		                    
		                    this.validate();
		                    this.repaint();
	                	}
	        }

	        @Override
	        public Dimension getPreferredSize() {
	            return new Dimension(200, 200);
	        }
	    }
}
