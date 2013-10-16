package setter;


import javax.swing.ButtonGroup;
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


/*
 * @author Erotokritou Zoe
 */

public class AddQuestionPanel extends JPanel {
	private JTextField txtSubsection;
	private JTextField txtMarks;
	private JTextArea txtQuestion = new JTextArea();
	private Boolean bMCQ=true;
	private JTable possibleAnswers;
	public ButtonGroup group_type = new ButtonGroup();
	private JRadioButton rdbtnMultipleChoice = new JRadioButton("Multiple choice");
	private JRadioButton rdbtnFillBlanks = new JRadioButton("Fill blanks");
	private JButton btnSave = new JButton("Save");
	private String header[] = new String[]{"Answer","Correct"};
	private DefaultTableModel model;
	private ImageIcon correctAnswerImage,wrongAnswerImage;
	private Object[][] data;
	private Boolean bEdit=false;


	/**
	 * Create the buttonsPanel.
	 */
	public AddQuestionPanel(final SetterTestController obj, final AddQuestionGUI gui, Boolean b) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		bEdit=b;
		final JLabel lblFill = new JLabel("*insert the answer like e.x[answer]");
		lblFill.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblFill, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblFill, -10, SpringLayout.EAST, this);
		add(lblFill);
		
		JLabel lblSubsection = new JLabel("Subsection:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		add(lblSubsection);
		
		txtSubsection = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtSubsection, -3, SpringLayout.NORTH, lblSubsection);
		springLayout.putConstraint(SpringLayout.WEST, txtSubsection, 32, SpringLayout.EAST, lblSubsection);
		springLayout.putConstraint(SpringLayout.EAST, txtSubsection, -22, SpringLayout.EAST, this);
		add(txtSubsection);
		txtSubsection.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQuestion, 18, SpringLayout.SOUTH, lblSubsection);
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 10, SpringLayout.WEST, this);
		add(lblQuestion);
		
		springLayout.putConstraint(SpringLayout.NORTH, txtQuestion, 15, SpringLayout.SOUTH, txtSubsection);
		springLayout.putConstraint(SpringLayout.WEST, txtQuestion, 0, SpringLayout.WEST, txtSubsection);
		springLayout.putConstraint(SpringLayout.EAST, txtQuestion, -22, SpringLayout.EAST, this);
		txtQuestion.setLineWrap(true);
		txtQuestion.setWrapStyleWord(true);
		add(txtQuestion);
		
		JLabel lblType = new JLabel("Type:");
		springLayout.putConstraint(SpringLayout.NORTH, lblType, 84, SpringLayout.SOUTH, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, lblType, 0, SpringLayout.WEST, lblSubsection);
		add(lblType);
		
		
		rdbtnMultipleChoice.setSelected(true);
		springLayout.putConstraint(SpringLayout.SOUTH, txtQuestion, -12, SpringLayout.NORTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMultipleChoice, -4, SpringLayout.NORTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMultipleChoice, 52, SpringLayout.EAST, lblType);
		add(rdbtnMultipleChoice);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnFillBlanks, 11, SpringLayout.SOUTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnFillBlanks, 91, SpringLayout.WEST, this);
		add(rdbtnFillBlanks);
		
		//Add to button group		
		group_type.add(rdbtnFillBlanks);
		group_type.add(rdbtnMultipleChoice);
		
		JLabel lblMarks = new JLabel("Marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblMarks, 58, SpringLayout.SOUTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, lblMarks, 0, SpringLayout.WEST, lblSubsection);
		add(lblMarks);
		
		txtMarks = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtMarks, 13, SpringLayout.SOUTH, rdbtnFillBlanks);
		springLayout.putConstraint(SpringLayout.WEST, txtMarks, 56, SpringLayout.EAST, lblMarks);
		springLayout.putConstraint(SpringLayout.EAST, txtMarks, 0, SpringLayout.EAST, txtSubsection);
		add(txtMarks);
		txtMarks.setColumns(10);
		
		//If the user selects multiple choice
		final JPanel panel_mult = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_mult, 16, SpringLayout.SOUTH, lblMarks);
		springLayout.putConstraint(SpringLayout.WEST, panel_mult, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.EAST, panel_mult, 0, SpringLayout.EAST, txtSubsection);
		add(panel_mult);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_mult.setLayout(sl_panel_1);
		
		//Add scrollPane for table
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel_mult);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, panel_mult);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, -96, SpringLayout.EAST, panel_mult);
		panel_mult.add(scrollPane);

		data = new Object[0][0];
		model = new DefaultTableModel(data,header);  		  
		model.setColumnIdentifiers(header);  
		possibleAnswers = new JTable(model) {

            private static final long serialVersionUID = 1L;
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        
        possibleAnswers.isEditing();
        possibleAnswers.setRowHeight(30);
		scrollPane.setViewportView(possibleAnswers);
		
		possibleAnswers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(possibleAnswers.columnAtPoint(e.getPoint())==1){
					if(possibleAnswers.getModel().getValueAt(possibleAnswers.rowAtPoint(e.getPoint()), 1)==wrongAnswerImage){
						possibleAnswers.getModel().setValueAt(correctAnswerImage, possibleAnswers.rowAtPoint(e.getPoint()), 1);
						possibleAnswers.repaint();
					}
					else{
						possibleAnswers.getModel().setValueAt(wrongAnswerImage, possibleAnswers.rowAtPoint(e.getPoint()), 1);
						possibleAnswers.repaint();
					}
				}
				else
				{
					String temp=possibleAnswers.getModel().getValueAt(possibleAnswers.rowAtPoint(e.getPoint()), 0).toString();
					possibleAnswers.getModel().setValueAt(temp, possibleAnswers.rowAtPoint(e.getPoint()), 0);
					possibleAnswers.repaint();
				}
				
				
			}
		});
		
		correctAnswerImage=new ImageIcon(TestSectionPanel.class.getResource("/lib/images/check.png"));
		wrongAnswerImage=new ImageIcon(TestSectionPanel.class.getResource("/lib/images/delete.png"));
		
		//Add buttons
		JButton btnAdd = new JButton("Add");
		sl_panel_1.putConstraint(SpringLayout.WEST, btnAdd, 6, SpringLayout.EAST, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnAdd, -104, SpringLayout.SOUTH, panel_mult);
		btnAdd.setPreferredSize(new Dimension(80, 27));
		panel_mult.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnDelete, 6, SpringLayout.SOUTH, btnAdd);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnDelete, 6, SpringLayout.EAST, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnDelete, -10, SpringLayout.EAST, panel_mult);
		btnDelete.setPreferredSize(new Dimension(80, 27));
		panel_mult.add(btnDelete);
		
		JLabel lblPossibleAnswers = new JLabel("Possible answers:");
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblPossibleAnswers);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblPossibleAnswers, 10, SpringLayout.NORTH, panel_mult);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblPossibleAnswers, 10, SpringLayout.WEST, panel_mult);
		panel_mult.add(lblPossibleAnswers);

		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_mult, -66, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, txtSubsection);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -43, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, -10, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		buttonsPanel.add(btnSave);
		
		
		if(bEdit==true)
		{
			
			ArrayList<String> list=obj.getQuestion();
			txtMarks.setText(list.get(0));
			txtSubsection.setText(list.get(1));
			
			if(obj.getQuestionType()==1)
			{
				txtQuestion.setText(list.get(2)+ "["+list.get(3)+ "]"+list.get(4));	
				rdbtnMultipleChoice.setSelected(false);
				rdbtnFillBlanks.setSelected(true);
			}
			else
			{
				rdbtnMultipleChoice.setSelected(true);
				rdbtnFillBlanks.setSelected(false);
				
				txtQuestion.setText(list.get(2));
				
				Object[][] temp = new Object[list.size()-3][2];
				
				for(int i=3; i<list.size(); i++)
				{
					temp[i][0]=list.get(3);
					if(list.get(4).equals(true+""))
					{
						temp[i][1]=correctAnswerImage;
					}
					else
					{
						temp[i][1]=wrongAnswerImage;
					}
				}

			     DefaultTableModel model = new DefaultTableModel(temp, header); 	
			     possibleAnswers.setModel(model);
			}			
			
		}
		
		
		//radio button listener to make things visible and unvisible
		rdbtnMultipleChoice.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(true);
		    	lblFill.setVisible(false);		    	
		    	bMCQ=true;		    	
			    }
		});
		
		//radio button listener to make things visible and unvisible
		rdbtnFillBlanks.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(false);
		    	lblFill.setVisible(true);	    	
		    	bMCQ=false;		    	
			    }
		});

		
		//button Listeners
	    btnSave.addActionListener(new ActionListener(){  //button to save the question
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	  Boolean flag=false;
	    	  
	    	  
	    	  if(bMCQ==true)
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
	    	  if(bMCQ==true) //multiple choice question
	    	  {	        	
	        	obj.addMCQ(txtSubsection.getText(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()), possibleAnswers);
	        	MultichoicePanel multiPanel=new MultichoicePanel(obj,gui);
	        	gui.panelCenter.removeAll();
	        	gui.panelCenter.add(multiPanel);
	    	  }
	    	  else
	    	  {	 
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
	        	}
	        
	    	  gui.validate();
	    	  gui.repaint();	    	        
	        
	       }
	      }
	    });

	    
		
		/// clicking the Add new possible answer
		btnAdd.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	/*panel_mult.setVisible(true);
		    	panel_new.setVisible(true);
		    	lblFill.setVisible(false);
		    	*/
		    	
		    	Object[][] temp = new Object[possibleAnswers.getRowCount()+1][2];
			     
		    	int i=0;
			     for(i=0; i<possibleAnswers.getRowCount(); i++)
			     {
			    	 temp[i][0]=possibleAnswers.getModel().getValueAt(i, 0);
			    	 temp[i][1]=possibleAnswers.getModel().getValueAt(i, 1);
			     }
			     temp[i][0]="";
			     temp[i][1]=wrongAnswerImage;

			     DefaultTableModel model = new DefaultTableModel(temp, header); 	
			     possibleAnswers.setModel(model);
		    	
			    }
		});
				
	}	
}
