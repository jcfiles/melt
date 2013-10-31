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

import org.omg.CORBA.Current;

import student.TestSectionPanel;
import backend.Answer;
import backend.EssayQ;
import backend.FIBQ;
import backend.InvalidFTBQFormatException;
import backend.MCQ;
import backend.Question;
import backend.SlotQ;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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
	public ButtonGroup group_type = new ButtonGroup();
	private JRadioButton rdbtnMultipleChoice = new JRadioButton("Multiple choice");
	private JRadioButton rdbtnFillBlanks = new JRadioButton("Fill blanks");
	private JRadioButton rdbtnEssay = new JRadioButton("Essay ");
	private JRadioButton rdbtnSlot = new JRadioButton("Slot");
	private JButton btnSave = new JButton("Save");
	private Boolean bEdit=false;
	private AddMCQ mcqPanel;
	private ArrayList<String> list;
	private JLabel lblTitle =new JLabel("TestA: SectionA");
	private AddEssay essayPanel;

	/**
	 * Create the buttonsPanel.
	 */
	public AddQuestionPanel(final SetterTestController obj, final SetterGUI gui, Boolean b) {
		setLayout(new BorderLayout(20, 20));
		
		//Title panel
		JPanel titlePanel = new JPanel();		
		add(titlePanel, BorderLayout.NORTH);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{0};
		gbl_titlePanel.rowHeights = new int[]{10,10};
		gbl_titlePanel.columnWeights = new double[]{0.0};
		gbl_titlePanel.rowWeights = new double[]{Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
						
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 1;	
		lblTitle.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		titlePanel.add(lblTitle,gbc_lbl);				
		
		
		JPanel centerPanel = new JPanel();	
		add(centerPanel, BorderLayout.CENTER);

		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnFillBlanks, 179, SpringLayout.NORTH, centerPanel );
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMultipleChoice, 150, SpringLayout.NORTH, centerPanel );
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnSlot, 0, SpringLayout.NORTH, rdbtnFillBlanks);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnSlot, 0, SpringLayout.WEST, rdbtnEssay);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnEssay, 0, SpringLayout.NORTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnEssay, 45, SpringLayout.EAST, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnFillBlanks, 0, SpringLayout.WEST, txtQuestion);
		springLayout.putConstraint(SpringLayout.SOUTH, txtQuestion, -21, SpringLayout.NORTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.EAST, txtQuestion, -30, SpringLayout.EAST, centerPanel );
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMultipleChoice, 0, SpringLayout.WEST, txtQuestion);
		centerPanel.setLayout(springLayout);
		
		bEdit=b;
		
		final JLabel lblFill = new JLabel("*insert the answer like e.x[answer]");
		lblFill.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.NORTH, txtQuestion, 23, SpringLayout.SOUTH, lblFill);
		lblFill.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblFill, 10, SpringLayout.NORTH, centerPanel );
		springLayout.putConstraint(SpringLayout.EAST, lblFill, -10, SpringLayout.EAST, centerPanel );
		centerPanel.add(lblFill);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, txtQuestion, 33, SpringLayout.EAST, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 10, SpringLayout.WEST, centerPanel );
		springLayout.putConstraint(SpringLayout.NORTH, lblQuestion, 47, SpringLayout.NORTH, centerPanel );
		centerPanel.add(lblQuestion);
		txtQuestion.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtQuestion.setLineWrap(true);
		txtQuestion.setWrapStyleWord(true);
		centerPanel.add(txtQuestion);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblType, 4, SpringLayout.NORTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.WEST, lblType, 0, SpringLayout.WEST, lblQuestion);
		centerPanel.add(lblType);
		rdbtnMultipleChoice.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		
		rdbtnMultipleChoice.setSelected(true);
		centerPanel.add(rdbtnMultipleChoice);
		rdbtnFillBlanks.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(rdbtnFillBlanks);
		rdbtnEssay.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(rdbtnEssay);
		rdbtnSlot.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(rdbtnSlot);
		
		//Add to button group		
		group_type.add(rdbtnFillBlanks);
		group_type.add(rdbtnMultipleChoice);
		group_type.add(rdbtnEssay);
		group_type.add(rdbtnSlot);
		
		JLabel lblMarks = new JLabel("Marks:");
		lblMarks.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblMarks, 0, SpringLayout.WEST, lblQuestion);
		centerPanel.add(lblMarks);
		
		txtMarks = new JTextField();
		txtMarks.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.NORTH, txtMarks, 218, SpringLayout.NORTH, centerPanel );
		springLayout.putConstraint(SpringLayout.NORTH, lblMarks, 3, SpringLayout.NORTH, txtMarks);
		springLayout.putConstraint(SpringLayout.WEST, txtMarks, 0, SpringLayout.WEST, txtQuestion);
		springLayout.putConstraint(SpringLayout.EAST, txtMarks, -30, SpringLayout.EAST, centerPanel );
		centerPanel.add(txtMarks);
		txtMarks.setColumns(10);
		
		//If the user selects multiple choice
		final JPanel panel_mult = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_mult, 14, SpringLayout.SOUTH, lblMarks);
		springLayout.putConstraint(SpringLayout.WEST, panel_mult, 0, SpringLayout.WEST, centerPanel );
		springLayout.putConstraint(SpringLayout.SOUTH, panel_mult, -49, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, panel_mult, 0, SpringLayout.EAST, centerPanel );
		centerPanel.add(panel_mult);
		panel_mult.setLayout(new BorderLayout(0, 0));
		
		mcqPanel=new AddMCQ(list,gui,bEdit);
		panel_mult.add(mcqPanel);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, 6, SpringLayout.SOUTH, panel_mult);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 0, SpringLayout.WEST, lblQuestion);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, lblFill);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		centerPanel.add(buttonsPanel);
		btnSave.setFont(new Font("MV Boli", Font.PLAIN, 15));
		btnSave.setPreferredSize(new Dimension(100, 35));
		
		buttonsPanel.add(btnSave);
		
		
		/*
		 * final JPanel panel_mult = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_mult, 14, SpringLayout.SOUTH, lblMarks);
		springLayout.putConstraint(SpringLayout.WEST, panel_mult, 0, SpringLayout.WEST, centerPanel );
		springLayout.putConstraint(SpringLayout.EAST, panel_mult, 0, SpringLayout.EAST, centerPanel );
		centerPanel.add(panel_mult);
		panel_mult.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, 455, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_mult, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 0, SpringLayout.WEST, lblQuestion );
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, lblFill);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		centerPanel.add(buttonsPanel);
		btnSave.setFont(new Font("MV Boli", Font.PLAIN, 15));
		btnSave.setPreferredSize(new Dimension(100, 35));
		
		buttonsPanel.add(btnSave);
		 */
		
		
		
	
		if(bEdit==true)
		{
			
			list=obj.getQuestion(gui.current.getUserObject());
			txtMarks.setText(list.get(0));
			//txtSubsection.setText(list.get(1));
			
			if(gui.current.getUserObject() instanceof FIBQ)
			{
				rdbtnMultipleChoice.setSelected(false);
				rdbtnFillBlanks.setSelected(true);
				rdbtnEssay.setSelected(false);
				rdbtnSlot.setSelected(false);
				
				txtQuestion.setText(list.get(1)+ "["+list.get(2)+ "]"+list.get(3));				
				typeQuestion=1;				
				panel_mult.setVisible(false);
			}
			if(gui.current.getUserObject() instanceof MCQ)			
			{
				rdbtnMultipleChoice.setSelected(true);
				rdbtnFillBlanks.setSelected(false);
				rdbtnEssay.setSelected(false);
				rdbtnSlot.setSelected(false);
				
				typeQuestion=0;				
				
				panel_mult.setVisible(true);
				mcqPanel=new AddMCQ(list,gui,bEdit);
		    	
		    	panel_mult.removeAll();
				panel_mult.add(mcqPanel);
												
				panel_mult.validate();
				panel_mult.repaint();
				
				txtQuestion.setText(list.get(1));
				
				
				
			}		
			if(gui.current.getUserObject() instanceof EssayQ)			
			{
				rdbtnMultipleChoice.setSelected(false);
				rdbtnFillBlanks.setSelected(false);
				rdbtnEssay.setSelected(true);
				rdbtnSlot.setSelected(false);
				
				typeQuestion=2;	
				
				panel_mult.setVisible(true);				
				essayPanel=new AddEssay(list,bEdit);
		    	
		    	panel_mult.removeAll();
		    	panel_mult.add(essayPanel);
												
				panel_mult.validate();
				panel_mult.repaint();
				
				txtQuestion.setText(list.get(1));
	
			}	
			
			if(gui.current.getUserObject() instanceof SlotQ)			
			{
				rdbtnMultipleChoice.setSelected(false);
				rdbtnFillBlanks.setSelected(false);
				rdbtnEssay.setSelected(false);
				rdbtnSlot.setSelected(true);
				
				txtQuestion.setText(list.get(1));				
				typeQuestion=1;				
				panel_mult.setVisible(false);
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
		    	
		    	essayPanel=new AddEssay(list,bEdit);
		    	
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
		    	typeQuestion=3;		
		    	
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
	    		  if(txtQuestion.getText().equals("")|| txtMarks.getText().equals("")|| mcqPanel.possibleAnswers.getRowCount()==0)
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
	    			Question q = null;
	    			//updateQuestion
	    			 if(typeQuestion==0) //multiple choice question
	   	    	  	{	
	    				q=obj.editMCQ(gui.current.getUserObject(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()), mcqPanel.possibleAnswers);
	    				 MultichoicePanel multiPanel=new MultichoicePanel(obj,gui);
	    		        gui.centerPanel.removeAll();
	    		        gui.centerPanel.add(multiPanel);
	   	    	  	}
	    			 if(typeQuestion==1)	    			
	    			 {
	    				 q=obj.editFIBQ(gui.current.getUserObject(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()));
	    				 
	    				 if(q==null)
	    				 {
	    					 JOptionPane.showMessageDialog(gui,
	   		    			      "You have to insert the answer of the Fill the Blank Question like eg.[answer]",
	   		    			      "Question parsing Error",
	   		    			      JOptionPane.ERROR_MESSAGE);
	    				 }
	    				 else{
	    				 FillBlankPanel fillPanel=new FillBlankPanel(obj,gui);
		    			 gui.centerPanel.removeAll();
		    			 gui.centerPanel.add(fillPanel);
	    				 }
	    				 
		    		 }	
	    			 
	    			 if(typeQuestion==2)
	    			 {
	    				 q=obj.editEssayQ(gui.current.getUserObject(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()),Integer.parseInt(essayPanel.txtHeight.getText()), Integer.parseInt(essayPanel.txtWidth.getText()),Integer.parseInt(essayPanel.txtWordLimit.getText())); 
	    				 
	    			 }
	    			
	    			 if(typeQuestion==3)
	    			 {
	    				 q=obj.editSlotQ(gui.current.getUserObject(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText())); 
	    				 
	    			 }
	    			 gui.updateQuestion(q);
	    			 gui.centerPanel.validate();
	    			 gui.centerPanel.repaint();
		    	  
	    		}
	    		else  //bEdit==false
	    		{
	    			
	    		if(typeQuestion==0) //multiple choice question
	    		{	        	
	    			Question q=obj.addMCQ(gui.parent.getUserObject(),txtQuestion.getText(), Integer.parseInt(txtMarks.getText()), mcqPanel.possibleAnswers);
	    			gui.setTree(q);
	    			MultichoicePanel multiPanel=new MultichoicePanel(obj,gui);	        	
	    			gui.centerPanel.removeAll();
	    			gui.centerPanel.add(multiPanel);
	    	   }
	    	  
	    		if(typeQuestion==1){
	    			
	    		  Question q=obj.addFIBQ(gui.parent.getUserObject(),txtQuestion.getText(), Integer.parseInt(txtMarks.getText()));
	    		  if(q==null)
	    		  	{
	    			  JOptionPane.showMessageDialog(gui,
		    			      "You have to insert the answer of the Fill the Blank Question like eg.[answer]",
		    			      "Question parsing Error",
		    			      JOptionPane.ERROR_MESSAGE);
	    		  	}	 
	    		  	else
	    		  	{
	    		  		gui.setTree(q);
	    			  	FillBlankPanel fillPanel=new FillBlankPanel(obj,gui);
	    			  	gui.centerPanel.removeAll();
	  	        		gui.centerPanel.add(fillPanel);
	    		  	}
	    		  
	        	}
	    		
	    		if(typeQuestion==2) //multiple choice question
	    		{	  
	    			if(essayPanel.txtHeight.getText().equals("")|| essayPanel.txtWidth.getText().equals("") || essayPanel.txtWordLimit.getText().equals(""))
		    		  {
		    			//insert all the information, error icon
		    			  JOptionPane.showMessageDialog(gui,
		    			      "You have to insert all the information for the Question.",
		    			      "Save Question Error",
		    			      JOptionPane.ERROR_MESSAGE);
		    			  flag=true;
		    		  }
	    			if(flag==false)
	    			{
	    				 try {
	       				  Integer.parseInt(essayPanel.txtHeight.getText());
	       					
	       				} catch (Exception ex) {
	       					//insert number for a mark, error icon
	       					JOptionPane.showMessageDialog(gui,
	       		    			      "You have to insert a numbers for the Extra information of the Essay Question.",
	       		    			      "Save Mark for Question Error",
	       		    			      JOptionPane.ERROR_MESSAGE);
	       					flag=true;
	       				}	
	    			}
	    			if(flag==false)
	    			{
	    				 try {
	       				  Integer.parseInt(essayPanel.txtWordLimit.getText());
	       					
	       				} catch (Exception ex) {
	       					//insert number for a mark, error icon
	       					JOptionPane.showMessageDialog(gui,
	       							"You have to insert a numbers for the Extra information of the Essay Question.",
	       		    			      "Save Mark for Question Error",
	       		    			      JOptionPane.ERROR_MESSAGE);
	       					flag=true;
	       				}	
	    			}
	    			
	    			if(flag==false)
	    			{
	    				 try {
	       				  Integer.parseInt(essayPanel.txtWidth.getText());
	       					
	       				} catch (Exception ex) {
	       					//insert number for a mark, error icon
	       					JOptionPane.showMessageDialog(gui,
	       							"You have to insert a numbers for the Extra information of the Essay Question.",
	       		    			      "Save Mark for Question Error",
	       		    			      JOptionPane.ERROR_MESSAGE);
	       					flag=true;
	       				}	
	    			}
	    			
	    			if(flag==false)
	    			{
	    				Question q=obj.addEssayQ(gui.parent.getUserObject(),txtQuestion.getText(), Integer.parseInt(txtMarks.getText()),Integer.parseInt(essayPanel.txtHeight.getText()), Integer.parseInt(essayPanel.txtWidth.getText()),Integer.parseInt(essayPanel.txtWordLimit.getText()));
	    				gui.setTree(q);
	    				EssayQuestionPanel panel=new EssayQuestionPanel(obj,gui);	        	
	    				gui.centerPanel.removeAll();
	    				gui.centerPanel.add(panel);
	    			}
	    	   }
	    		
	    		if(typeQuestion==3){
	    			
		    		  Question q=obj.addSlotQ(gui.parent.getUserObject(),txtQuestion.getText(), Integer.parseInt(txtMarks.getText()));
		    		  if(q==null)
		    		  	{
		    			  JOptionPane.showMessageDialog(gui,
			    			      "You have to insert the answer of the Slot Question like eg.[answer]",
			    			      "Question parsing Error",
			    			      JOptionPane.ERROR_MESSAGE);
		    		  	}	 
		    		  	else
		    		  	{
		    		  		gui.setTree(q);
		    			  	SlotQPanel panel=new SlotQPanel(obj,gui);
		    			  	gui.centerPanel.removeAll();
		  	        		gui.centerPanel.add(panel);
		    		  	}
		    		  
		        	}
	    		
	        
	    	  gui.centerPanel.validate();
	    	  gui.centerPanel.repaint();	    	        
	        
	    		}
	    	  }
	      }
	    });
	
	}	
}
