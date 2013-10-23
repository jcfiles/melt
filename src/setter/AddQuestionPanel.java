package setter;


import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import student.TestSectionPanel;
import backend.Answer;
import backend.FIBQ;
import backend.InvalidFTBQFormatException;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;


/*
 * @author Erotokritou Zoe
 */

public class AddQuestionPanel extends JPanel {
	private JTextField txtMarks;
	private JTextArea txtQuestion = new JTextArea();
	private int typeQuestion=0;
	private JTable possibleAnswers;
	public ButtonGroup group_type = new ButtonGroup();
	private JRadioButton rdbtnMultipleChoice = new JRadioButton("Multiple choice");
	private JRadioButton rdbtnFillBlanks = new JRadioButton("Fill blanks");
	private JRadioButton rdbtnEssay = new JRadioButton("Essay ");
	private JRadioButton rdbtnSlot = new JRadioButton("Slot");
	private JButton btnSave = new JButton("Save");
	private Boolean bEdit=false;
	private AddMCQ mcqPanel;
	private ArrayList<String> list;

	/**
	 * Create the buttonsPanel.
	 */
	public AddQuestionPanel(final SetterTestController obj, final AddQuestionGUI gui, Boolean b) {
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnFillBlanks, 179, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMultipleChoice, 150, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnSlot, 0, SpringLayout.NORTH, rdbtnFillBlanks);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnSlot, 0, SpringLayout.WEST, rdbtnEssay);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnEssay, 0, SpringLayout.NORTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnEssay, 45, SpringLayout.EAST, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnFillBlanks, 0, SpringLayout.WEST, txtQuestion);
		springLayout.putConstraint(SpringLayout.SOUTH, txtQuestion, -21, SpringLayout.NORTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.EAST, txtQuestion, -30, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMultipleChoice, 0, SpringLayout.WEST, txtQuestion);
		setLayout(springLayout);
		
		bEdit=b;
		final JLabel lblFill = new JLabel("*insert the answer like e.x[answer]");
		springLayout.putConstraint(SpringLayout.NORTH, txtQuestion, 23, SpringLayout.SOUTH, lblFill);
		lblFill.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblFill, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblFill, -10, SpringLayout.EAST, this);
		add(lblFill);
		
		JLabel lblQuestion = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.WEST, txtQuestion, 33, SpringLayout.EAST, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblQuestion, 47, SpringLayout.NORTH, this);
		add(lblQuestion);
		txtQuestion.setLineWrap(true);
		txtQuestion.setWrapStyleWord(true);
		add(txtQuestion);
		
		JLabel lblType = new JLabel("Type:");
		springLayout.putConstraint(SpringLayout.WEST, lblType, 0, SpringLayout.WEST, lblQuestion);
		springLayout.putConstraint(SpringLayout.SOUTH, lblType, -406, SpringLayout.SOUTH, this);
		add(lblType);
		
		
		rdbtnMultipleChoice.setSelected(true);
		add(rdbtnMultipleChoice);
		add(rdbtnFillBlanks);
		add(rdbtnEssay);
		add(rdbtnSlot);
		
		//Add to button group		
		group_type.add(rdbtnFillBlanks);
		group_type.add(rdbtnMultipleChoice);
		group_type.add(rdbtnEssay);
		group_type.add(rdbtnSlot);
		
		JLabel lblMarks = new JLabel("Marks:");
		springLayout.putConstraint(SpringLayout.WEST, lblMarks, 0, SpringLayout.WEST, lblQuestion);
		add(lblMarks);
		
		txtMarks = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtMarks, 218, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblMarks, 3, SpringLayout.NORTH, txtMarks);
		springLayout.putConstraint(SpringLayout.WEST, txtMarks, 0, SpringLayout.WEST, txtQuestion);
		springLayout.putConstraint(SpringLayout.EAST, txtMarks, -30, SpringLayout.EAST, this);
		add(txtMarks);
		txtMarks.setColumns(10);
		
		//If the user selects multiple choice
		final JPanel panel_mult = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_mult, 20, SpringLayout.SOUTH, txtMarks);
		springLayout.putConstraint(SpringLayout.WEST, panel_mult, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_mult, 0, SpringLayout.EAST, this);
		add(panel_mult);
		panel_mult.setLayout(new BorderLayout(0, 0));
		
		mcqPanel=new AddMCQ(list,gui,bEdit);
		panel_mult.add(mcqPanel);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_mult, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, -22, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -43, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, -10, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		buttonsPanel.add(btnSave);
		
		
		
	
		if(bEdit==true)
		{
			
			list=obj.getQuestion();
			txtMarks.setText(list.get(0));
			//txtSubsection.setText(list.get(1));
			
			if(obj.getQuestionType()==1)
			{
				txtQuestion.setText(list.get(2)+ "["+list.get(3)+ "]"+list.get(4));	
				rdbtnMultipleChoice.setSelected(false);
				rdbtnFillBlanks.setSelected(true);
				typeQuestion=1;
				
				panel_mult.setVisible(false);
			}
			else
			{
				typeQuestion=0;
				rdbtnMultipleChoice.setSelected(true);
				rdbtnFillBlanks.setSelected(false);
				panel_mult.setVisible(true);
				
				txtQuestion.setText(list.get(2));
				
				
			}			
			
		}
		
		
		//radio button listener to make things visible and unvisible
		rdbtnMultipleChoice.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		 
		    	lblFill.setVisible(false);		    	
		    	typeQuestion=0;		    
		    	
		    	mcqPanel=new AddMCQ(list,gui,bEdit);
		    	
		    	panel_mult.removeAll();
				panel_mult.add(mcqPanel);
												
				panel_mult.validate();
				panel_mult.repaint();
				
			    }
		});
		
		//radio button listener to make things visible and unvisible
		rdbtnFillBlanks.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	
		    	lblFill.setVisible(true);	    	
		    	typeQuestion=1;		
		    	
		    	panel_mult.removeAll();
												
				panel_mult.validate();
				panel_mult.repaint();
		    	
			    }
		});
		
		rdbtnEssay.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    
		    	lblFill.setVisible(false);	    	
		    	typeQuestion=2;		
		    	
		    	AddEssay essayPanel=new AddEssay(obj);
		    	
		    	panel_mult.removeAll();
		    	panel_mult.add(essayPanel);
												
				panel_mult.validate();
				panel_mult.repaint();
		    	
			    }
		});
		
		rdbtnSlot.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(false);
		    	lblFill.setVisible(true);	    	
		    	typeQuestion=1;		
		    	
		    	panel_mult.removeAll();
												
				panel_mult.validate();
				panel_mult.repaint();
		    	
			    }
		});

		
		//button Listeners
	    btnSave.addActionListener(new ActionListener(){  //button to save the question
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	  Boolean flag=false;
	    	  
	    	  
	    	  if(typeQuestion==0)
	    	  {
	    		  if(txtQuestion.getText().equals("")|| txtMarks.getText().equals("")|| possibleAnswers.getRowCount()==0)
	    		  {
	    			//insert all the information, error icon
	    			  JOptionPane.showMessageDialog(gui,
	    			      "You have to insert all the information for the Question.",
	    			      "Save Question Error",
	    			      JOptionPane.ERROR_MESSAGE);
	    			  flag=true;
	    		  }	    		  
	    	  }
	    	  else
	    	  {
	    		  if(txtQuestion.getText().equals("")|| txtMarks.getText().equals(""))
	    		  {
	    			//insert all the information, error icon
	    			  JOptionPane.showMessageDialog(gui,
	    			      "You have to insert all the information for the Question.",
	    			      "Save Question Error",
	    			      JOptionPane.ERROR_MESSAGE);
	    			  flag=true;
	    		  }
	    	  }
	    	  
	    	  if(flag==false)
    		  {
    			  try {
    				  Integer.parseInt(txtMarks.getText());
    					
    				} catch (Exception ex) {
    					//insert number for a mark, error icon
    					JOptionPane.showMessageDialog(gui,
    		    			      "You have to insert a number for a Mark.",
    		    			      "Save Mark for Question Error",
    		    			      JOptionPane.ERROR_MESSAGE);
    					flag=true;
    				}			
    		  }
	    	  
	    	  if(flag==false){
	    		  
	    		if(bEdit==true)
	    		{
	    			 if(typeQuestion==0) //multiple choice question
	   	    	  	{	
	    				// obj.editMCQ(txtSubsection.getText(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()), possibleAnswers);
	    				 MultichoicePanel multiPanel=new MultichoicePanel(obj,gui);
	    		        gui.panelCenter.removeAll();
	    		        gui.panelCenter.add(multiPanel);
	   	    	  	}
	    			 else
	    			 {	    			
		    			/*int parsingCorrect=obj.editFIBQ(txtSubsection.getText(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()));
	    				 
	    				 if(parsingCorrect==0)
	    				 {
	    					 JOptionPane.showMessageDialog(gui,
	   		    			      "You have to insert the answer of the Fill the Blank Question like eg.[answer]",
	   		    			      "Question parsing Error",
	   		    			      JOptionPane.ERROR_MESSAGE);
	    				 }
	    				 else{
	    				 FillBlankPanel fillPanel=new FillBlankPanel(obj,gui);
		    			 gui.panelCenter.removeAll();
		    			 gui.panelCenter.add(fillPanel);
	    				 }
	    				 */
		    		 }		       
	    			 
		    	  gui.validate();
		    	  gui.repaint();
		    	  
	    		}
	    		else
	    		{
	    			
	    	  if(typeQuestion==0) //multiple choice question
	    	  {	        	
	        	//obj.addMCQ(txtSubsection.getText(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()), possibleAnswers);
	        	MultichoicePanel multiPanel=new MultichoicePanel(obj,gui);
	        	gui.panelCenter.removeAll();
	        	gui.panelCenter.add(multiPanel);
	    	  }
	    	  else
	    	  {	 /*
	    		  int parsing=obj.addFIBQ(txtSubsection.getText(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()));
	    		  if(parsing==0)
	    		  {
	    			  JOptionPane.showMessageDialog(gui,
		    			      "You have to insert the answer of the Fill the Blank Question like eg.[answer]",
		    			      "Question parsing Error",
		    			      JOptionPane.ERROR_MESSAGE);
	    		  }	 
	    		  else
	    		  {
	    			  	FillBlankPanel fillPanel=new FillBlankPanel(obj,gui);
	    			  	gui.panelCenter.removeAll();
	  	        		gui.panelCenter.add(fillPanel);
	    		  }
	    		  */
	        	}
	        
	    	  gui.validate();
	    	  gui.repaint();	    	        
	        
	    		}
	    	  }
	      }
	    });
	
	}	
}
